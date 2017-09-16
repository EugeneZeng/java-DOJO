package JavaLearning.JavaDojo;

import java.io.IOException;
import java.sql.*;
import java.util.*;
import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 * Hello world!
 *
 */
public class App {

	private Connection connection;

	public App() {
		connection = getDBConnection();
	}

	private Connection getDBConnection() {
		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:SQLite/dojo.db");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	private void inserLogEntities(ArrayList<LogEntity> logEntities) throws SQLException {
		QueryRunner run = new QueryRunner();
		ResultSetHandler<List<LogHandler>> rsh = new BeanListHandler<LogHandler>(LogHandler.class);
		String sql = "INSERT INTO LogEntities"
				+ "(ip,requestTime,requestMethod,requestPath,requestVersion,requestStatus,requestFromUrl,terminalInfor,updateTime) "
				+ "VALUES(?,?,?,?,?,?,?,?,?)";

		Object[][] params = new Object[logEntities.size()][];
		for (int i = 0; i < logEntities.size(); i++) {
			LogEntity logEntity = logEntities.get(i);
			params[i] = new Object[9];
			params[i][0] = logEntity.getIp();
			params[i][1] = logEntity.getRequestTime();
			params[i][2] = logEntity.getRequestMethod();
			params[i][3] = logEntity.getRequestPath();
			params[i][4] = logEntity.getRequestVersion();
			params[i][5] = logEntity.getRequestStatus();
			params[i][6] = logEntity.getRequestFromUrl();
			params[i][7] = logEntity.getTerminalInfor();
			params[i][8] = logEntity.getUpdateTime().getTime();
		}
		run.insertBatch(connection, sql, rsh, params);
	}

	public static void main(String[] args) throws SQLException, IOException {
		App app = new App();
		LogHandler logHandler = new LogHandler();
		ArrayList<LogEntity> logEntities = new ArrayList<LogEntity>();
		ArrayList<String> strList = logHandler.getStringListFromPath("prototype/nginx.access.log");
		for (String logStr : strList) {
			logEntities.add(logHandler.getEntity(logStr));
		}

		app.inserLogEntities(logEntities);

		System.out.println("Hello World!");
	}

}

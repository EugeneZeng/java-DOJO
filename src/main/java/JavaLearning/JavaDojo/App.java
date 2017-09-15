package JavaLearning.JavaDojo;

import java.io.IOException;
import java.sql.*;
import java.util.*;
import org.apache.commons.dbutils.*;

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
			connection = DriverManager.getConnection("jdbc:sqlite:e:/workspace/java-dojo/SQLite/dojo.db");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	private void insertStrlist(LogEntity logEntity) throws SQLException {
		QueryRunner run = new QueryRunner();
		String sql = "INSERT INTO LogEntities"
				+ "(ip,requestTime,requestMethod,requestPath,requestVersion,requestStatus,requestFromUrl,terminalInfor) "
				+ "VALUES(?,?,?,?,?,?,?,?)";
		Object[] params = { logEntity.getIp(), logEntity.getRequestTime(), logEntity.getRequestMethod(),
				logEntity.getRequestPath(), logEntity.getRequestVersion(), logEntity.getRequestStatus(),
				logEntity.getRequestFromUrl(), logEntity.getTerminalInfor() };
		run.update(connection, sql, params);

	}

	public static void main(String[] args) throws SQLException, IOException {
		App app = new App();
		LogHandler logHandler = new LogHandler();
		ArrayList<LogEntity> logEntities = new ArrayList<LogEntity>();
		ArrayList<String> strList = logHandler.getStringListFromPath("prototype/nginx.access.log");
		for (String logStr : strList) {
			logEntities.add(logHandler.getEntity(logStr));
		}
		for (LogEntity logEntity : logEntities) {
			app.insertStrlist(logEntity);
		}

		System.out.println("Hello World!");
	}

}

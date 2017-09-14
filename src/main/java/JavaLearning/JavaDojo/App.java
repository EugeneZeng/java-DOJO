package JavaLearning.JavaDojo;

import java.sql.*;
import java.util.*;

import org.apache.commons.dbutils.*;

//import java.lang.*;
/**
 * Hello world!
 *
 */
public class App {
	public String output(String str) {

		if (str == null) {
			return "";
		}
		// 以空格分割字符串为几段子字符串数组
		String[] sArray = str.split(" ");
		// 创建一个字符串变量
		String result = "";
		// 以数组元素个数为限制进行循环
		for (int i = 0; i < sArray.length; i++) {
			// 将子数组倒序
			String inverted = new StringBuffer(sArray[i]).reverse().toString();
			// 将倒序后的数组放入s1中拼接
			if ("".equals(result)) {
				result = inverted;
			} else {
				result += " " + inverted;
			}
		}
		return result;
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

	private void insertLogEntity(LogEntity logEntity) throws SQLException {
		QueryRunner run = new QueryRunner();
		String sql = "INSERT INTO LogEntities(ip,requestTime,requestMethod,requestPath,requestVersion,requestStatus,requestFromUrl,terminalInfor) VALUES(?,?,?,?,?,?,?,?)";
		Object[] params = { logEntity.getIp(), logEntity.getRequestTime(), logEntity.getRequestMethod(),
				logEntity.getRequestPath(), logEntity.getRequestVersion(), logEntity.getRequestStatus(),
				logEntity.getRequestFromUrl(), logEntity.getTerminalInfor() };
		Connection connection = getDBConnection();

		try {
			 run.update(connection, sql, params);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		DbUtils.closeQuietly(connection);
	
	}

	public static void main(String[] args) throws SQLException {
		App app = new App();		
		LogHandler logHandler = new LogHandler();
		String logStr = "183.193.187.122 - - [24/Dec/2016:00:13:14 +0800] \"POST /socket.io/?EIO=3&transport=polling&j=12&t=LaiTH9P&b64=1&sid=rWxYshIVfGqzC15yAAEV HTTP/1.1\" 200 2 \"http://pmchat.24k.hk/studio?utm_source=pn14&utm_medium=ag&utm_campaign=yy&utm_content=AD_pcuiZS_top\" \"Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0)\"";
		LogEntity logEntity = logHandler.getEntity(logStr);
		app.insertLogEntity(logEntity);
		System.out.println("Hello World!");
	}
}

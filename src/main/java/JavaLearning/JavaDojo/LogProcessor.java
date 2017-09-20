package JavaLearning.JavaDojo;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.BeanListHandler;


public class LogProcessor {
	
	private Connection connection;

	public LogProcessor() {
		connection = getDBConnection();
	}
	
	
	LogHandler logHandler = new LogHandler();
	private int queueSize = 1000;
	private int insertSize = 100;
	private ArrayBlockingQueue<LogEntity> queue = new ArrayBlockingQueue<LogEntity>(queueSize);

	public void run() {
		Producer producer = new Producer();
		Consumer consumer = new Consumer();
		consumer.start();
		producer.start();
		
	}

	class Producer extends Thread {
		public void run() {
			try {
				produce();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void produce() throws IOException {
			String fliePath = "D:\\dojo\\DOJO1\\access.log\\access.log";
			BufferedReader br = logHandler.getStringListFromPath(fliePath);
			String read = null;

			try {
				while ((read = br.readLine()) != null) {
					queue.put(logHandler.getEntity(read));
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	class Consumer extends Thread {
		public void run() {
			try {
				consumer();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		public void consumer() throws SQLException {
			ArrayList<LogEntity> logEntities = new ArrayList<LogEntity>();
			while (true) {
				try {
					for (int i = 0; i <= insertSize; i++) {
						logEntities.add(queue.take());
						if (queue.isEmpty())
							break;
					}
					inserLogEntities(logEntities);
					logEntities.removeAll(logEntities);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			}
		}
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
	
}


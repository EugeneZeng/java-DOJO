package JavaLearning.JavaDojo;

import java.io.IOException;
import java.sql.*;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) throws SQLException, IOException {
		LogProcessor logProcessor = new LogProcessor();
		logProcessor.run();
		System.out.println("Hello World!");
	}
}


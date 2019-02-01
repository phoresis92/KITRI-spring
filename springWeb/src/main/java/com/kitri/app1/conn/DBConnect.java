package com.kitri.app1.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	private static DBConnect db = new DBConnect();
	private Connection conn = null;
	
	String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
	String jdbc_url = "jdbc:oracle:thin:@localhost:1521:xe";

	private DBConnect() {
		
	}

	public static DBConnect getInstance() {
		return db;
	}

	public Connection getConnection() {
		
		try {
			Class.forName(jdbc_driver);

			conn = DriverManager.getConnection(jdbc_url, "study", "study");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	

}

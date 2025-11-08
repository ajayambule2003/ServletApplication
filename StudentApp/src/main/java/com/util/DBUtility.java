package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtility {
	private static final String URL = "jdbc:mysql://localhost:3306/jpa8081";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	private static DBUtility instance;

	private DBUtility() {
		
	}

	public static DBUtility getInstance() {
		if (instance == null)
			instance = new DBUtility();
		return instance;
	}

	public Connection getDBConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			System.err.print("DBUtility " + e);
		}
		return con;
	}
}

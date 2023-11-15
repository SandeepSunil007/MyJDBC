package com.code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// Executing single single query at a time
public class ExecuteSQLStatements {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
//   	String sql = "insert into sandy.jdbc values(3,'simba','Nazee',6)";
//		String sql = "update sandy.jdbc set FirstName = 'Bella' where PersonId = 2";
		String sql = "delete from sandy.jdbc where PersonId = 3";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Load and Register the Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "1907");
			System.out.println("Connection Established...");
			stmt = conn.createStatement();
			System.out.println("Plateform is created");
			stmt.execute(sql);
			System.out.println("Data Inserted");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

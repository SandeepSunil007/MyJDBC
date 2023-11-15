package com.code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UsingBatchStatement {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		String connectionURL = "jdbc:mysql://localhost:3306?user=root&password=1907";
		String inertQuery = "insert into sandy.jdbc values(9,'x','y',1)";
		String deleteQuery = "delete from sandy.jdbc where personid = 6";
		String updateQuery = "update sandy.jdbc set FirstName = 'xyz' where LastName = 'B'";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Load & Register the driver");
			conn = DriverManager.getConnection(connectionURL);
			System.out.println("Connection Established....");
			stmt = conn.createStatement();
			System.out.println("Platform created...");
			stmt.addBatch(inertQuery);
			stmt.addBatch(deleteQuery);
			stmt.addBatch(updateQuery);
			int[] executeBatch = stmt.executeBatch();
			for (int i : executeBatch) {
				System.out.println(i);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Closed All Costly Resources");
	}

}

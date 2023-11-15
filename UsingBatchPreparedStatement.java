package com.code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsingBatchPreparedStatement {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		String connectionURL = "jdbc:mysql://localhost:3306?user=root&password=1907";
		String insertQuery = "insert into sandy.jdbc values(10,'FF', 'CC', 19)";
		String deleteQuery = "delete from sandy.jdbc where personid=2";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Load & Register the Driver");
			conn = DriverManager.getConnection(connectionURL);
			System.out.println("Connection Established...");

			pstmt = conn.prepareStatement(insertQuery);
			
			System.out.println("platform created first pstmt");
			pstmt.addBatch();
			int[] executeBatch = pstmt.executeBatch();
			for (int i : executeBatch) {
				System.out.println(i);
			}

			pstmt1 = conn.prepareStatement(deleteQuery);
			System.out.println("platform created first pstmt1");
			pstmt1.addBatch();
			int[] executeBatch2 = pstmt1.executeBatch();
			for (int i : executeBatch2) {
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
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pstmt1 != null) {
			try {
				pstmt1.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		System.out.println("All Costly Resources are Closed");

	}

}

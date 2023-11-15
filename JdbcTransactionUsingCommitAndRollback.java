package com.code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcTransactionUsingCommitAndRollback {
	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "insert into sandy.jdbc values(?,?,?,?)";
		String connectionURL = "jdbc:mysql://localhost:3306?user=root&password=1907";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Load and Register The Driver");
			conn = DriverManager.getConnection(connectionURL);
			System.out.println("Connection Established.....");
			conn.setAutoCommit(false);
			System.out.println("AutoCommit changed to False");
			pstmt = conn.prepareStatement(query);
			System.out.println("Platform Created.....");

			pstmt.setInt(1, 11);
			pstmt.setString(2, "M");
			pstmt.setString(3, "N");
			pstmt.setInt(4, 18);
			pstmt.executeUpdate();
			System.out.println("Details Updated...");

			pstmt.setInt(1, 12);
			pstmt.setString(2, "P");
			pstmt.setString(3, "W");
			pstmt.setInt(4, 8);
			pstmt.executeUpdate();
			System.out.println("Details Updated...");
			conn.commit();
			System.out.println("Committed the Trasaction");

		} catch (ClassNotFoundException | SQLException e) {

			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("All costly Resource Closed....");
		}

	}
}

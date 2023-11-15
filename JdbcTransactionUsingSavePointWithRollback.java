package com.code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

public class JdbcTransactionUsingSavePointWithRollback {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		Savepoint sp = null;
		String query = "insert into sandy.jdbc values(?,?,?,?)";
		String connectionURL = "jdbc:mysql://localhost:3306?user=root&password=1907";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Load & Register the Driver...");
			conn = DriverManager.getConnection(connectionURL);
			System.out.println("Connection Established.....");
			conn.setAutoCommit(false);
			System.out.println("AutoCommit changed to False");
			pstmt = conn.prepareStatement(query);
			System.out.println("Platform Created.....");

			pstmt.setInt(1, 15);
			pstmt.setString(2, "L");
			pstmt.setString(3, "B");
			pstmt.setInt(4, 10);
			pstmt.executeUpdate();
			System.out.println("Details Updated...");
			conn.commit();
			System.out.println("Committed the Changes....");
			sp = conn.setSavepoint();
			System.out.println("Save point completed.....");

			pstmt.setInt(1, 16);
			pstmt.setString(2, "H");
			pstmt.setString(3, "O");
			pstmt.setInt(4, 2);
			pstmt.executeUpdate();
			System.out.println("Details Updated...");

		} catch (ClassNotFoundException | SQLException e) {
			try {
				conn.rollback(sp);
				conn.commit();
				System.out.println("Rollback changes applicable...");
			} catch (SQLException e1) {
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

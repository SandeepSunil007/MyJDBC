package com.code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertMultipleRecordsUsingPrepareStatement {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String connectionURL = "jdbc:mysql://localhost:3306?user=root&password=1907";
		String Query = "insert into sandy.jdbc values(?,?,?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Load and Register the Driver");
			conn = DriverManager.getConnection(connectionURL);
			System.out.println("Connection Established");
			pstmt = conn.prepareStatement(Query);
			pstmt.setInt(1, 6);
			pstmt.setString(2, "Ajay");
			pstmt.setString(3, "A");
			pstmt.setInt(4, 8);
			pstmt.executeUpdate();

			pstmt.setInt(1, 7);
			pstmt.setString(2, "Kamal");
			pstmt.setString(3, "B");
			pstmt.setInt(4, 9);
			pstmt.executeUpdate();

			pstmt.setInt(1, 8);
			pstmt.setString(2, "Viki");
			pstmt.setString(3, "V");
			pstmt.setInt(4, 4);
			pstmt.executeUpdate();
			System.out.println("Data Inserted...");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}

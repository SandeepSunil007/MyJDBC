package com.code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FetchingTheRecordsFromDBusingResultsetInterface {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		String connectionURL = "jdbc:mysql://localhost:3306?user=root&password=1907";

		// String Query = "select * from sandy.jdbc";

		// Fetch single Record
		String Query = "select * from sandy.jdbc where personId = 1";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Load & Register The Driver");
			conn = DriverManager.getConnection(connectionURL);
			System.out.println("Connection Established.......");
			pstmt = conn.prepareStatement(Query);
			System.out.println("statement Created....");
			resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				int Pid = resultSet.getInt(1);
				String fname = resultSet.getString(2);
				String lname = resultSet.getString(3);
				int age = resultSet.getInt(4);
				System.out.println(Pid + " " + fname + " " + lname + " " + age);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}

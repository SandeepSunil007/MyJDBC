package com.code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ExecutingMultipleStatement {
	public static void main(String[] args) {
		Connection conn = null;
		java.sql.Statement stmt = null;
		String URL = "jdbc:mysql://localhost:3306?user=root&password=1907";
		String query1 = "insert into sandy.jdbc values(3,'simba','Nazee',6)";
		String query2 = "insert into sandy.jdbc values(4,'spy','Dango',2)";
		String query3 = "insert into sandy.jdbc values(5,'spark','Creator',7)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Load and Register the Driver");
			conn = DriverManager.getConnection(URL);
			System.out.println("Connection Established....");
			stmt = conn.createStatement();
			System.out.println("platform created");
			stmt.executeUpdate(query1);
			stmt.executeUpdate(query2);
			stmt.executeUpdate(query3);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
// In this scenario performance of an application goes down. 
// to avoid this problem, we can use PrepareStatement
}

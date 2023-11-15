package com.code;

import java.sql.*;

public class EstablishConnection {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Load and Register the Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=1907");
			System.out.println("Connection Established...");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}

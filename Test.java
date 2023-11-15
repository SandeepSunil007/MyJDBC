package com.code;

public class Test {
	public static void main(String[] args) throws MyException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Hello");
		} catch (ClassNotFoundException e) {
			throw new MyException("Program have error");
		}
	}
}

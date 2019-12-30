package com.zam.ex4.hibernate.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbcUrl = "jdbc:mysql://localhost:3306/stockanalysis?useSSL=false&serverTimezone=UTC";
		String userName = "hbstudent";
		String password = "hbstudent";
		
		try {
			Connection conn = DriverManager.getConnection(jdbcUrl, userName, password);
			System.out.println("DB Connection Successful");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}

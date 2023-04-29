package com.example.lab9.Task2.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	String url;
	String username;
	String password;
	public Database(String driver,String _url , String _username, String _password){
		url=_url;
		username=_username;
		password=_password;
		try {
			Class.forName(driver).getDeclaredConstructor().newInstance();
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
	}
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url,username,password);
	}
}

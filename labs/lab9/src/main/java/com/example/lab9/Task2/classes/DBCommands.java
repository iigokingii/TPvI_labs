package com.example.lab9.Task2.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBCommands {
	private Database database;
	public DBCommands(Database database){
		this.database = database;
	}
	public List<User> GetList(){
		List<User> users = new ArrayList<>();
		try {
			Connection con =database.getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT * FROM USERS");
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()){
				User user = new User();
				user.SetRole(resultSet.getString("ROLE"));
				user.SetLogin(resultSet.getString("LOGIN"));
				user.SetPassword(resultSet.getString("Password"));
				users.add(user);
			}
			resultSet.close();
			statement.close();
			con.close();
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
		return users;
	}
//	public List<Stud_Serv> GetListStud(String Table){
//		List<Stud_Serv> users = new ArrayList<>();
//		try {
//			Connection con =database.getConnection();
//			PreparedStatement statement = con.prepareStatement("SELECT * FROM ?");
//			statement.setString(1,Table);
//			ResultSet resultSet = statement.executeQuery();
//			while(resultSet.next()){
//				Stud_Serv user = new Stud_Serv();
////				user.SetRole(resultSet.getString("ROLE"));
////				user.SetLogin(resultSet.getString("LOGIN"));
////				user.SetPassword(resultSet.getString("Password"));
//				user.setID(Integer.parseInt(resultSet.getString("ID")));
//				user.setName(resultSet.getString("NAME"));
//				user.setSurname(resultSet.getString("SURNAME"));
//				user.setServer(resultSet.getString("SERVER"));
//				users.add(user);
//			}
//			resultSet.close();
//			statement.close();
//			con.close();
//		}
//		catch (Exception ex){
//			ex.printStackTrace();
//		}
//		return users;
//	}
	
	public void addUser(String _Login,String _Password) {
		try {
			Connection con = database.getConnection();
			Statement statement = con.createStatement();
			statement.executeUpdate("INSERT INTO USERS(LOGIN,PASSWORD,ROLE) " +
					"VALUES ('" +  _Login +"', '" + _Password + "', 'user')");
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
	}
	public void addUserByAdmin(String _Login,String _Password,String _Role) {
		try {
			Connection con = database.getConnection();
			Statement statement = con.createStatement();
			statement.executeUpdate("INSERT INTO USERS(LOGIN,PASSWORD,ROLE) " +
					"VALUES ('" +  _Login +"', '" + _Password + "', '" + _Role + "')");
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
	}
	public void DeleteUser(String _Login){
		try{
			Connection con = database.getConnection();
			Statement statement = con.createStatement();
			statement.executeUpdate("DELETE FROM USERS WHERE LOGIN ='"+_Login+"'");
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
		
	}
	
	
	
	


}

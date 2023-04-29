package com.example.lab9.Task2.classes;

public class User {
	public String Password;
	public String Login;
	public String Role;
	public User(){
	
	}
	public User(String _Password, String _Login, String _Role){
		Password=_Password;
		Login=_Login;
		Role=_Role;
	}
	public void SetPassword(String _Password){
		Password = _Password;
	}
	public void SetLogin(String _Login){
		Login = _Login;
	}
	public void SetRole(String _Role){
		Role = _Role;
	}
	public String GetRole(){
		return Role;
	}
	public String GetLogin(){
		return  Login;
	}
	public String GetPassword(){
		return Password;
	}
	
	
	
	
	


}

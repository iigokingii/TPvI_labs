package com.example.lab9.Task2.classes;

public class Stud_Serv {
	public int ID;
	public String Name;
	public String Surname;
	public String Server;
	public Stud_Serv(){

	}
	public Stud_Serv(int _ID, String _Name,String _Surname,String _Server){
		Name=_Name;
		Surname=_Surname;
		Server=_Server;
		ID=_ID;
	}
	public void setServer(String server) {
		Server = server;
	}
	public void setName(String name) {
		Name = name;
	}
	public void setSurname(String surname) {
		Surname = surname;
	}
	public void setID(int ID) {
		this.ID = ID;
	}
	public String getSurname() {
		return Surname;
	}
	public String getName() {
		return Name;
	}
	public String getServer() {
		return Server;
	}
	public int getID() {
		return ID;
	}
}

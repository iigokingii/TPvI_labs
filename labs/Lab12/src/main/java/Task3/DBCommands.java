package Task3;

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
	List<Stud_Serv> users;
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
	public void update(Stud_Serv studServ){
		try {
			Connection con = database.getConnection();
			PreparedStatement statement = con.prepareStatement("DELETE FROM STUD_SERV WHERE ID = ?");
			statement.setInt(1,studServ.getID());
			statement.executeUpdate();
			addStud(studServ);
		}
		catch (Exception ex){
		}
	}
	public List<Stud_Serv> GetListStud(){
		users = new ArrayList<>();
		try {
			Connection con =database.getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT * FROM STUD_SERV");
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()){
				Stud_Serv user = new Stud_Serv();
//				user.SetRole(resultSet.getString("ROLE"));
//				user.SetLogin(resultSet.getString("LOGIN"));
//				user.SetPassword(resultSet.getString("Password"));
				user.setID(Integer.parseInt(resultSet.getString("ID")));
				user.setName(resultSet.getString("NAME"));
				user.setSurname(resultSet.getString("SURNAME"));
				user.setServer(resultSet.getString("SERVER"));
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
	public void addStud(Stud_Serv student) {
		try {
			Connection con = database.getConnection();
			Statement statement = con.createStatement();
			statement.executeUpdate("INSERT INTO STUD_SERV(ID,NAME,SURNAME,SERVER) " +
					"VALUES ('" + student.getID() +"', '" + student.getName() + "', '" + student.getSurname() +"','" + student.getServer() +"')");
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
	public Stud_Serv getStud_Serv(int id){
		users = GetListStud();
		return users.get(id);
	}
	public void deleteStud(int id){
		try {
			Connection connection = database.getConnection();
			Statement statement = connection.createStatement();
			statement.executeUpdate("DELETE FROM STUD_SERV WHERE ID = '"+id+"'");
		}
		catch (Exception ex){
		
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

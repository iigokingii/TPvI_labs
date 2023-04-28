import java.sql.*;
import java.util.logging.Logger;

class BD implements IControl{
	public BD(){
	
	}
	Connection connection;
	Statement statement;
	private static final Logger logger = Logger.getLogger(Main.class.getName());
	public void Connect(){
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").getDeclaredConstructor().newInstance();
			String connectionUrl = "jdbc:sqlserver://GOKING;databaseName=Lab4;trustServerCertificate=true;encrypt=false;IntegratedSecurity=false";
			connection = DriverManager.getConnection(connectionUrl,"sa","1111");
			statement = connection.createStatement();
			logger.info("Connection successful...");
			System.out.println("Connection successful...");
		}
		catch (Exception e){
			System.out.println("Connection failed...");
			logger.info("Connection failed...");
			System.out.println(e);
		}
	}
	public void Disconnect(){
		try {
			logger.info("Disconnected from database");
			connection.close();
		}
		catch (Exception e){
			logger.info(e.toString());
			System.out.println(e);
		}
	}
	public void Request1(){
		try{
			logger.info("Request1:");
			ResultSet res = statement.executeQuery("SELECT * From Book WHERE Год_выхода = '1985'");
			System.out.println("\nRequest1:");
			while (res.next()){
				String name = res.getString(1);
				String author = res.getString(2);
				String year = res.getString(3);
				String publisher = res.getString(4);
				System.out.println(name+ " "+author+" "+year+" "+publisher);
			}
			System.out.println();
		}
		catch (Exception e ){
			logger.info("Request1 failure:");
			System.out.println(e);
		}
	}
	public void Request2(){
		System.out.println("Request2:");
		logger.info("Request2:");
		try {
			ResultSet res = statement.executeQuery("SELECT *FROM Author");
			while (res.next()){
				String FIO = res.getString(1);
				String country = res.getString(2);
				System.out.println(FIO+ " "+country);
			}
			System.out.println();
		}
		catch (Exception e){
			logger.info("Request2 failure:");
			System.out.println(e);
		}
	}
	public void Request3(int n){
		System.out.println("Request3:");
		logger.info("Request3:");
		try{
			PreparedStatement stat = connection.prepareStatement (	"SELECT Book.Имя_автора\n FROM Book\n GROUP BY Book.Имя_автора\n HAVING COUNT(Book.Имя_автора)>?");
			stat.setInt(1,n);
			ResultSet res = stat.executeQuery();
			while (res.next()){
				String FIO = res.getString(1);
				System.out.println(FIO);
			}
			System.out.println();
		}
		catch (Exception e){
			logger.info("Request3 failure:");
			System.out.println(e);
		}
	}
	public void Request4(){
		System.out.println("Request4:");
		logger.info("Request4:");
		try {
			ResultSet res = statement.executeQuery("SELECT *FROM BOOK");
			while (res.next()){
				String name = res.getString(1);
				String author = res.getString(2);
				String year = res.getString(3);
				String publisher = res.getString(4);
				System.out.println(name+ " "+author+" "+year+" "+publisher);
			}
			System.out.println();
			System.out.println();
			statement.executeUpdate(	"DELETE FROM BOOK \n" +
											"WHERE Book.Год_выхода<'1851'");
			
			ResultSet res2 = statement.executeQuery("SELECT *FROM BOOK");
			while (res2.next()){
				String name = res2.getString(1);
				String author = res2.getString(2);
				String year = res2.getString(3);
				String publisher = res2.getString(4);
				System.out.println(name+ " "+author+" "+year+" "+publisher);
			}
			
			System.out.println();
		}
		catch (Exception e){
			System.out.println(e);
			logger.info("Request4 failure:");
		}
	}
}

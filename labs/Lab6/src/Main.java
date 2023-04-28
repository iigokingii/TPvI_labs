import java.sql.Connection;
import java.sql.DriverManager;
public class Main {
	public static void main(String[] args) {
		//D:\2k2s\TPvI\labs\Lab6\src
		//javac Main.java
		//java -classpath mssql-jdbc-12.2.0.jre11.jar;. Main
		BD bd = new BD();
		bd.Connect();
		bd.Request1();
		bd.Request2();
		int n =1;
		bd.Request3(n);
		bd.Request4();
		bd.Disconnect();
	}
}
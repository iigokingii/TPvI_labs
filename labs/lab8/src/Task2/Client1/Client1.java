package Task2.Client1;

import java.io.*;
import java.net.Socket;

public class Client1 {
	static int port =2001;
	static String serverName = "GoKing";
	public static void main(String[]args){
		try {
			Socket client = new Socket(serverName,port);
			System.out.println("Подключение к " +serverName + " с портом "+ port);
			
			OutputStream receivedFromServer = client.getOutputStream();
			DataOutputStream out = new DataOutputStream(receivedFromServer);
			out.writeUTF("10" );
			
			InputStream inFromServ = client.getInputStream();
			DataInputStream in = new DataInputStream(inFromServ);
			
			System.out.println("Сервер ответил :"+in.readUTF());
			client.close();
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}


}

package Task2.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Server {
	static int Port = 2001;
	static int number ;
	
	static boolean isNumeric(String parm){
		try {
			Double.parseDouble(parm);
			return true;
		}
		catch (Exception ex){
			return false;
		}
	}
	
	public static void main(String[]args){
		
		System.out.println("Сервер запущен...");
		try {
			String temp = "";
			ServerSocket serverSocket = new ServerSocket(Port);
			System.out.println("Сервер ожидает подключения клиента...");
			while (temp!="Currect"){
				Socket Server = serverSocket.accept();
				DataInputStream in = new DataInputStream(Server.getInputStream());
				temp = in.readUTF();
				if(isNumeric(temp)){
					number = Integer.parseInt(temp);
					System.out.println("Число получено.");
					DataOutputStream out = new DataOutputStream(Server.getOutputStream());
					out.writeUTF("Число успешно установлено");
					Server.close();
				}
				else{
					while (true){
						
						String[] t = temp.split(":");
						if(isNumeric(t[t.length-1])){
							int userNum = Integer.parseInt(t[t.length-1]);
							if(userNum>number){
								DataOutputStream out = new DataOutputStream(Server.getOutputStream());
								out.writeUTF("Больше, чем загаданное");
							}
							else if(userNum<number){
								DataOutputStream out = new DataOutputStream(Server.getOutputStream());
								out.writeUTF("меньше, чем загаданное");
							}
							else{
								DataOutputStream out = new DataOutputStream(Server.getOutputStream());
								out.writeUTF("Число угадано");
								Server.close();
								temp = "Currect";
								break;
							}
						}
						temp = in.readUTF();
					}
					
					
				}
			}
			
			//System.out.println(in.readUTF());
			// = in.readUTF();
			
			
			
			serverSocket.close();
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
		
	}

}

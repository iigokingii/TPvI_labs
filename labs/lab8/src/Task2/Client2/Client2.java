package Task2.Client2;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
	static int port =2001;
	static String serverName = "GoKing";
	public static void main(String[]args){
		try {
			Socket client = new Socket(serverName,port);
			String temp = "q";
			System.out.println("Подключение к " +serverName + " с портом "+ port);
			Scanner inScan = new Scanner(System.in);
			
			
			while (true){
				
				System.out.println("Введите число: ");
				int num = inScan.nextInt();
				String write = "Answer:"+num;
				
				
				OutputStream receivedFromServer = client.getOutputStream();
				DataOutputStream out = new DataOutputStream(receivedFromServer);
				out.writeUTF(write );
				
				InputStream inFromServ = client.getInputStream();
				DataInputStream in = new DataInputStream(inFromServ);
				temp = in.readUTF();
				System.out.println("Сервер ответил :"+temp);
				if (temp.equals("Число угадано"))
					break;
			}
			client.close();
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
	
}

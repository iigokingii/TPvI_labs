package Task3.ServerUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ServerUDP {
	static int Port = 2000;
	public static void main(String[]args) throws IOException {
		try {
			DatagramSocket ServerSocket = new DatagramSocket(Port);
			byte[] recevingData = new byte[1024];
			byte[] sendingData = new byte[1024];
			
			//пакет для получения данных
			DatagramPacket inputPacket = new DatagramPacket(recevingData,recevingData.length);
			System.out.println("Waiting for Client's connection ...");
			
			ServerSocket.receive(inputPacket);
			String receivedData = new String(inputPacket.getData());
			System.out.println("Received data: "+receivedData);
			sendingData = receivedData.toUpperCase().getBytes();
			
			InetAddress clientAdress = inputPacket.getAddress();
			int clientPort = inputPacket.getPort();
			
			//пакет для отправки данных
			DatagramPacket outputPacket = new DatagramPacket(sendingData,sendingData.length,clientAdress,clientPort);
			ServerSocket.send(outputPacket);
			ServerSocket.close();
		}
		catch (SocketException e){
			e.printStackTrace();
		}
		
		
	}


}

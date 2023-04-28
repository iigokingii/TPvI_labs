package Task3.ClientUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientUDP {
	static int Port = 2000;
	public static void main(String[]args) throws IOException{
		try {
			DatagramSocket clientSocket = new DatagramSocket();
			InetAddress IPAdress = InetAddress.getLocalHost();
			
			byte [] sendingData = new byte[1024];
			byte [] receivingData = new byte[1024];
			
			String data = "hello from udp Client\0";
			sendingData = data.getBytes();
			DatagramPacket sendingPacket = new DatagramPacket(sendingData,sendingData.length,IPAdress,Port);
			clientSocket.send(sendingPacket);
			
			DatagramPacket receivingPacket = new DatagramPacket(receivingData,receivingData.length);
			clientSocket.receive(receivingPacket);
			
			String received = new String(receivingPacket.getData());
			System.out.println("Sent from Server :" +received);
			clientSocket.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}



}

package Task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class Task1 {
	public void GetIP(){
		InetAddress currentIP = null;
		InetAddress byFlyIP = null;
		try{
			currentIP = InetAddress.getLocalHost();
			System.out.println("Local Host IP:" + currentIP.getHostAddress());
			byFlyIP = InetAddress.getByName("www.byfly.by");
			System.out.println("Byfly IP:"+byFlyIP.getHostAddress());
		}
		catch (UnknownHostException ex){
			System.out.println(ex);
			System.out.println("Адресс недоступен");
		}
	}
	public void GetConnection(){
		byte[] byFlyIp ={(byte)86,(byte)57,(byte)251,(byte)89};
		try {
			InetAddress addr = InetAddress.getByAddress("By Fly",byFlyIp);
			System.out.println(addr.getHostName()+"->Соединение: "+addr.isReachable(600));
		}
		catch (UnknownHostException ex){
			System.out.println(ex);
			System.out.println("Адресс недоступен");
		}
		catch (IOException e){
			System.out.println(e);
		}
	}
	public void ReadHTML(){
		String urlName = "http://www.byfly.by/";
		URL byFly = null;
		try {
			byFly = new URL(urlName);
		}
		catch (MalformedURLException e){
			e.printStackTrace();
		}
		if(byFly==null){
			throw new RuntimeException();
		}
		try (BufferedReader d = new BufferedReader(new InputStreamReader(byFly.openStream()))){
			String line ="";
			while ((line = d.readLine())!=null)
				System.out.println(line);
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
	public void GetConnectionInfo(){
		String urlName ="https://steamcommunity.com/profiles/76561199104733516/inventory/";
		int timeout = 1000;
		URL url;
		try{
			url = new URL(urlName);
			final URLConnection connection = url.openConnection();
			connection.setConnectTimeout(timeout);
			System.out.println(urlName+ " connection type: "+
					"\n" + connection.getContentType() +
					"\n" +connection.getClass() +
					"\n"+connection.getContentLength());
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	


}

package lab3.CallCenter;

public class ClientThread extends Thread{
	CallCenter call;
	String name;
	public ClientThread(CallCenter _call, String _name){
		super(_name);
		call=_call;
		name=_name;
	}
	public void run(){
		System.out.printf("%s Подключился \n", Thread.currentThread().getName());
		call.ServeClient();
		System.out.printf("%s Отключился \n", Thread.currentThread().getName());
	}
}

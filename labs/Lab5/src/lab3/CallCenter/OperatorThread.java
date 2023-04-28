package lab3.CallCenter;

public class OperatorThread extends Thread{
	CallCenter call ;
	String name;
	public OperatorThread(CallCenter _call,String _name){
		super(_name);
		call=_call;
		name=_name;
	}
	public void run(){
		/*for (int i =0;i<3;i++)*/
		System.out.println(Thread.currentThread().getName() + " онлайн");
		call.Release();
	}
}

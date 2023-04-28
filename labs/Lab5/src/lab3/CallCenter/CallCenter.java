package lab3.CallCenter;

import java.util.Random;

public class CallCenter {
	private int numberOfOperators;
	public void setNumberOfOperators(int n){
		numberOfOperators=n;
	}
	public synchronized void ServeClient(){
		double rand = new Random().nextDouble();
		while (numberOfOperators<1){
			try{
				System.out.println(Thread.currentThread().getName()+" поток остановлен ");
				wait();
			}
			catch (InterruptedException e){
				System.out.println("Поток заблокирован");
			}
		}
		if(rand<0.50){
			numberOfOperators--;
			System.out.println("Оператор обслуживает "+Thread.currentThread().getName());
			System.out.println("Количество свободных операторов: "+numberOfOperators);
			notify();
		}
		else{
			System.out.println(Thread.currentThread().getName()+" положил трубку.");
			try{
				Thread.sleep(1000);
				numberOfOperators--;
				System.out.println(Thread.currentThread().getName()+ " подключился снова.");
				System.out.println("Оператор обслуживает "+Thread.currentThread().getName());
				System.out.println("Количество свободных операторов: "+numberOfOperators);
				notify();
			}
			
			catch (InterruptedException e){}
		}
	}
	public synchronized void Release(){
		while(numberOfOperators>=3){
			try{
				System.out.println(Thread.currentThread().getName()+" поток остановлен ");
				wait();
			}
			catch (InterruptedException e){
				System.out.println("Поток заблокирован");
			}
		}
		numberOfOperators++;
		System.out.println(Thread.currentThread().getName()+" Осводился");
		System.out.println("Свободных операторов:"+numberOfOperators);
		notify();
	}
}

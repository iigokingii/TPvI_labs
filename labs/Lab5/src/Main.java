import lab3.CallCenter.CallCenter;
import lab3.CallCenter.ClientThread;
import lab3.CallCenter.OperatorThread;
import lab3.Tender.Parking;
import lab3.Tender.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Main {
	private static final int NUMBER_OF_CARS = 15;
	private static final int FIRST_PARKING = 4;
	private static final int SECOND_PARKING = 5;
	public static void main(String[] args) {
		CallCenter call = new CallCenter();
		int NumberOfOper = 3;
		int NumberOfClient = 5;
		call.setNumberOfOperators(NumberOfOper);
		
		//Operator operator = new Operator(call);
		//new Thread(operator).start();
		List<OperatorThread>listOper = new ArrayList<>();
		List<ClientThread>listCl = new ArrayList<>();
		
		for (int i=0;i<NumberOfOper;i++){
			OperatorThread thread= new OperatorThread(call,"Operator"+i);
			thread.start();
			listOper.add(thread);
		}
		for (int i =0 ; i<NumberOfClient; i++){
			ClientThread threadCl =  new ClientThread(call,"Client"+i);
			threadCl.start();
			listCl.add(threadCl);
		}
		
		/*for (var t:listOper) {
			try{
				
				t.join();
				System.out.println("qweqwe");
			}
			catch (InterruptedException e){
			
			}
		}
		for (var t:listCl) {
			try{
				
				t.join();
				System.out.println("qweqwe");
			}
			catch (InterruptedException e){
			
			}
		}*/
		Parking firstParking = new Parking(1, FIRST_PARKING);
		Parking secondParking = new Parking(2, SECOND_PARKING);
		
		Semaphore firstSem = new Semaphore(firstParking.getCapacity(), true);
		Semaphore secondSem = new Semaphore(secondParking.getCapacity(), true);
		
		ExecutorService service = Executors.newCachedThreadPool();
		
		for (int number = 1; number <= NUMBER_OF_CARS; ) {
			service.execute(new Car(firstSem, firstParking, number++));
			service.execute(new Car(secondSem, secondParking, number++));
		}
		service.shutdown();
	}
}
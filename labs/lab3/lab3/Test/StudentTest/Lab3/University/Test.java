package Lab3.University;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import Lab3.University.TestSuite.*;

public class Test {
	public static void main(String[]args){
		System.out.println("==============================Start of Testing================================================");
		
		  Result result = JUnitCore.runClasses(TestSuitStudStream.class);
			for (Failure failure :result.getFailures()){
				System.out.println(failure.toString());
			}
		
		System.out.println("==============================End of Testing================================================");
		
		
	}
}

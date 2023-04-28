package Lab3.University.StudentTE;

import Lab3.University.StreamTE.Stream;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.BeforeClass;
//import org.junit.Test;
import org.junit.jupiter.api.*;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {
	private Lab3.University.StudentTE.Student student;
	@BeforeEach
	public void Create(){
		student = new Lab3.University.StudentTE.Student("vitalya","shrte",20,6.6,"POIT", Lab3.University.StudentTE.Course.second);
		student.SetSpeciality("POIT");
		student.budgetForm = false;
	}
	@DisplayName("BeforeClass")
	@BeforeClass public static void After(){
		System.out.println("Executed After class Method");
	}
	@Test
	public void setSpeciality() {
		String actual = student.spec.speciality;
		String expected = "POIT";
		assertEquals(expected,actual,"Lab3.University.Test of setSpeciality");
	}
	@DisplayName("BeforeMethod")
	@BeforeClass public static void  Before(){
		System.out.println("Executed Before class Method");
	}
	
	@Test
	@DisplayName("setBudgetForm")
	public void setBudgetForm() {
		Boolean actual = student.budgetForm;
		assertTrue(actual);
	}
	@Test
	@Timeout(value = 2000, unit= TimeUnit.MILLISECONDS )
	public void testToString() {
		assertNotNull(student.toString());
	}
	@Test
	public void TestClassCon(){
		Stream stream = new Stream();
		stream.AddStudent(student);
		int expected = 1;
		int actual = stream.GetList().size();
		assertEquals(expected,actual,"Testing Class Connection");
	}
	@Test
	@Disabled
	public void writeJson() {
	}
	
	@DataProvider(name = "test-data")
	public Object[] ReturnString(){
		Object obj = new String("D:\\2k2s\\TPvI\\labs\\lab3\\lab3\\jsons\\Stream.json");
		Object [] on = new Object[]{obj};
		return on;
	}
	@org.testng.annotations.Test(dataProvider = "test-data")
	public void readJson(String path) {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
			Stream stream = gson.fromJson(bufferedReader,Stream.class);
			assertNull(stream);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
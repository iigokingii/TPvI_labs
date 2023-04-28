package Lab3.University.StudentTE;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.DisplayName;

import java.io.*;
@DisplayName("Test class demonstrating how to use the before and after annotations.")
public class Student extends AbstractStudent implements Serializable {
	public String name;
	public String surname;
	public int age;
	public double averageScore;
	public boolean budgetForm;
	Speciality spec= new Speciality() ;
	public Course course;
	public Student(String _name, String _surname , int _age, double _averageScore,String _speciality,Course _course){
		name=_name;
		surname=_surname;
		age=_age;
		averageScore=_averageScore;
		spec.setSpeciality(_speciality);
		course=_course;
	}
	public  void SetSpeciality(String _speciality){
		spec.setSpeciality(_speciality);
	}
	public Student(){
	
	}
	public void SetBudgetForm(boolean _budgetForm){
		budgetForm=_budgetForm;
	}
	public boolean GetBudgetFrom(){
		return budgetForm;
	}
	@Override
	public String toString(){
		return "\ncourse: "+this.course+"\nage: "+this.age+"\nsurname: "+this.surname+"\nname: "+this.name+"\nspeciality: "+this.spec.speciality+"\nAverage score: "+this.averageScore+"\n";
	}
	public class Speciality{
		public String speciality;
		public String getSpeciality() {
			return speciality;
		}
		public void setSpeciality(String speciality) {
			this.speciality = speciality;
		}
	}
	public static void WriteJson(Student student) throws IOException {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		FileWriter fileWriter = new FileWriter("D:\\2k2s\\TPvI\\labs\\lab3\\lab3\\jsons\\student.json");
		fileWriter.write(gson.toJson(student));
		fileWriter.close();
	}
	public static Student readJson(){
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\2k2s\\TPvI\\labs\\lab3\\lab3\\jsons\\student.json"));
			Student student = gson.fromJson(bufferedReader,Student.class);
			return student;
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}

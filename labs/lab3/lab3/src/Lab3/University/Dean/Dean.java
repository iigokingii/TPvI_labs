package Lab3.University.Dean;
import Lab3.University.StreamTE.Stream;
import Lab3.University.StudentTE.Course;
import Lab3.University.StudentTE.Student;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.LinkedList;

public class Dean implements IDensFunc, Serializable {
	LinkedList<Student> list;
	public Dean(Stream stream){
		list = stream.GetList();
	}
	@Override
	public String CountStudentByCourse(){
		int first=0,second=0,third=0,fourth=0;
		for (var t:list) {
			if(t.course== Course.first)
				first++;
			if(t.course== Course.second)
				second++;
			if(t.course== Course.third)
				third++;
			if(t.course== Course.fourth)
				fourth++;
		}
		return "First : "+first+";\nsecond : "+second+"\nthird : "+third + "\nfourth : "+fourth;
	}
	String Print(Student student){
		return "information about student :"+student.toString();
	}
	@Override
	public void FindByCourse(Course _course){
		System.out.println("FindByCourse Method: \n");
		for (Student t : list){
			if(t.course==_course){
				System.out.println(Print(t));
			}
		}
	}
	@Override
	public void FindByAverage(double _average){
		System.out.println("FindByAverage Method: \n");
		for (var t : list){
			if(t.averageScore == _average){
				System.out.println(Print(t));
			}
		}
	}
	@Override
	public void SortByCourse(){
		System.out.println("SortByCourse Method: ");
		Student temp ;
		int size = list.size();
		for (int i=0;i<size-1;i++){
			int index =i;
			for (int j = i+1;j<size;j++){
				if(list.get(j).course.ordinal()<list.get(index).course.ordinal()){
					index=j;
				}
			}
			if(index!=i){
				temp = list.get(i);
				list.remove(i);
				list.add(i,list.get(index-1));
				list.remove(index);
				list.add(temp);
			}
		}
		for (var t:list){
			System.out.println(t.toString());
		}
	}
	@Override
	public void SortBySurname(){
		System.out.println("Сортировка по фамилии");
		list	.stream()
				.map(t->t.surname)
				.sorted()
				.forEach(t->System.out.println(t.toString()));
	}
	public static void WriteJson(Dean dean) throws IOException {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		FileWriter fileWriter = new FileWriter("D:\\2k2s\\TPvI\\labs\\lab3\\lab3\\jsons\\Dean.json");
		fileWriter.write(gson.toJson(dean));
		fileWriter.close();
	}
	public static Dean readJson(){
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\2k2s\\TPvI\\labs\\lab3\\lab3\\jsons\\Dean.json"));
			Dean dean = gson.fromJson(bufferedReader,Dean.class);
			return dean;
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}

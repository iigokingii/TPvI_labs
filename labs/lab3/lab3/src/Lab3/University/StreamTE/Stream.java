package Lab3.University.StreamTE;

import java.io.*;
import java.util.LinkedList;

import Lab3.University.StudentTE.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class Stream implements Serializable {
	LinkedList<Student> list = new LinkedList<Student>();
	public Stream(){
		super();
	}
	public LinkedList GetList(){
		return  list;
	}
	public void AddStudent(Object obj){
		if(obj instanceof Student){
			list.add((Student)obj);
		}
		else{
			try {
				throw new Exception("Передан объект другого типа");
				
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}
	public static void WriteJson(Stream stream) throws IOException {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		FileWriter fileWriter = new FileWriter("D:\\2k2s\\TPvI\\labs\\lab3\\lab3\\jsons\\Stream.json");
		fileWriter.write(gson.toJson(stream));
		fileWriter.close();
	}
	public static Stream readJson(){
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\2k2s\\TPvI\\labs\\lab3\\lab3\\jsons\\Stream.json"));
			Stream stream = gson.fromJson(bufferedReader,Stream.class);
			return stream;
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}

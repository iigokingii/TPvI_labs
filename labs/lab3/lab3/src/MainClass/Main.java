package MainClass;

import Lab3.University.Dean.Dean;
import Lab3.University.StaxStreamProcessor.StaxStreamProcessor;
import Lab3.University.StreamTE.Stream;
import Lab3.University.StudentTE.Course;
import Lab3.University.StudentTE.Student;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.LogManager;
public class Main {
	private static final Logger logger = Logger.getLogger(Main.class.getName());
	public static void main(String[] args) {
		try {
			
			
			LogManager.getLogManager().readConfiguration();
			System.out.println(System.getProperty("java.util.logging.config.file"));
			logger.info("Starting programm ________________________________");
			logger.log(Level.INFO,"создание объектов");
			Student student1 = new Student("vitalya","shrte",20,6.6,"POIT", Course.second);
			student1.SetBudgetForm(true);
			Student student2 = new Student("qwe","rew",18,9.2,"POIT",Course.first);
			student2.SetBudgetForm(false);
			Student student3 = new Student("xcx","zxc",19,5.2,"POIT",Course.third);
			student3.SetBudgetForm(false);
			Student student4 = new Student("cvcv","rxc",21,7,"POIT",Course.fourth);
			student4.SetBudgetForm(true);
			Student student5 = new Student("dfg","ggff",18,6.4,"ISIT",Course.first);
			student5.SetBudgetForm(false);
			Student student6 = new Student("vbv","fgdg",22,8,"POIBMS",Course.first);
			student6.SetBudgetForm(false);
			Student student7 = new Student("bvvvb","acccc",22,5.2,"ISIT",Course.fourth);
			student7.SetBudgetForm(false);
			
			logger.log(Level.ALL,"Создание объекта Stream");
			Stream stream = new Stream();
			/*String a = "sss";
			stream.AddStudent(a);*/
			stream.AddStudent(student1);
			stream.AddStudent(student2);
			stream.AddStudent(student3);
			stream.AddStudent(student4);
			stream.AddStudent(student5);
			stream.AddStudent(student6);
			stream.AddStudent(student7);
			Dean dean = new Dean(stream);
			logger.info("CountStudentByCourse method");
			System.out.println("Number of students of different courses\n"+dean.CountStudentByCourse());
			logger.info("FindByCourse method");
			dean.FindByCourse(Course.first);
			logger.info("FindByAverage method");
			dean.FindByAverage(5.2);
			logger.info("SortByCourse method");
			dean.SortByCourse();
			logger.info("SortBySurname method");
			dean.SortBySurname();
			Student.WriteJson(student1);
			Student st= Student.readJson();
			System.out.println(st);
			
			Dean.WriteJson(dean);
			Dean dean1 = Dean.readJson();
			System.out.println(dean1);
			
			Stream.WriteJson(stream);
			Stream stream1= Stream.readJson();
			System.out.println(stream1);
			
			String fileName = "D:\\2k2s\\TPvI\\labs\\lab3\\lab3\\xmlFiles\\info.xml";
			List<Student> studentsList = StaxStreamProcessor.parseXMLfile(fileName);
			for (Student student : studentsList) {
				System.out.println(
						student.toString());
			}
			
		}
		catch (Exception e){
			System.out.println(e.getMessage());
			logger.log(Level.WARNING,e.getMessage(),e);
		}
		finally {
			System.out.println("Блок finally");
		}
		
	}
	
}
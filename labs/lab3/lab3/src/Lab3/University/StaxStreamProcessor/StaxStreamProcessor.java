package Lab3.University.StaxStreamProcessor;
import Lab3.University.StudentTE.Course;
import Lab3.University.StudentTE.Student;


import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;


import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class StaxStreamProcessor{
	public static List<Student> parseXMLfile(String fileName) {
		List<Student> studentsList = new ArrayList<>();
		Student student = null;
		XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
		try {
			XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(fileName));
			while (reader.hasNext()) {
				XMLEvent xmlEvent = reader.nextEvent();
				if (xmlEvent.isStartElement()) {
					StartElement startElement = xmlEvent.asStartElement();
					if (startElement.getName().getLocalPart().equals("Student")) {
						student = new Student();
					} else if (startElement.getName().getLocalPart().equals("name")) {
						xmlEvent = reader.nextEvent();
						student.name=xmlEvent.asCharacters().getData();
					} else if (startElement.getName().getLocalPart().equals("age")) {
						xmlEvent = reader.nextEvent();
						student.age=Integer.parseInt(xmlEvent.asCharacters().getData());
					} else if (startElement.getName().getLocalPart().equals("surname")) {
						xmlEvent = reader.nextEvent();
						student.surname=xmlEvent.asCharacters().getData();
					} else if (startElement.getName().getLocalPart().equals("averageScore")) {
						xmlEvent = reader.nextEvent();
						student.averageScore=Double.parseDouble(xmlEvent.asCharacters().getData());
					} else if (startElement.getName().getLocalPart().equals("budgetForm")) {
						xmlEvent = reader.nextEvent();
						student.budgetForm=Boolean.parseBoolean(xmlEvent.asCharacters().getData());
					} else if (startElement.getName().getLocalPart().equals("course")) {
						xmlEvent = reader.nextEvent();
						String tt = xmlEvent.asCharacters().getData();
						switch (tt){
							case "first":{
								student.course= Course.first;
								break;
							}
							case "second":{
								student.course= Course.second;
								break;
							}
							case "third":{
								student.course= Course.third;
								break;
							}case "fourth":{
								student.course= Course.fourth;
								break;
							}
						}
					} else if (startElement.getName().getLocalPart().equals("Speciality")) {
						xmlEvent = reader.nextEvent();
						student.SetSpeciality(xmlEvent.asCharacters().getData());
					}
				}
				if (xmlEvent.isEndElement()) {
					EndElement endElement = xmlEvent.asEndElement();
					if (endElement.getName().getLocalPart().equals("Student")) {
						studentsList.add(student);
					}
				}
			}
		} catch (FileNotFoundException | XMLStreamException exc) {
			exc.printStackTrace();
		}
		return studentsList;
	}
}
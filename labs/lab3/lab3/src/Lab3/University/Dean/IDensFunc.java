package Lab3.University.Dean;

import Lab3.University.StudentTE.Course;

public interface IDensFunc {
	String CountStudentByCourse();
	void FindByCourse(Course _course);
	void FindByAverage(double average);
	void SortByCourse();
	void SortBySurname();
}

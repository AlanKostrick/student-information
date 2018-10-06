package org.wecancodeit.studentinformation;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

	Map<Long, Student> studentList = new HashMap<>();

	private Student studentOne = new Student(1L, "Kurt", "https://github.com/KurtSwinehart");
	private Student studentTwo = new Student(2L, "Lisa", "https://github.com/L-Rees");

	public StudentRepository() {
		studentList.put(studentOne.getId(), studentOne);
		studentList.put(studentTwo.getId(), studentTwo);
	}

	// uses varargs this constructor is for testing purposes only!
	public StudentRepository(Student... students) {
		for (Student student : students) {
			studentList.put(student.getId(), student);
		}
	}

	public Student findOne(long id) {

		return studentList.get(id);
	}

	public Collection<Student> findAll() {
		return studentList.values();
	}

}

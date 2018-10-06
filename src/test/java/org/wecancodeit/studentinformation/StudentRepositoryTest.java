package org.wecancodeit.studentinformation;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import javax.annotation.Resource;

import org.junit.Test;

public class StudentRepositoryTest {

	@Resource
	private StudentRepository underTest;

	private Student studentOne = new Student(1L, "Kurt", "https://github.com/KurtSwinehart");
	private Student studentTwo = new Student(2L, "Lisa", "https://github.com/L-Rees");

	@Test
	public void shouldFindStudentOneById() {
		underTest = new StudentRepository(studentOne);
		Student foundStudent = underTest.findOne(1L);
		assertThat(foundStudent, is(studentOne));
	}

	@Test
	public void shouldFindAllStudents() {
		underTest = new StudentRepository(studentOne, studentTwo);
		Collection<Student> foundStudents = underTest.findAll();
		assertThat(foundStudents, hasSize(2));
		assertThat(foundStudents, containsInAnyOrder(studentOne, studentTwo));
	}

}

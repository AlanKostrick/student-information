package org.wecancodeit.studentinformation;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
/*import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;*/
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class)
public class StudentMvcControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Mock
	private Student studentOne;

	@Mock
	private Student studentTwo;

	@MockBean
	private StudentRepository studentRepo;

	@Test
	public void shouldGetAStatusOfOkAndAViewOfStudentsTemplate() throws Exception {
		this.mockMvc.perform(get("/show-students")).andExpect(status().isOk())
				.andExpect(view().name("studentsTemplate"));
	}

	@Test
	public void shouldGetAStatusOfOkAndAViewOfStudentTemplate() throws Exception {
		when(studentRepo.findOne(1L)).thenReturn(studentOne);
		this.mockMvc.perform(get("/show-student?id=1")).andExpect(status().isOk())
				.andExpect(view().name("studentTemplate"));
	}

	@Test
	public void shouldAddAllStudentsToTheModel() throws Exception {
		when(studentRepo.findAll()).thenReturn(Arrays.asList(studentOne, studentTwo));
		this.mockMvc.perform(get("/show-students")).andExpect(model().attribute("studentModel", hasSize(2)));
	}

	@Test
	public void shouldAddSingleStudentToTheModel() throws Exception {
		when(studentRepo.findOne(1L)).thenReturn(studentOne);
		this.mockMvc.perform(get("/show-student?id=1")).andExpect(model().attribute("studentModel", is(studentOne)));
	}

	@Test
	public void shouldReturnStatusNotFoundForBadRequest() throws Exception {
		Long badId = 5L;
		when(studentRepo.findOne(badId)).thenReturn(null);
		this.mockMvc.perform(get("/show-student?id=1")).andExpect(status().isNotFound());
	}

}

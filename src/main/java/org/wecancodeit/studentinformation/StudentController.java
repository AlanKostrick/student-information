package org.wecancodeit.studentinformation;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

	@Resource
	private StudentRepository studentRepo;

	@RequestMapping("/show-students")
	public String findAllStudents(Model model) {
		model.addAttribute("studentModel", studentRepo.findAll());
		return "studentsTemplate";
	}

	@RequestMapping("/show-student")
	public String findOneStudent(@RequestParam Long id, Model model) throws StudentNotFoundException {

		if (studentRepo.findOne(id) == null) {
			throw new StudentNotFoundException();
		}
		model.addAttribute("studentModel", studentRepo.findOne(id));
		return "studentTemplate";
	}

}

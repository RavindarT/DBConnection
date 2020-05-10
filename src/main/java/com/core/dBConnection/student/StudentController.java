package com.core.dBConnection.student;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	static Logger logger = Logger.getLogger(StudentController.class);
	
	@Autowired
	StudentService studentService;

	@GetMapping("/getStudents")
	public List<StudentPojo> getStudents(){
		logger.info("Gets here");
		return studentService.getStudentsPojo();
	}
	
}

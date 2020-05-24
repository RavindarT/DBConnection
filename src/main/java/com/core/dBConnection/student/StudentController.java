package com.core.dBConnection.student;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.bytebuddy.implementation.bind.annotation.Pipe;

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
	
	@GetMapping("/getStudents/{id}")
	public Optional<StudentPojo> getStudents(@PathVariable(name = "id") Integer identifier){ // equalts to pathparam in JAX-RS
		logger.info("Gets here");
		return studentService.getStudentsPojo(identifier);
	}
	
	@GetMapping("/getStudentss")
	public Optional<StudentPojo> getStudentsParam(@RequestParam(value = "id", required = false) Integer identifier){
		logger.info("Gets here");
		return studentService.getStudentsPojo(identifier);
	}
	
	@PostMapping("/insertStudents")
	public String insertRecord(@RequestBody JSONObject jsonObject) {
		
		return studentService.insertRecord(jsonObject);
	}
	
	@PutMapping("/updateStudents")
	public String updateRecord(@RequestBody JSONObject jsonObject) {
		
		return studentService.insertRecord(jsonObject);
	
	}
	
	@PatchMapping("/partialUpdate")
	public String patchRecord(@RequestBody JSONObject jsonObject) {
		
		return studentService.patchRecord(jsonObject);
	
	}
	
}

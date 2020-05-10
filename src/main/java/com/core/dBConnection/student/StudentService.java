package com.core.dBConnection.student;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	static Logger logger = Logger.getLogger(StudentService.class);
	
	@Autowired
	private StudentCrud studentCrud;
	
	public List<StudentPojo> getStudentsPojo(){
		logger.info("Comes to service");
		return (List<StudentPojo>) studentCrud.findAll();
//		return null;
	}
	
}

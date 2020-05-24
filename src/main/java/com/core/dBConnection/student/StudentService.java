package com.core.dBConnection.student;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StudentService {

	static Logger logger = Logger.getLogger(StudentService.class);
	
	@Autowired
	private StudentCrud studentCrud;
	
	public List<StudentPojo> getStudentsPojo(){
		logger.info("Comes to service");
		RestTemplate restTemplate = new RestTemplate();
//		restTemplate.getForObject(url, responseType, uriVariables);
//		restTemplate.exchange(url, method, requestEntity, responseType);
		
		return (List<StudentPojo>) studentCrud.findAll();

	}
	
	public Optional<StudentPojo> getStudentsPojo(Integer id){
		logger.info("Comes to service");
		return studentCrud.findById(id);
	}
	
	public String insertRecord(JSONObject json){
		StudentPojo studentPojo = new StudentPojo();
		if (json.get("id") == null) {
			throw new RuntimeExceptionHandling(300, "Testttt");
		}
		logger.info("Comes to service");
		
		studentPojo.setId((Integer)json.get("id"));
		logger.info("Comes to service"+json.get("id"));
		studentPojo.setFirstName((String)json.get("firstname"));
		
		String sDate1=(String)json.get("dob");
		Date date1 = null;
		try {
			date1 = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		studentPojo.setDob(new java.sql.Date(date1.getTime()));
		studentPojo = studentCrud.save(studentPojo);
		return "Success";
	}
	
	public String patchRecord(JSONObject json){
		StudentPojo studentPojo = new StudentPojo();
		if (json.get("id") == null) {
			throw new RuntimeExceptionHandling(300, "Testttt");
		}
		logger.info("Comes to service");
		studentPojo.setFirstName((String)json.get("firstname")+"_new name");
		
		studentCrud.save(studentPojo);
		
		return "Success";
	}
}

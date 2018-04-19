package com.kesav.controllers;

import java.util.List;

import com.kesav.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.kesav.services.StudentService;

import javax.xml.ws.Response;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	/* @Value("${name}")
	private String mongoHost;*/

	@Autowired
	StudentService studentService;
	
	@RequestMapping( method=RequestMethod.GET)
	public List<Student> getAllPersons(){
//		System.out.println("****************"+mongoHost);
		return studentService.getAll();
	}
	

	@RequestMapping(value="/save",  method = RequestMethod.POST)
	public ResponseEntity savePerson(@RequestBody Student student){
		return studentService.save(student);
	}
	
	@RequestMapping(value = "/update/{id}",method=RequestMethod.PUT)
	public ResponseEntity updatePerson( @PathVariable String id , @RequestBody Student student){
		return studentService.updateStudent(id,student);
	}
	
	@RequestMapping( value="/remove/{id}",method = RequestMethod.DELETE)
	public void deletePerson(@PathVariable("id") String id){
		studentService.delete(id);
	}

}

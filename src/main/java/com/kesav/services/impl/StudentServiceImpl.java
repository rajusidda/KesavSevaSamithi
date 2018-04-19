package com.kesav.services.impl;

import java.util.List;

import com.kesav.model.Student;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kesav.repository.StudentRepository;
import com.kesav.services.StudentService;
import org.springframework.transaction.annotation.Transactional;

//@Transactional
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public List<Student> getAll() {
		return studentRepository.findAll();
	}

	@Override
	public ResponseEntity save(Student student) {
		 studentRepository.save(student);
		 return new ResponseEntity(HttpStatus.OK);
	}
	@Override
	public void delete(String id) {
		studentRepository.delete(id);
	}

	@Override
	public ResponseEntity updateStudent(String id,Student student) {
		studentRepository.save(student);
		return new ResponseEntity(HttpStatus.OK);
	}

	@Override
	public Student loadUserByUsername(String username) {
		// TODO Auto-generated method stub
		return studentRepository.findOne(username);
	}

}

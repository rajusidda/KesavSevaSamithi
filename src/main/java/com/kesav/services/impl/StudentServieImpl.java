package com.kesav.services.impl;

import java.util.List;

import com.kesav.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kesav.repository.StudentRepository;
import com.kesav.services.StudentService;

@Service
public class StudentServieImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		return (List<Student>) studentRepository.findAll();
	}

	@Override
	public void save(Student student) {
		// TODO Auto-generated method stub
		studentRepository.save(student);
	}
	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		studentRepository.delete(id);
	}

	@Override
	public void updatePerson(String id,Student student) {
		// TODO Auto-generated method stub
		studentRepository.save(student);
	}

	@Override
	public Student loadUserByUsername(String username) {
		// TODO Auto-generated method stub
		return studentRepository.findOne(username);
	}

}

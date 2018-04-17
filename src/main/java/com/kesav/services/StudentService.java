package com.kesav.services;

import java.util.List;

import com.kesav.model.Student;

public interface StudentService {

	List<Student> getAll();

	void save(Student student);

	void delete(String id);

	void updatePerson(String id,Student student);

	Student loadUserByUsername(String username);

}

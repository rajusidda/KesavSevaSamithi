package com.kesav.services;

import java.util.List;

import com.kesav.model.Student;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;

public interface StudentService {

	List<Student> getAll();

	ResponseEntity save(Student student);

	void delete(String id);

	ResponseEntity updateStudent(String id,Student student);

	Student loadUserByUsername(String username);

}

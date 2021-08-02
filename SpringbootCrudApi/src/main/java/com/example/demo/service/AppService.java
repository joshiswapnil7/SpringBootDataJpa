package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Student;

public interface AppService {

	void save(Student student);

	List<Student> getAllStudent();

	void deleteById(int id);

	Student getStudentById(int id);

}

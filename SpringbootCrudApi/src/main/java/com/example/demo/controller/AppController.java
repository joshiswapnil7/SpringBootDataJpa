package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.AppService;

@RestController
public class AppController {

	@Autowired
	private AppService service;
	
	
	@PostMapping("/student")
	public void storeData(@RequestBody Student student) {
		service.save(student);
		
	}
	
	@GetMapping("/getAll")
	public List<Student> getAll(){
		
		return service.getAllStudent();
	}
	
	@GetMapping("/{id}")
	public Student getStudent(@PathVariable("id")int id) {
		return service.getStudentById(id);
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id")int id) {
		
		service.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable("id")int id,@RequestBody Student stu) {
		stu.setId(id);
		service.save(stu);
		return stu;
		
	}
	
	
	
	
	
}

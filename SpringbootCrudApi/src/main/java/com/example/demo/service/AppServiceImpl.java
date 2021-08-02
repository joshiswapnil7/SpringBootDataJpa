package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.AppDao;

@Service
public class AppServiceImpl implements AppService{

	@Autowired
	private AppDao dao;
	
	
	@Override
	public void save(Student student) {

		dao.save(student);
	}


	@Override
	public List<Student> getAllStudent() {
		return dao.findAll();
	}


	@Override
	public void deleteById(int id) {

		dao.deleteById(id);
	}


	@Override
	public Student getStudentById(int id) {
		return dao.findById(id).get();
	}

}

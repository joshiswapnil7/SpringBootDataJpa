package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentDao;

@SpringBootTest
class SpringbootDataJpaApplicationTests {

	@Autowired
	private StudentDao dao;

	@Test
	void testSaveMethod() {

		Student student = new Student();
		student.setId(1L);
		student.setName("swapnil");
		student.setTestScore(55);
		dao.save(student);

		Student s = dao.findById(1L).get();
		assertNotNull(s);

	}

	@Test
	public void getStudent() {

		Student student = new Student();
		student.setId(1L);
		student.setName("swapnil");
		student.setTestScore(55);
		dao.save(student);

		Student s = dao.findById(1L).get();
		assertNotNull(s);

		assertEquals("swapnil", s.getName());

	}

	@Test
	public void testDeleteMethod() throws Exception {
		Student student = new Student();
		student.setId(1L);
		student.setName("swapnil");
		student.setTestScore(55);
		dao.save(student);

		Optional<Student> s=dao.findById(1L);
		assertTrue(s.isPresent());
		
		
		dao.deleteById(1L);
		
		Optional<Student> s1=dao.findById(1L);

		assertFalse(s1.isPresent());
		
		
	}
	
	@Test
	public void testUpdateMethod() {
		Student student = new Student();
		student.setId(1L);
		student.setName("swapnil");
		student.setTestScore(55);
		dao.save(student);
		
		Student student2=new Student();
		student2.setId(1L);
		student2.setName("abc");
		dao.save(student2);
		
		Student s=dao.findById(1L).get();
		
		assertEquals("abc", s.getName());
		
		
		
		
		
	}

}

package com.dao;

import java.util.List;

import com.model.Student;

public interface StudentDAO {
	
	int saveStudent(Student student);
	
	List<Student> getAllStudents();
	
	int updateStudent(Student student);
	
	Student findStudentById(int id);
	
	int deleteStudent(int id);

}

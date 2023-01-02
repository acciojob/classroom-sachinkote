package com.driver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
    @Autowired
	StudentRepository repo;
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		repo.addStudent(student);
	}

	public void addTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		repo.addTeacher(teacher);
	}

	public void addStudentTeacherPair(String student, String teacher) {
		// TODO Auto-generated method stub
		repo.addStudentTeacherPair(student,teacher);
	}

	public Student getStudentByName(String name) {
		// TODO Auto-generated method stub
		Student student= repo.getStudentByName(name);
		return student;
	}

	public Teacher getTeacherByName(String name) {
		// TODO Auto-generated method stub
		Teacher teacher=repo. getTeacherByName(name);
		return teacher;
	}

	public List<String> getStudentsByTeacherName(String teacher) {
		// TODO Auto-generated method stub
		List<String> list=repo.getStudentsByTeacherName(teacher);
		return list;
	}

	public List<String> getAllStudents() {
		// TODO Auto-generated method stub
		List<String>list=repo.getAllStudents();
		return list;
	}

	public void deleteTeacherByName(String teacher) {
		// TODO Auto-generated method stub
		repo.deleteTeacherByName(teacher);
	}

	public void deleteAllTeachers() {
		// TODO Auto-generated method stub
		repo.deleteAllTeachers();
		
	}

}

package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

	 HashMap<String,Student> StudentHashMap= new HashMap<>();
	 HashMap<String,Teacher> TeacherHashMap= new HashMap<>();
	 HashMap<String,List<String>> TeacherStudentPair= new HashMap<>();
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		StudentHashMap.put(student.getName(), student);
	}
	public void addTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		TeacherHashMap.put(teacher.getName(), teacher);
	}
	public void addStudentTeacherPair(String student, String teacher) {
		// TODO Auto-generated method stub
		if(StudentHashMap.containsKey(student) && TeacherHashMap.containsKey(teacher))
		{
			List<String> StudentList=new ArrayList<>();
			if(TeacherStudentPair.containsKey(teacher))
			{
				StudentList=TeacherStudentPair.get(teacher);
				
			}
			StudentList.add(student);
			TeacherStudentPair.put(teacher, StudentList);
					
		
		}
	}
	public Student getStudentByName(String name) {
		// TODO Auto-generated method stub
		return StudentHashMap.get(name);
	}
	public Teacher getTeacherByName(String name) {
		// TODO Auto-generated method stub
		return TeacherHashMap.get(name);
	}
	public List<String> getStudentsByTeacherName(String teacher) {
		// TODO Auto-generated method stub
		List<String> list=TeacherStudentPair.get(teacher);
		return list;
	}
	public List<String> getAllStudents() {
		// TODO Auto-generated method stub
		return new ArrayList<>(StudentHashMap.keySet());
	}
	public void deleteTeacherByName(String teacher) {
		// TODO Auto-generated method stub
		 List<String> studnets=new ArrayList<>();
		 if(TeacherStudentPair.containsKey(teacher))
		 {
			 studnets=TeacherStudentPair.get(teacher);
			 for(String student:studnets)
			 {
				 if(StudentHashMap.containsKey(student))
				 {
					 StudentHashMap.remove(student);
				 }
			 }
			 TeacherStudentPair.remove(teacher);
		 }
		 if(TeacherHashMap.containsKey(teacher))
			 TeacherHashMap.remove(teacher);
	}
	public void deleteAllTeachers() {
		// TODO Auto-generated method stub
		HashSet<String> StudentSet=new HashSet<>();
		 TeacherHashMap=new HashMap<>();
		 
		 for(String teacher : TeacherStudentPair.keySet())
		 {
			 for(String studnet:  TeacherStudentPair.get(teacher))
			 {
				 StudentSet.add(studnet);
			 }
		 }
		 
		 for(String sudent :StudentSet)
		 {
			 if(StudentHashMap.containsKey(sudent))
			 {
				 StudentHashMap.remove(sudent);
			 }
		 }
	}
	   
	   
	
}

package com.curd.spring.practice.service;

import java.util.List;

import com.curd.spring.practice.dto.StudentDto;

public interface StudentService {
	
	public StudentDto createStudent(StudentDto stdDto);
	public List<StudentDto> getAllStudent();
	public void deleteById(Integer id);
	public StudentDto fetchById(Integer id);
	public StudentDto update(Integer id,StudentDto stdto);

}

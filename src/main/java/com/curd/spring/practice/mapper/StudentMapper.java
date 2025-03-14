package com.curd.spring.practice.mapper;

import com.curd.spring.practice.dto.StudentDto;
import com.curd.spring.practice.entity.Student;

public class StudentMapper {
	
	
	public static Student mapToStudent(StudentDto studentDto) {
		
		return new Student(
				
				studentDto.getId(),
				studentDto.getFirstName(),
				studentDto.getLastName(),
				studentDto.getAge()
				);
				
		}
	
	
	public static StudentDto mapToStudentDto(Student std) {
		
		return new StudentDto(
				
				std.getId(),
				std.getFirstName(),
				std.getLastName(),
				std.getAge()
				);
		
	}

}

package com.curd.spring.practice.serviceImp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.curd.spring.practice.dto.StudentDto;
import com.curd.spring.practice.entity.Student;
import com.curd.spring.practice.exception.ResourceNotFound;
import com.curd.spring.practice.mapper.StudentMapper;
import com.curd.spring.practice.repository.StudentRepository;
import com.curd.spring.practice.service.StudentService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class StudentServiceImp implements StudentService {
	
	
	private StudentRepository stdRepo;

	
	public StudentDto createStudent(StudentDto stdDto) {
		Student std=StudentMapper.mapToStudent(stdDto);
		Student saved=stdRepo.save(std);
		
		
		return StudentMapper.mapToStudentDto(saved);
	}


	@Override
	public List<StudentDto> getAllStudent() {
		List<Student> std=stdRepo.findAll();
		
		return std.stream().map(x->StudentMapper.mapToStudentDto(x)).toList();
	}


	@Override
	public void deleteById(Integer id) {
		Student find=stdRepo.findById(id).orElseThrow(()->new ResourceNotFound("Student id not found"));
		stdRepo.deleteById(id);
		
		
	}


	@Override
	public StudentDto fetchById(Integer id) {
		Student find=stdRepo.findById(id).orElseThrow(()->new ResourceNotFound("Student id not found"));
		return StudentMapper.mapToStudentDto(find);
	}


	@Override
	public StudentDto update(Integer id, StudentDto stdto) {
		Student find=stdRepo.findById(id).orElseThrow(()->new ResourceNotFound("Student id not found"));
		find.setFirstName(stdto.getFirstName());
		find.setLastName(stdto.getLastName());
		find.setAge(stdto.getAge());
		Student saved=stdRepo.save(find);
		
		
		return StudentMapper.mapToStudentDto(saved);
	}

}

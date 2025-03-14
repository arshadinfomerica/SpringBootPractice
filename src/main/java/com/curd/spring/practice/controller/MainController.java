package com.curd.spring.practice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.curd.spring.practice.dto.StudentDto;
import com.curd.spring.practice.service.StudentService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@RestController()
@RequestMapping("/api/student")
public class MainController {
	
	private StudentService stdService;
	
	
	@PostMapping
	public ResponseEntity<StudentDto> createStd(@RequestBody StudentDto stdDto){
		log.info("Insert Student");
		StudentDto std=stdService.createStudent(stdDto);
		log.info("Inserted Students {} :",std);
		return new ResponseEntity<>(std,HttpStatus.CREATED);
		
		
	}
	
	
	@GetMapping("/getAllStudent")
	public ResponseEntity<List<StudentDto>> getAll(){
		log.info("Get All Students");
		List<StudentDto> all=stdService.getAllStudent();
		log.info("Got all student {} :",all);
		return ResponseEntity.ok(all);
		
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		log.info("id for delete {} :",id);
		stdService.deleteById(id);
		return ResponseEntity.ok("Deleted");
		
		
		
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<StudentDto> update(@PathVariable int id,@RequestBody StudentDto stddto){
		log.info("Updating Student");
		StudentDto update = stdService.update(id, stddto);
		log.info("Updated student details {} :",update);
		return ResponseEntity.ok(update);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<StudentDto> fetchById(@PathVariable int id){
		log.info("Fetch Student by id {} :",id);
		StudentDto fetch=stdService.fetchById(id);
		log.info("Student {} :",fetch);
		return ResponseEntity.ok(fetch);
	}
	

}

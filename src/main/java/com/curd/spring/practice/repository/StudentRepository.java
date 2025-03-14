package com.curd.spring.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curd.spring.practice.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}

package com.example.Alumni.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Alumni.Entities.Student;


public interface StudentsRepo extends JpaRepository<Student, Integer> {
	
}

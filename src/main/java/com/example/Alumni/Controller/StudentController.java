package com.example.Alumni.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Alumni.Entities.Student;
import com.example.Alumni.Service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	@Autowired
StudentService studentservice;
	@GetMapping("/{id}")
	public  ResponseEntity<?> getStudentById(@PathVariable int id) {
	return studentservice.getStudentById(id);
	}
	@GetMapping("/")
	public ResponseEntity<?>getAllStudent(){
		return studentservice.getAllStudents()
	;}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteStudent(@ PathVariable int id){
		return studentservice.deleteStudent(id);
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> updateStudentById(@PathVariable int id ,@RequestBody Student s){
		System.out.println(s.getDepartment());
		return studentservice.updateStudent(id, s);
	}
}

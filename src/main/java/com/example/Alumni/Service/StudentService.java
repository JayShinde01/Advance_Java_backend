package com.example.Alumni.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Alumni.Entities.Student;
import com.example.Alumni.Repo.StudentsRepo;

@Service
public class StudentService {

    @Autowired
    private StudentsRepo repo;
    @Autowired
    private UserService user;

 
    public ResponseEntity<String> updateStudent(int id, Student updatedStudent) {
        try {
            Optional<Student> optional = repo.findById(id);
System.out.println("in service");
            if (optional.isPresent()) {
                Student student = optional.get();

                // update fields
                student.setPrn(updatedStudent.getPrn());
                student.setDepartment(updatedStudent.getDepartment());
                student.setYear(updatedStudent.getYear());
                student.setStatus(updatedStudent.getStatus());
                student.setUser(updatedStudent.getUser()); // only if updating user as well
                
                repo.save(student);
                
                System.out.println("below repo");
                return ResponseEntity.status(HttpStatus.OK)
                        .body("Student updated successfully!");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Student with ID " + id + " not found.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error updating student: " + e.getMessage());
        }
    }

    // ✅ Get all Students
    public ResponseEntity<?> getAllStudents() {
        List<Student> students = repo.findAll();
        if (!students.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(students);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No Students Present");
        }
    }

    // ✅ Get Student by ID
    public ResponseEntity<?> getStudentById(int id) {
    	System.out.println("in std ser");
        Optional<Student> optional = repo.findById(id);
        if (optional.isPresent()) {
        	System.out.println("in if");
            return ResponseEntity.status(HttpStatus.OK).body(optional.get());
        } else {
        	System.out.println("in else");
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Student with ID " + id + " not found.");
        }
    }

    // ✅ Delete Student by ID
    public ResponseEntity<String> deleteStudent(int id) {
        try {
        
            Optional<Student> optional = repo.findById(id);
            if (optional.isPresent()) {
            	
                repo.deleteById(id);
                user.deleteUser(id);
                return ResponseEntity.status(HttpStatus.OK)
                        .body("Student deleted successfully!");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Student with ID " + id + " not found.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error deleting student: " + e.getMessage());
        }
    }
}

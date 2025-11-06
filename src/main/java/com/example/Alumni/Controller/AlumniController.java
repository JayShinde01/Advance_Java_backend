package com.example.Alumni.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Alumni.Entities.Alumni;
import com.example.Alumni.Service.AlumniService;

@RestController
@RequestMapping("/api/alumni")
public class AlumniController {

	@Autowired
	AlumniService alumniservice;
	
	@GetMapping("/getall")
	public ResponseEntity<?>getAllAlumni(){
		System.out.println("in all alumni");
		return alumniservice.getAllAlumni();
	}
	@GetMapping("/{id}")
	public ResponseEntity<?>getAlumniById(@PathVariable int id){
		return alumniservice.getAlumniById(id);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?>deleteAlumniById(@PathVariable int id){
		return alumniservice.deleteAlumni(id);
	}
	@PutMapping("/{id}")
	public ResponseEntity<?>updateAlumniById(@PathVariable int id,@RequestBody Alumni a){
		return alumniservice.updateAlumni(id ,a);
	}
	
}

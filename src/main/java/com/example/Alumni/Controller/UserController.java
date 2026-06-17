package com.example.Alumni.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.example.Alumni.Entities.User;
import com.example.Alumni.Security.JwtUtil;
import com.example.Alumni.Service.UserService;

@RestController
@CrossOrigin(allowedHeaders = "*")
public class UserController {


	
	@Autowired
	UserService userservice;


    @Autowired
    private JwtUtil jwtUtil;

  

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginRequest) {
    	ResponseEntity<?> response = userservice.logIn(loginRequest.getEmail(),loginRequest.getPassword(),loginRequest.getRole().toString());
    	if(response != null ) {
    	return response;
    	
        } else {
            return ResponseEntity.status(401).body("Invalid email or password");
        }
    }

	@PostMapping("/registeruser")
	public void registerUser(@RequestBody User u) {
		System.out.println("in controller");
		userservice.registerUser(u);
	}
	
	@GetMapping("/")
	public void home() {
		System.out.println("in home route");
		
	}
	
	
	
}

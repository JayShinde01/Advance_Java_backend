package com.example.Alumni.Service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.Alumni.Entities.*;
import com.example.Alumni.Repo.*;
import com.example.Alumni.Security.JwtUtil;


@Service
public class UserService {

    @Autowired
    private UserRepo userrepo;

    @Autowired
    private StudentsRepo studentRepo;

    @Autowired
    private AlumniRepo alumnirepo;

    @Autowired
    private AdminRepo adminrepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    // ✅ Login method
    public ResponseEntity<?> logIn(String email, String pass,String role) {
        User user = userrepo.getByEmail(email);
        if (user != null && passwordEncoder.matches(pass, user.getPassword()) && 
        		role.equals(user.getRole().toString())) {
        	String token = null;
			try {
				token = jwtUtil.generateToken(user.getEmail());
			} catch (Exception e) {
				
				e.printStackTrace();
			}

            Map<String, Object> response = new HashMap<>();
            response.put("token", token);
            response.put("message", "Login successful");
            response.put("role",user.getRole().toString());
            response.put("id",user.getUserId());
            response.put("email",user.getEmail());
            return ResponseEntity.ok(response);
        	
        }
        return null; // invalid login
    }

    // ✅ Registration method
    public void registerUser(User u) {
        // encode password before saving
        u.setPassword(passwordEncoder.encode(u.getPassword()));

        // Save base user
        userrepo.save(u);

        // Save related entity based on role
        if (u.getRole() == User.Role.STUDENT) {
            Student student = new Student();
            student.setUser(u);
            studentRepo.save(student);

        } else if (u.getRole() == User.Role.ALUMNI) {
            Alumni alumni = new Alumni();
            alumni.setUser(u);
            alumnirepo.save(alumni);

        } else if (u.getRole() == User.Role.ADMIN) {
            Admin admin = new Admin();
            admin.setUser(u);
            adminrepo.save(admin);
        }
    }
    //get user by id
    public User getUserById(int id) {
    	return userrepo.findById(id).get();
   }
 // Delete user by ID
    public ResponseEntity<String> deleteUser(int id) {
        try {
            Optional<User> optional = userrepo.findById(id);
            if (optional.isPresent()) {
            	userrepo.deleteById(id);
                return ResponseEntity.status(HttpStatus.OK)
                        .body("User deleted successfully!");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("User with ID " + id + " not found.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error deleting user: " + e.getMessage());
        }
    }
    }


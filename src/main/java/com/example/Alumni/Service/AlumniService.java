package com.example.Alumni.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import com.example.Alumni.Entities.Alumni;
import com.example.Alumni.Entities.User;
import com.example.Alumni.Repo.AlumniRepo;

@Service
public class AlumniService {

   

	@Autowired
	AlumniRepo alumnirepo;
	

	@Autowired
   UserService userservice;
	
	public ResponseEntity<String> updateAlumni(int id , Alumni a) {
	    try {
	    	Optional<Alumni> optional= alumnirepo.findById(id);
	    	
	    	if(optional.isPresent()) {
	    		Alumni alumni = optional.get()
;	    	alumni.setPrn(a.getPrn());
	    	alumni.setCompanyName(a.getCompanyName());
	    	alumni.setPosition(a.getPosition());
	    	alumni.setTechStack(a.getTechStack());
	    	alumni.setProfilePic(a.getProfilePic());
	    	alumni.setTechStack(a.getTechStack());
	    	
	        alumnirepo.save(alumni);
	        return ResponseEntity.status(HttpStatus.OK)
                    .body("Alumni updated successfully!");
	    } else {
	    	return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Alumni with ID " + a.getAlumniId() + " not found.");
	    }
		} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error updating alumni: " + e.getMessage());
			}
	    
	}
	
	// get all alumnis 
	public ResponseEntity<?> getAllAlumni(){
		List<Alumni> ls = alumnirepo.findAll();
		if(!ls.isEmpty()) {
		return ResponseEntity.status(HttpStatus.OK).body(ls);
		}else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No Alumni Present");
		}	
			
		}
	
	//get alumni by Id
	public ResponseEntity<?> getAlumniById(int id){
		Optional<Alumni> op = alumnirepo.findById(id);
		if(op.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(op.get());
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Alumni with ID " + id + " not found.");
		}
		
	}
	
	// Delete Alumni by ID
	public ResponseEntity<String> deleteAlumni(int id) {
	    try {
	        Optional<Alumni> optional = alumnirepo.findById(id);
	        if (optional.isPresent()) {
	            alumnirepo.deleteById(id);
	            userservice.deleteUser(id);
	            return ResponseEntity.status(HttpStatus.OK)
	                    .body("Alumni deleted successfully!");
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                    .body("Alumni with ID " + id + " not found.");
	        }
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body("Error deleting alumni: " + e.getMessage());
	    }
	}
	
}



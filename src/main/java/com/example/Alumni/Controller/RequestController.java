package com.example.Alumni.Controller;


import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.example.Alumni.Entities.InterviewRequest;
import com.example.Alumni.Service.InterviewRequestService;

@RestController
@CrossOrigin(allowedHeaders = "*")
public class RequestController {
	
	@Autowired
	InterviewRequestService interviewreq;
	
	@GetMapping("/getallrequests")
	public List<InterviewRequest> getAllRequest(){
		return interviewreq.getAllRequest();
	}
	@GetMapping("/getbystudent/{studentId}")
	public List<InterviewRequest>getAllRequestByStudent(@PathVariable int studentId){
		System.out.println("in control");
		return 	 interviewreq.getAllRequestByStudent(studentId)  ;
       }
	@GetMapping("/getbyalumni/{alumniId}")
	public List<InterviewRequest>getRequestsByAlumni(@PathVariable int alumniId){
		return interviewreq.getRequestsByAlumni(alumniId);
		   }
	@PostMapping("/createreq")
	public InterviewRequest createRquest(@RequestBody InterviewRequest req ) {
		return interviewreq.createRquest(req);
	}
	@PutMapping("/updatestatus/{reqId}")
	public InterviewRequest updateStatus(@PathVariable int reqId,@RequestBody InterviewRequest toUpdate){
		return interviewreq.updateStatus(reqId,toUpdate);
	}
	
	@PutMapping("/reschedule/{reqId}")
	public ResponseEntity<InterviewRequest> reschedule(
	        @PathVariable int reqId,
	        @RequestBody Map<String, String> body) {
	    
	    String reDate = body.get("date");
	    String reStart = body.get("startTime");
	    String reEnd = body.get("endTime");

	    InterviewRequest updated = interviewreq.reshchedule(reqId, reDate, reStart, reEnd);
	    if (updated != null) {
	        return ResponseEntity.ok(updated);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	@DeleteMapping("/delete/{reqId}")
	public ResponseEntity<String> deleteRequest(@PathVariable int reqId) {
	    boolean deleted = interviewreq.deleteRequest(reqId);
	    if (deleted) {
	        return ResponseEntity.ok("Request deleted successfully");
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                .body("Request not found with id: " + reqId);
	    }
	}


	}



package com.example.Alumni.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Alumni.Entities.InterviewRequest;
import com.example.Alumni.Repo.InterviewRequestRepo;
@Service
public class InterviewRequestService {

    @Autowired
    private InterviewRequestRepo reqrepo;

    // 1. Create Request
    public InterviewRequest createRquest(InterviewRequest req) {
        req.setStatus(InterviewRequest.Status.PENDING);
        return reqrepo.save(req);
    }

    // 2. Get All Requests (Admin)
    public List<InterviewRequest> getAllRequest() {
        return reqrepo.findAll();
    }

    // 3. Get Requests by Student
    public List<InterviewRequest> getAllRequestByStudent(int studentId) {
        return reqrepo.findByStudentId(studentId);
    }

    // 4. Get Requests by Alumni
    public List<InterviewRequest> getRequestsByAlumni(int alumniId) {
        return reqrepo.findByAlumniId(alumniId);
    }

    // 5. Update Status (Approve/Reject + Add MeetLink)
    public InterviewRequest updateStatus(int id, InterviewRequest updated) {
        InterviewRequest req = reqrepo.findById(id).orElse(null);

        if (req != null) {
            if (updated.getStatus() != null) {
                req.setStatus(updated.getStatus());
            }
            if (updated.getMeetLink() != null && !updated.getMeetLink().isEmpty()) {
                req.setMeetLink(updated.getMeetLink());
            }
            if (updated.getDate() != null) {
                req.setDate(updated.getDate());
            }
            if (updated.getStartTime() != null) {
                req.setStartTime(updated.getStartTime());
            }
            if (updated.getEndTime() != null) {
                req.setEndTime(updated.getEndTime());
            }
            return reqrepo.save(req);
        }
        return null;
    }

    // 6. Reschedule Interview
    public InterviewRequest reshchedule(int reqId, String reDate, String reStart, String reEnd) {
        InterviewRequest req = reqrepo.findById(reqId).orElse(null);

        if (req != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

            LocalDateTime d = LocalDateTime.parse(reDate, formatter);
            LocalDateTime s = LocalDateTime.parse(reStart, formatter);
            LocalDateTime e = LocalDateTime.parse(reEnd, formatter);

            req.setDate(d);
            req.setStartTime(s);
            req.setEndTime(e);

            return reqrepo.save(req);
        }
        return null;
    }

    // 7. Cancel Request
    public boolean deleteRequest(int reqId) {
        if (reqrepo.existsById(reqId)) {
            reqrepo.deleteById(reqId);
            return true;
        }
        return false;
    }
}

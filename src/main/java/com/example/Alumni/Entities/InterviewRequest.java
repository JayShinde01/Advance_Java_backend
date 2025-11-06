package com.example.Alumni.Entities;

import java.time.LocalDateTime;

import jakarta.persistence.*;


@Entity
@Table(name = "interview_requests")
public class InterviewRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reqId;

    @Column(nullable = false)
    private int studentId;

    @Column(nullable = false)
    private int alumniId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    private String meetLink;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column(nullable = false)
    private LocalDateTime endTime;

    // 🔹 Constructors
    public InterviewRequest() {}

    public InterviewRequest(int studentId, int alumniId, Status status, String meetLink,
                            LocalDateTime date, LocalDateTime startTime, LocalDateTime endTime) {
        this.studentId = studentId;
        this.alumniId = alumniId;
        this.status = status;
        this.meetLink = meetLink;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public int getReqId() {
		return reqId;
	}

	public void setReqId(int reqId) {
		this.reqId = reqId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getAlumniId() {
		return alumniId;
	}

	public void setAlumniId(int alumniId) {
		this.alumniId = alumniId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getMeetLink() {
		return meetLink;
	}

	public void setMeetLink(String meetLink) {
		this.meetLink = meetLink;
	}
	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}


	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	public enum Status{
    	PENDING, APPROVED, REJECTED, COMPLETED
    }
}

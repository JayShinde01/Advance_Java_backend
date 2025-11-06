package com.example.Alumni.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    private int studentId; // This will be same as userId (PK + FK)

    private String prn;
    private String department;

    
    private String year;

    @OneToOne
    @MapsId   // Shares PK with users
    @JoinColumn(name = "student_id") // FK to users.id
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status = Status.Active;

    public Student() {
    }

    public Student(int studentId, String prn, String department, String year, User user, Status status) {
        this.studentId = studentId;
        this.prn = prn;
        this.department = department;
        this.year = year;
        this.user = user;
        this.status = status;
    }

    // Getters & Setters
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getPrn() {
        return prn;
    }

    public void setPrn(String prn) {
        this.prn = prn;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public enum Status {
        Active, Inactive
    }
}

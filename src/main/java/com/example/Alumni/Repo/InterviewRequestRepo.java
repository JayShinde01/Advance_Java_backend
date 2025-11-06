package com.example.Alumni.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Alumni.Entities.InterviewRequest;

public interface InterviewRequestRepo extends JpaRepository<InterviewRequest,Integer> {
 public List<InterviewRequest> findByStudentId(int id);
 public List<InterviewRequest> findByAlumniId(int id);
}

package com.example.Alumni.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Alumni.Entities.StudentMentorSubscription;

import com.example.Alumni.Entities.Alumni;
import com.example.Alumni.Entities.Student;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentMentorSubscriptionRepository extends JpaRepository<StudentMentorSubscription, Long> {

    // Find subscriptions by student
    List<StudentMentorSubscription> findByStudent(Student student);

    // Find subscriptions by alumni (mentor)
    List<StudentMentorSubscription> findByAlumni(Alumni alumni);

    // Find active subscriptions (end date still in future)
    List<StudentMentorSubscription> findByEndAtAfter(java.time.LocalDateTime now);

    // Find expired subscriptions
    List<StudentMentorSubscription> findByEndAtBefore(java.time.LocalDateTime now);

    // Find subscription by student + plan (to check if duplicate subscription exists)
    Optional<StudentMentorSubscription> findByStudentAndPlan(Student student, com.example.Alumni.Entities.SubscriptionPlan plan);
}

package com.example.Alumni.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Alumni.Entities.StudentMentorSubscription;
import com.example.Alumni.Repo.StudentMentorSubscriptionRepository;
@Service
public class StudentMentorSubscriptionService {

    @Autowired
    private final StudentMentorSubscriptionRepository repo;

    public StudentMentorSubscriptionService(StudentMentorSubscriptionRepository repo) {
        this.repo = repo;
    }

    // Get all subscriptions
    public List<StudentMentorSubscription> getAllSubscriptions() {
        return repo.findAll();
    }

    // Get subscription by ID
    public Optional<StudentMentorSubscription> getSubscriptionById(Long id) {
        return repo.findById(id);
    }

    // Get subscriptions by Student ID
//    public List<StudentMentorSubscription> getSubscriptionsByStudentId(Long studentId) {
//        return repo.findByStudentId(studentId);
//    }

    // Get subscriptions by Alumni ID
//    public List<StudentMentorSubscription> getSubscriptionsByAlumniId(Long alumniId) {
//        return repo.findByAlumniId(alumniId);
//    }

    // Check if a subscription is active
    public boolean isSubscriptionActive(Long subId) {
        StudentMentorSubscription sub = repo.findById(subId)
                .orElseThrow(() -> new RuntimeException("Subscription not found"));
        return sub.getEndAt() == null || sub.getEndAt().isAfter(java.time.LocalDateTime.now());
    }

    // Create subscription
    public StudentMentorSubscription createSubscription(StudentMentorSubscription sub) {
        sub.setStartAt(java.time.LocalDateTime.now());
        return repo.save(sub);
    }

    // Update subscription
    public StudentMentorSubscription updateSubscription(Long id, StudentMentorSubscription subDetails) {
        StudentMentorSubscription sub = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Subscription not found"));

        sub.setStudent(subDetails.getStudent());
        sub.setAlumni(subDetails.getAlumni());
        sub.setPlan(subDetails.getPlan());
        sub.setStartAt(subDetails.getStartAt());
        sub.setEndAt(subDetails.getEndAt());
        sub.setCreditsCurrentMonth(subDetails.getCreditsCurrentMonth());
        sub.setMonthCycleStart(subDetails.getMonthCycleStart());

        return repo.save(sub);
    }

    // Reduce session credits
    public void useSession(Long subId) {
        StudentMentorSubscription sub = repo.findById(subId)
                .orElseThrow(() -> new RuntimeException("Subscription not found"));

        if (sub.getCreditsCurrentMonth() > 0) {
            sub.setCreditsCurrentMonth(sub.getCreditsCurrentMonth() - 1);
            repo.save(sub);
        } else {
            throw new RuntimeException("No credits left for this month");
        }
    }

    // Delete subscription
    public void deleteSubscription(Long id) {
        repo.deleteById(id);
    }
}

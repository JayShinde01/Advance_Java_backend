package com.example.Alumni.Service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Alumni.Entities.SubscriptionPlan;
import com.example.Alumni.Repo.SubscriptionPlanRepository;
@Service
public class SubscriptionPlanService {

    @Autowired
    private final SubscriptionPlanRepository repo;

    public SubscriptionPlanService(SubscriptionPlanRepository repo) {
        this.repo = repo;
    }

    // Get all plans
    public List<SubscriptionPlan> getAllPlans() {
        return repo.findAll();
    }

    // Get plan by id
    public Optional<SubscriptionPlan> getPlanById(Long id) {
        return repo.findById(id);
    }

    // Get plan by name
    public Optional<SubscriptionPlan> getPlanByName(String name) {
        return repo.findByName(name);
    }

    // Create plan
    public SubscriptionPlan createPlan(SubscriptionPlan plan) {
        return repo.save(plan);
    }

    // Update plan
    public SubscriptionPlan updatePlan(Long id, SubscriptionPlan planDetails) {
        SubscriptionPlan plan = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Plan not found"));

        plan.setName(planDetails.getName());
        plan.setDurationMonths(planDetails.getDurationMonths());
        plan.setSessionsPerMonth(planDetails.getSessionsPerMonth());

        return repo.save(plan);
    }

    // Delete plan
    public void deletePlan(Long id) {
        repo.deleteById(id);
    }

    // Check if plan exists
    public boolean existsByName(String name) {
        return repo.existsByName(name);
    }
}

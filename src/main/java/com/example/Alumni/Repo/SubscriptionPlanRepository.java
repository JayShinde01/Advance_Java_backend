package com.example.Alumni.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Alumni.Entities.SubscriptionPlan;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubscriptionPlanRepository extends JpaRepository<SubscriptionPlan, Long> {

    // Find plan by exact name
    Optional<SubscriptionPlan> findByName(String name);

    // Find all plans with sessions greater than given number
    List<SubscriptionPlan> findBySessionsPerMonthGreaterThan(int sessions);

    // Find plans with duration between min and max
    List<SubscriptionPlan> findByDurationMonthsBetween(int min, int max);

    // Find all plans sorted by sessions per month
    List<SubscriptionPlan> findAllByOrderBySessionsPerMonthDesc();
    // Check if plan with given name exists
    boolean existsByName(String name);
}

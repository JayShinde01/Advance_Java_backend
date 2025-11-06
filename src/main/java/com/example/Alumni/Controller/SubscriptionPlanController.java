package com.example.Alumni.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Alumni.Entities.SubscriptionPlan;
import com.example.Alumni.Service.SubscriptionPlanService;

@RestController
@RequestMapping("/api/plans")
public class SubscriptionPlanController {

	@Autowired
    private  SubscriptionPlanService service;

   

    @GetMapping
    public List<SubscriptionPlan> getAllPlans() {
        return service.getAllPlans();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubscriptionPlan> getPlanById(@PathVariable Long id) {
        return service.getPlanById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public SubscriptionPlan createPlan(@RequestBody SubscriptionPlan plan) {
        return service.createPlan(plan);
    }

    @PutMapping("/{id}")
    public SubscriptionPlan updatePlan(@PathVariable Long id, @RequestBody SubscriptionPlan plan) {
        return service.updatePlan(id, plan);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlan(@PathVariable Long id) {
        service.deletePlan(id);
        return ResponseEntity.noContent().build();
    }
}


package com.example.Alumni.Entities;

import java.util.List;

import jakarta.persistence.*;


@Entity
@Table(name="subscription_plan")
public class SubscriptionPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long planId;

    private String name;
    private Integer durationMonths;
    private Integer sessionsPerMonth;

    @OneToMany(mappedBy = "plan")
    private List<StudentMentorSubscription> subscriptions;

	public Long getPlanId() {
		return planId;
	}

	public void setPlanId(Long planId) {
		this.planId = planId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDurationMonths() {
		return durationMonths;
	}

	public void setDurationMonths(Integer durationMonths) {
		this.durationMonths = durationMonths;
	}

	public Integer getSessionsPerMonth() {
		return sessionsPerMonth;
	}

	public void setSessionsPerMonth(Integer sessionsPerMonth) {
		this.sessionsPerMonth = sessionsPerMonth;
	}

	public List<StudentMentorSubscription> getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(List<StudentMentorSubscription> subscriptions) {
		this.subscriptions = subscriptions;
	}



    
}




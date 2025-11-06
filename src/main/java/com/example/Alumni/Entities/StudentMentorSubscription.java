package com.example.Alumni.Entities;
import java.time.*;

import jakarta.persistence.*;



@Entity
@Table(name="student_mentor_subscription")
public class StudentMentorSubscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subId;

    // Many students can subscribe to 1 alumni
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "alumni_id", nullable = false)
    private Alumni alumni;

    // Many subscriptions can have the same plan
    @ManyToOne
    @JoinColumn(name = "plan_id", nullable = false)
    private SubscriptionPlan plan;

    @Column(nullable = false)
    private LocalDateTime startAt;

    @Column(nullable = false)
    private LocalDateTime endAt;

    @Column(nullable = false)
    private Integer creditsCurrentMonth;

    @Column(nullable = false)
    private LocalDate monthCycleStart;

	public Long getSubId() {
		return subId;
	}

	public void setSubId(Long subId) {
		this.subId = subId;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Alumni getAlumni() {
		return alumni;
	}

	public void setAlumni(Alumni alumni) {
		this.alumni = alumni;
	}

	public SubscriptionPlan getPlan() {
		return plan;
	}

	public void setPlan(SubscriptionPlan plan) {
		this.plan = plan;
	}

	public LocalDateTime getStartAt() {
		return startAt;
	}

	public void setStartAt(LocalDateTime startAt) {
		this.startAt = startAt;
	}

	public LocalDateTime getEndAt() {
		return endAt;
	}

	public void setEndAt(LocalDateTime endAt) {
		this.endAt = endAt;
	}

	public Integer getCreditsCurrentMonth() {
		return creditsCurrentMonth;
	}

	public void setCreditsCurrentMonth(Integer creditsCurrentMonth) {
		this.creditsCurrentMonth = creditsCurrentMonth;
	}

	public LocalDate getMonthCycleStart() {
		return monthCycleStart;
	}

	public void setMonthCycleStart(LocalDate monthCycleStart) {
		this.monthCycleStart = monthCycleStart;
	}
    
    
}



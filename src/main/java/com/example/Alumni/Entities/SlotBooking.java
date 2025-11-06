package com.example.Alumni.Entities;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(
    name = "slot_booking",
    uniqueConstraints = @UniqueConstraint(columnNames = {"slot_id", "student_id"})
)
public class SlotBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    // Many bookings belong to one slot
    @ManyToOne
    @JoinColumn(name = "slot_id", nullable = false)
    private AvailabilitySlot slot;

    // Many bookings belong to one student
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BookingStatus status = BookingStatus.CONFIRMED;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public enum BookingStatus { CONFIRMED, CANCELLED }

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public AvailabilitySlot getSlot() {
		return slot;
	}

	public void setSlot(AvailabilitySlot slot) {
		this.slot = slot;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public BookingStatus getStatus() {
		return status;
	}

	public void setStatus(BookingStatus status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}


}
  


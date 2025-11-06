package com.example.Alumni.Entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "availability_slot",
       uniqueConstraints = @UniqueConstraint(columnNames = {"alumni_id", "start_at"}))
public class AvailabilitySlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long slotId;

    // Each slot belongs to ONE Alumni
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "alumni_id", nullable = false)
    private Alumni alumni;

    @Column(name = "start_at", nullable = false)
    private LocalDateTime startAt; // store UTC

    @Column(name = "end_at", nullable = false)
    private LocalDateTime endAt;   // store UTC

    @Column(nullable = false)
    private Integer capacity = 1;

    @Column(name = "booked_count", nullable = false)
    private Integer bookedCount = 0;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SlotStatus status = SlotStatus.OPEN;

    // One slot can have MANY bookings
    @OneToMany(mappedBy = "slot", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SlotBooking> bookings = new ArrayList<>();

    public enum SlotStatus { OPEN, CLOSED }

	public Long getSlotId() {
		return slotId;
	}

	public void setSlotId(Long slotId) {
		this.slotId = slotId;
	}

	public Alumni getAlumni() {
		return alumni;
	}

	public void setAlumni(Alumni alumni) {
		this.alumni = alumni;
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

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Integer getBookedCount() {
		return bookedCount;
	}

	public void setBookedCount(Integer bookedCount) {
		this.bookedCount = bookedCount;
	}

	public SlotStatus getStatus() {
		return status;
	}

	public void setStatus(SlotStatus status) {
		this.status = status;
	}

	public List<SlotBooking> getBookings() {
		return bookings;
	}

	public void setBookings(List<SlotBooking> bookings) {
		this.bookings = bookings;
	}


}

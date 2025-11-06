package com.example.Alumni.Repo;



import com.example.Alumni.Entities.AvailabilitySlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AvailableSlotRepository extends JpaRepository<AvailabilitySlot, Long> {

    // Get all available slots for a given alumni
    List<AvailabilitySlot> findByAlumni_AlumniId(int alumniId);

    // Get future available slots
    List<AvailabilitySlot> findByAlumni_AlumniIdAndStartAtAfter(Long alumniId, LocalDateTime now);

    // Check if a slot exists at exact start-end
    boolean existsByAlumni_AlumniIdAndStartAtAndEndAt(Long alumniId, LocalDateTime start, LocalDateTime end);

    // Find overlapping slots
    List<AvailabilitySlot> findByAlumni_AlumniIdAndStartAtLessThanEqualAndEndAtGreaterThanEqual(
            Long alumniId, LocalDateTime end, LocalDateTime start
    );
}


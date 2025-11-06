package com.example.Alumni.Service;



import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Alumni.Entities.AvailabilitySlot;
import com.example.Alumni.Repo.AvailableSlotRepository;

@Service
public class AvailabilitySlotService {

    @Autowired
    private AvailableSlotRepository slotRepo;

    // Add slot
    public AvailabilitySlot addSlot(AvailabilitySlot slot) {
        // prevent duplicate exact slot
        boolean exists = slotRepo.existsByAlumni_AlumniIdAndStartAtAndEndAt(
                (long) slot.getAlumni().getAlumniId(),
                slot.getStartAt(),
                slot.getEndAt()
        );

        if (exists) {
            throw new RuntimeException("Slot already exists for this time!");
        }
        return slotRepo.save(slot);
    }

    // Get all slots of an alumni
    public List<AvailabilitySlot> getSlotsForAlumni(int alumniId) {
        return slotRepo.findByAlumni_AlumniId(alumniId);
    }

    // Get future slots
    public List<AvailabilitySlot> getFutureSlots(Long alumniId) {
        return slotRepo.findByAlumni_AlumniIdAndStartAtAfter(alumniId, LocalDateTime.now());
    }

    // Delete slot
    public void removeSlot(Long slotId) {
        slotRepo.deleteById(slotId);
    }
}

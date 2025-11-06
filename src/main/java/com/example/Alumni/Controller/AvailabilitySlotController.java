package com.example.Alumni.Controller;

import com.example.Alumni.Entities.AvailabilitySlot;
import com.example.Alumni.Service.AvailabilitySlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/slots")
public class AvailabilitySlotController {

    @Autowired
    private AvailabilitySlotService slotService;

    // ✅ Add slot
    @PostMapping("/add")
    public ResponseEntity<AvailabilitySlot> addSlot(@RequestBody AvailabilitySlot slot) {
        AvailabilitySlot savedSlot = slotService.addSlot(slot);
        return ResponseEntity.ok(savedSlot);
    }

    // ✅ Get all slots for an alumni
    @GetMapping("/alumni/{alumniId}")
    public ResponseEntity<List<AvailabilitySlot>> getSlotsForAlumni(@PathVariable int alumniId) {
        List<AvailabilitySlot> slots = slotService.getSlotsForAlumni(alumniId);
        return ResponseEntity.ok(slots);
    }

    // ✅ Get future slots for an alumni
    @GetMapping("/alumni/{alumniId}/future")
    public ResponseEntity<List<AvailabilitySlot>> getFutureSlots(@PathVariable Long alumniId) {
        List<AvailabilitySlot> slots = slotService.getFutureSlots(alumniId);
        return ResponseEntity.ok(slots);
    }

    // ✅ Delete slot
    @DeleteMapping("/delete/{slotId}")
    public ResponseEntity<String> removeSlot(@PathVariable Long slotId) {
        slotService.removeSlot(slotId);
        return ResponseEntity.ok("Slot deleted successfully!");
    }
}

package com.example.brussel.be.controllers;

import com.example.brussel.be.model.CalendarEvent;
import com.example.brussel.be.service.CalendarEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class CalendarEventController {

    @Autowired
    private CalendarEventService eventService;

    @GetMapping
    public List<CalendarEvent> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/{appointmentId}/patientId")
    public ResponseEntity<Long> getPatientId(@PathVariable Long appointmentId) {
        Long patientId = eventService.getPatientIdByAppointmentId(appointmentId);
        return ResponseEntity.ok(patientId);
    }

    @GetMapping("/{appointmentId}/start")
    public ResponseEntity<String> getAppointmentStartTime(@PathVariable Long appointmentId) {
        String startTime = eventService.getAppointmentStartTime(appointmentId);

        if (startTime != null) {
            return ResponseEntity.ok(startTime);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{appointmentId}/end")
    public ResponseEntity<String> getAppointmentEndTime(@PathVariable Long appointmentId) {
        String endTime = eventService.getAppointmentEndTime(appointmentId);

        if (endTime != null) {
            return ResponseEntity.ok(endTime);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<CalendarEvent> createEvent(@RequestBody CalendarEvent newEvent) {
        CalendarEvent createdEvent = eventService.createEvent(newEvent);

        if (createdEvent != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdEvent);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    // Другие методы по мере необходимости
}


package com.example.brussel.be.service;

import com.example.brussel.be.model.CalendarEvent;
import com.example.brussel.be.repo.CalendarEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarEventService {

    @Autowired
    private CalendarEventRepository eventRepository;

    public List<CalendarEvent> getAllEvents() {
        return eventRepository.findAll();
    }
    public Long getPatientIdByAppointmentId(Long appointmentId) {
        return eventRepository.findPatientIdById(appointmentId);
    }

    public String getAppointmentStartTime(Long appointmentId) {
        CalendarEvent event = eventRepository.findById(appointmentId).orElse(null);

        if (event != null) {

            return event.getStart().toString();
        } else {
            return null;
        }
    }

    public String getAppointmentEndTime(Long appointmentId) {
        CalendarEvent event = eventRepository.findById(appointmentId).orElse(null);

        if (event != null) {

            return event.getEnd().toString();
        } else {
            return null;
        }
    }

    public CalendarEvent createEvent(CalendarEvent newEvent) {

        return eventRepository.save(newEvent);

    }
}

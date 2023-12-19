package com.example.brussel.be.repo;

import com.example.brussel.be.model.CalendarEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarEventRepository extends JpaRepository<CalendarEvent, Long> {

    @Query("SELECT ce.patient_id FROM CalendarEvent ce WHERE ce.id = :appointmentId")
    Long findPatientIdById(@Param("appointmentId") Long appointmentId);

    // Дополнительные методы для запросов к базе данных, если необходимо
}
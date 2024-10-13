package com.bondith.appointmentservice.service;

import com.bondith.appointmentservice.doa.AppointmentDOA;
import com.bondith.appointmentservice.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * This class represents the AppointmentService, which is responsible for handling appointment-related operations.
 * It provides methods to retrieve appointments based on status, retrieve all appointments, and save new appointments.
 * It also provides a method to check if a time slot is available for a given technician, requested start time, and service.
 */
@Service
public class AppointmentService {
    private AppointmentDOA appointmentDOA;

    public List<Appointment> getAppointmentsByStatus(String status) {
        return appointmentDOA.findByStatus(status);
    }

    public ResponseEntity<List<Appointment>> getAllAppointments() {
        return new ResponseEntity<>(appointmentDOA.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<String> save(Appointment appointment) {

        // Check if slot available
        if (!isSlotAvailable(appointment.getTechnician().getId(), appointment.getAppointment_time().toLocalDateTime())) {
            throw new RuntimeException("Appointment already exists");
        }
        // Create appointment
        appointmentDOA.save(appointment);

        // Update Availability table

        return new ResponseEntity<>("Appointment saved", HttpStatus.CREATED);
    }


    public boolean isSlotAvailable(int technicianId, LocalDateTime requestedStartTime) {
        int conflictCount = appointmentDOA.countConflictingAppointments(
                technicianId, requestedStartTime);

        return conflictCount == 0;
    }

    @Autowired
    public void setAppointmentDOA(AppointmentDOA appointmentDOA) {
        this.appointmentDOA = appointmentDOA;
    }
}

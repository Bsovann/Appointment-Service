package com.bondith.appointmentservice.service;

import com.bondith.appointmentservice.doa.AppointmentDOA;
import com.bondith.appointmentservice.model.Appointment;
import com.bondith.appointmentservice.model.NailService;
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

    private ServiceDOA serviceDOA;

    public List<Appointment> getAppointmentsByStatus(String status) {
        return appointmentDOA.findByStatus(status);
    }

    public ResponseEntity<List<Appointment>> getAllAppointments() {
        return new ResponseEntity<>(appointmentDOA.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<String> save(Appointment appointment) {
        // Check if slot available
        if (!isSlotAvailable(appointment.getTechnician().getId(), appointment.getAppointment_time().toLocalDateTime(), appointment.getService().getId())) {
            throw new RuntimeException("Appointment already exists");
        }
        appointmentDOA.save(appointment);
        return new ResponseEntity<>("Appointment saved", HttpStatus.OK);
    }


    public boolean isSlotAvailable(int technicianId, LocalDateTime requestedStartTime, int serviceId) {
        NailService service = serviceDOA.findById(serviceId).orElseThrow(() -> new RuntimeException("Service not found"));

        LocalDateTime requestedEndTime = requestedStartTime.plusMinutes(service.getDuration());

        int conflictCount = appointmentDOA.countConflictingAppointments(
                technicianId, requestedStartTime, requestedEndTime);

        return conflictCount == 0;
    }

    @Autowired
    public void setAppointmentDOA(AppointmentDOA appointmentDOA) {
        this.appointmentDOA = appointmentDOA;
    }

    @Autowired
    public void setServiceDOA(ServiceDOA serviceDOA) {
        this.serviceDOA = serviceDOA;
    }
}

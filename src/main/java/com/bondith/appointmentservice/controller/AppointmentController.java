package com.bondith.appointmentservice.controller;


import com.bondith.appointmentservice.model.Appointment;
import com.bondith.appointmentservice.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private AppointmentService appointmentService;

    // Get Appointment lists
    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    // Create an appointment
    @PostMapping
    public ResponseEntity<String> addAppointment(@RequestBody Appointment appointment) {
        return appointmentService.save(appointment);
    }

    // Patch Appointment when service is completed.
    @Autowired
    public void setAppointmentService(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }
}

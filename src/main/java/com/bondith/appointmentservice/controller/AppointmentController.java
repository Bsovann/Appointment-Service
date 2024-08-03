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

    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @PostMapping
    public ResponseEntity<String> addAppointment(@RequestBody Appointment appointment) {
        return appointmentService.save(appointment);
    }

    @Autowired
    public void setAppointmentService(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }
}

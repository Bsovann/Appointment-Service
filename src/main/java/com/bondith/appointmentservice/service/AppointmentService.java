package com.bondith.appointmentservice.service;

import com.bondith.appointmentservice.doa.AppointmentDOA;
import com.bondith.appointmentservice.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    private AppointmentDOA appointmentDOA;

    public List<Appointment> getAppointmentsByStatus(String status) {
        return appointmentDOA.findByStatus(status);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentDOA.findAll();
    }

    @Autowired
    public void setAppointmentDOA(AppointmentDOA appointmentDOA) {
        this.appointmentDOA = appointmentDOA;
    }
}

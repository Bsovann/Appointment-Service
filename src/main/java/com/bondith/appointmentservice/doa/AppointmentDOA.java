package com.bondith.appointmentservice.doa;

import com.bondith.appointmentservice.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentDOA extends JpaRepository<AppointmentDOA, Integer> {
    List<Appointment> findByStatus(String status);
}

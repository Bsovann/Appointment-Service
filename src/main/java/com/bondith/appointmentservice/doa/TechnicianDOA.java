package com.bondith.appointmentservice.doa;

import com.bondith.appointmentservice.model.Technician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicianDOA extends JpaRepository<Technician, Integer> {
}

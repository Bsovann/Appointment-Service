package com.bondith.appointmentservice.doa;
import com.bondith.appointmentservice.model.Availability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvalabilityDOA extends JpaRepository<Availability, Integer> {
}

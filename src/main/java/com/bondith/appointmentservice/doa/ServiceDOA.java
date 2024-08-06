package com.bondith.appointmentservice.doa;

import com.bondith.appointmentservice.model.NailService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceDOA extends JpaRepository<NailService, Integer> {
}

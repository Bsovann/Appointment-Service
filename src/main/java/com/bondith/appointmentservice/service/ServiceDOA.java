package com.bondith.appointmentservice.service;

import com.bondith.appointmentservice.model.NailService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceDOA extends JpaRepository<NailService, Integer> {
}

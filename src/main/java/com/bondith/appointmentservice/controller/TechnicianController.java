package com.bondith.appointmentservice.controller;

import com.bondith.appointmentservice.doa.TechnicianDOA;
import com.bondith.appointmentservice.model.Technician;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/technicians")
public class TechnicianController {

    private TechnicianDOA technicianDOA;

    @PostMapping
    public ResponseEntity<Technician> addTechnician(@RequestBody Technician technician) {
        Technician result = technicianDOA.save(technician);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @Autowired
    public void setTechnicianDOA(TechnicianDOA technicianDOA) {
        this.technicianDOA = technicianDOA;
    }
}

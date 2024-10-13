package com.bondith.appointmentservice.controller;

import com.bondith.appointmentservice.doa.ServiceDOA;
import com.bondith.appointmentservice.model.NailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
public class ServiceController {

    private ServiceDOA serviceDOA;

    @PostMapping
    public ResponseEntity<String> addService(@RequestBody NailService service) {
        serviceDOA.save(service);
        return ResponseEntity.ok("Service added");
    }

    @GetMapping
    public ResponseEntity<List<NailService>> getServices() {
        return ResponseEntity.ok(serviceDOA.findAll());
    }

    @GetMapping("/test")
    public String testing (){
        return "Testing Testing!";
    }

    @Autowired
    public void setServiceDOA(ServiceDOA serviceDOA) {
        this.serviceDOA = serviceDOA;
    }
}

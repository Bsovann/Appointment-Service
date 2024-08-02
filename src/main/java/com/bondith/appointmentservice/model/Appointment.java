package com.bondith.appointmentservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Timestamp appointment_time;
    private String customer_name;
    private String customer_phone;
    @Column(name = "status", nullable = false, columnDefinition = "varchar(50) default 'Scheduled'")
    private String status;
    @ManyToOne
    private Service service;
    @ManyToOne
    private Technician technician;
}

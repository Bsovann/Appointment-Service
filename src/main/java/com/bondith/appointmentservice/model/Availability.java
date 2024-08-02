package com.bondith.appointmentservice.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.sql.Timestamp;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Availability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Timestamp start_time;
    private Timestamp end_time;

    @Column(name = "is_available", nullable = false, columnDefinition = "boolean default true")
    private boolean is_available;

    @ManyToOne
    Technician technician;
}

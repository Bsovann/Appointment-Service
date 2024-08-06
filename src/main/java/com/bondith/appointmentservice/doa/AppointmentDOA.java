package com.bondith.appointmentservice.doa;

import com.bondith.appointmentservice.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentDOA extends JpaRepository<Appointment, Integer> {
    List<Appointment> findByStatus(String status);

    @Query("""
            SELECT COUNT(a) FROM Appointment a \
            WHERE a.technician.id = :technicianId \
            AND a.appointment_time = :requestedStartTime \
            """)
    int countConflictingAppointments(@Param("technicianId") int technicianId,
                                      @Param("requestedStartTime") LocalDateTime requestedStartTime);

}

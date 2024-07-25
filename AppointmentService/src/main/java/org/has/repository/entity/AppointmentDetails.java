package org.has.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.has.utility.enums.AppointmentDate;
import org.has.utility.enums.AppointmentHours;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_appointment_details")
public class AppointmentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long doctorId;
    private AppointmentDate appointmentDate;
    private AppointmentHours appointmentHours;
    private boolean isBooked;
}

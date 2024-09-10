package org.has.rabbitmq.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.has.utility.enums.AppointmentDate;
import org.has.utility.enums.AppointmentHours;
import org.has.utility.enums.EDepartment;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentModel implements Serializable {
    Long patienceId;
    EDepartment department;
    Long doctorId;
    AppointmentDate appointmentDate;
    AppointmentHours appointmentHours;
}

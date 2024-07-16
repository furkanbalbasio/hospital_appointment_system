package org.has.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.has.utility.enums.EDepartment;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentSaveRequestDto {
    Long patienceId;
    Long doctorId;
    LocalDateTime appointmentDate;
    boolean state;
    EDepartment department;
}

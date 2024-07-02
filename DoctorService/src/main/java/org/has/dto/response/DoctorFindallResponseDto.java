package org.has.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.has.utility.enums.EDepartment;

import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DoctorFindallResponseDto {
    Long doctorId;
    UUID uuid;
    String name;
    String surname;
    EDepartment department;
    String phone;
    String email;
}

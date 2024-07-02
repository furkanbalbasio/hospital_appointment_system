package org.has.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.has.utility.enums.EDepartment;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DoctorFindAllResponseDto {
    Long doctorId;
    String name;
    String surname;
    EDepartment department;
    String phone;
    String email;
}

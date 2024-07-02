package org.has.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.has.utility.enums.EDepartment;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorUpdateRequestDto {
    EDepartment department;
    String phone;
    String email;
}

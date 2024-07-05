package org.has.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.has.utility.enums.EDepartment;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoctorSaveRequestDto {
     String registrationNumber;
     String name;
     String surname;
     EDepartment department;
     String phone;
     String email;
}

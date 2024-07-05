package org.has.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.has.utility.enums.EDepartment;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoctorSaveRequestDto {
//     UUID uuid;
     Long id;
     String name;
     String surname;
     EDepartment department;
     String phone;
     String email;
}

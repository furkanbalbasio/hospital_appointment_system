package org.has.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatienceSaveRequestDto {
    String tcNumber;
    Long patienceId;
    String name;
    String surname;
    String phone;
    String email;
    String password;

}

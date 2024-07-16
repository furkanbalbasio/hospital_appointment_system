package org.has.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterRequestDto {
    String tcNumber;
    String password;
    String name;
    String surname;
    String phone;
    String email;

}

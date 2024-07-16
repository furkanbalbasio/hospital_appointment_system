package org.has.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SecretarySaveRequestDto {
     String registrationNumber;
     String name;
     String surname;
     String phone;
     String email;
     String password;
}

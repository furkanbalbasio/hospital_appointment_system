package org.has.dto.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SecretaryUpdateRequestDto {
     String name;
     String surname;
     String phone;
     String email;
     String password;
}

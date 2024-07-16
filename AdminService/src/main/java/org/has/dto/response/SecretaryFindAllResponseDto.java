package org.has.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@RequiredArgsConstructor
public class SecretaryFindAllResponseDto {
    private String registrationNumber;
    private String name;
    private String surname;
    private String phone;
    private String email;
    private String password;
}

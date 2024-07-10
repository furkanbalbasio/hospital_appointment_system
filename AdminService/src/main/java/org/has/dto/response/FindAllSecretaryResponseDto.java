package org.has.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class FindAllSecretaryResponseDto {
    int statusCode;
    String message;
    List<SecretaryFindAllResponseDto> data;

}

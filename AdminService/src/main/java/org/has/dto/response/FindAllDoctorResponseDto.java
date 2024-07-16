package org.has.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FindAllDoctorResponseDto {
    int statusCode;
    String message;
    List<DoctorFindAllResponseDto> data;

}

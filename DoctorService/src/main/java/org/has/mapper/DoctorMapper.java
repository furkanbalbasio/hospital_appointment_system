package org.has.mapper;

import org.has.dto.request.DoctorSaveRequestDto;
import org.has.dto.response.DoctorFindallResponseDto;
import org.has.repository.entity.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DoctorMapper {
    DoctorMapper INSTANCE= Mappers.getMapper(DoctorMapper.class);

    Doctor fromDto(final DoctorSaveRequestDto dto);
    DoctorFindallResponseDto toDoctor(final Doctor doctor);


}

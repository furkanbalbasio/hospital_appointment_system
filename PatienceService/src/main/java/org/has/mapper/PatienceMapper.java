package org.has.mapper;

import org.has.dto.PatienceSaveRequestDto;
import org.has.repository.entity.Patience;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PatienceMapper {
    PatienceMapper INSTANCE = Mappers.getMapper(PatienceMapper.class);

    Patience fromDto(final PatienceSaveRequestDto dto);

}

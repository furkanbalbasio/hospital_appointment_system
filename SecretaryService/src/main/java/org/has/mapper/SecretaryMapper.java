package org.has.mapper;

import org.has.dto.request.SecretarySaveRequestDto;
import org.has.dto.request.SecretaryUpdateRequestDto;
import org.has.repository.entity.Secretary;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SecretaryMapper {
    SecretaryMapper INSTANCE= Mappers.getMapper(SecretaryMapper.class);
    Secretary fromDto(final SecretarySaveRequestDto dto);
    Secretary fromDto(final SecretaryUpdateRequestDto dto);


}

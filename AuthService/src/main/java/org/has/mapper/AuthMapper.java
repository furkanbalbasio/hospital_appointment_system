package org.has.mapper;


import org.has.dto.request.PatienceSaveRequestDto;
import org.has.dto.request.RegisterRequestDto;
import org.has.repository.entity.Auth;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuthMapper {
    AuthMapper INSTANCE = Mappers.getMapper(AuthMapper.class);

    Auth fromDto(final RegisterRequestDto dto);

    //List<Auth> authListFromDto(final List<RegisterRequestDto> dtos);
    @Mapping(source = "id",target = "patienceId")
    PatienceSaveRequestDto fromAuth(final Auth auth);
}

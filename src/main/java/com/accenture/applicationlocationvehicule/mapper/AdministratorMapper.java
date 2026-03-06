package com.accenture.applicationlocationvehicule.mapper;

import com.accenture.applicationlocationvehicule.model.Administrator;
import com.accenture.applicationlocationvehicule.service.dto.AdministratorRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.AdministratorResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AdministratorMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", constant = "ADMIN")
    Administrator toAdministrator(AdministratorRequestDto dto);
    AdministratorResponseDto toAdministratorResponseDto(Administrator administrator);
}

package com.accenture.applicationlocationvehicule.mapper;

import com.accenture.applicationlocationvehicule.model.Administrator;
import com.accenture.applicationlocationvehicule.service.dto.AdministratorRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.AdministratorResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AdministratorMapper {
    @Mapping(target = "id", ignore = true)
    Administrator toAdministrator(AdministratorRequestDto dto);
    AdministratorResponseDto toAdministratorResponseDto(Administrator administrator);
}

package com.accenture.applicationlocationvehicule.service;


import com.accenture.applicationlocationvehicule.exception.AdministratorException;
import com.accenture.applicationlocationvehicule.exception.ClientException;
import com.accenture.applicationlocationvehicule.service.dto.AdministratorRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.AdministratorResponseDto;
import com.accenture.applicationlocationvehicule.service.dto.ClientRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.ClientResponseDto;

import java.util.List;

public interface AdministratorService {
    AdministratorResponseDto addAdministrator(AdministratorRequestDto dto) throws AdministratorException;

    List<AdministratorResponseDto> findAllAdministrators();

    AdministratorResponseDto findAdministratorById(int id);

    void deleteAdministrator(int id);

    AdministratorResponseDto updateAdministratorPartially(int idAdministrator, AdministratorRequestDto requestDto);

}

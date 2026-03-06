package com.accenture.applicationlocationvehicule.service;


import com.accenture.applicationlocationvehicule.exception.ClientException;
import com.accenture.applicationlocationvehicule.service.dto.ClientRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.ClientResponseDto;

import java.util.List;

public interface ClientService{
    ClientResponseDto addClient(ClientRequestDto dto) throws ClientException;

    List<ClientResponseDto> findAllClients();

    ClientResponseDto findClientById(int id);

    void deleteClient(int id);

    ClientResponseDto updateClientPartially(int id, ClientRequestDto requestDto);

}

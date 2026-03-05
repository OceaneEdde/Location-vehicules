package com.accenture.applicationlocationvehicule.controller.impl;


import com.accenture.applicationlocationvehicule.controller.ClientApi;
import com.accenture.applicationlocationvehicule.exception.ClientException;
import com.accenture.applicationlocationvehicule.service.ClientService;
import com.accenture.applicationlocationvehicule.service.dto.ClientRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.ClientResponseDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/clients")
public class ClientController implements ClientApi {
    private final ClientService clientService;


    @Override
    public ResponseEntity<List<ClientResponseDto>> getClients() {
        return ResponseEntity.ok(clientService.findAllClients());
    }

    @Override
    public ResponseEntity<ClientResponseDto> getClientById(int idClient) {
        return ResponseEntity.ok(clientService.findClientById(idClient));
    }

    @Override
    public ResponseEntity<Void> addClient(@Valid ClientRequestDto requestDto) throws ClientException {
        ClientResponseDto responseDto = clientService.addClient(requestDto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(responseDto.id())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @Override
    public ResponseEntity<Void> deleteClient(int idClient) {
        clientService.deleteClient(idClient);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<ClientResponseDto> patchClient(int idClient, ClientRequestDto requestDto) {
        ClientResponseDto responseDto = clientService.updateClientPartially(idClient, requestDto);
        return ResponseEntity.ok(responseDto);
    }

}

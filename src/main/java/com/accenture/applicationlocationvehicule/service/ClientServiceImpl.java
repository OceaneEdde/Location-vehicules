package com.accenture.applicationlocationvehicule.service;

import com.accenture.applicationlocationvehicule.exception.ClientException;
import com.accenture.applicationlocationvehicule.mapper.ClientMapper;
import com.accenture.applicationlocationvehicule.model.Client;
import com.accenture.applicationlocationvehicule.repository.ClientDao;
import com.accenture.applicationlocationvehicule.service.dto.ClientRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.ClientResponseDto;
import com.accenture.applicationlocationvehicule.utils.Messages;
import com.accenture.applicationlocationvehicule.utils.Validations;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class ClientServiceImpl implements ClientService {
    private final ClientDao clientDao;
    private final ClientMapper clientMapper;
    private final MessageSourceAccessor messages;
    private final Validations validations;

    @Override
    public ClientResponseDto addClient(ClientRequestDto dto) throws ClientException {
        auditor(dto);
        Client saved = clientDao.save(clientMapper.toClient(dto));
        return clientMapper.toClientResponseDto(saved);
    }


    @Override
    public List<ClientResponseDto> findAllClients() {
        return clientDao.findAll().stream()
                .map(clientMapper::toClientResponseDto)
                .toList();
    }

    @Override
    public ClientResponseDto findClientById(int id) {
        Client client = clientDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(messages.getMessage(Messages.MESSAGES_ERROR_CLIENT_NOTFOUND)));
        return clientMapper.toClientResponseDto(client);
    }

    @Override
    public void deleteClient(int id) {
        Client client = clientDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(messages.getMessage(Messages.MESSAGES_ERROR_CLIENT_NOTFOUND)));
        clientDao.delete(client);
    }

    @Override
    public ClientResponseDto updateClientPartially(int idClient, ClientRequestDto requestDto) {

        auditor(requestDto);

        Client client = clientDao.findById(idClient)
                .orElseThrow(() -> new EntityNotFoundException(
                        messages.getMessage(Messages.MESSAGES_ERROR_CLIENT_NOTFOUND)));

        applyPartiallyUpdate(client, requestDto);

        clientDao.save(client);

        return clientMapper.toClientResponseDto(client);
    }


    //Sous-méthode
    private void applyPartiallyUpdate(Client client, ClientRequestDto dto) {
        if (dto == null) throw new ClientException(messages.getMessage(Messages.MESSAGES_ERROR_CLIENT_NOTFOUND));
        if (dto.firstname() == null || dto.firstname().isBlank()) throw new ClientException(messages.getMessage(Messages.MESSAGES_ERROR_CLIENT_FIRSTNAME));
        if (!validations.isValidName(dto.firstname())) throw new ClientException(messages.getMessage(Messages.MESSAGES_ERROR_CLIENT_FIRSTNAME_INVALID));
        if (dto.lastname() == null || dto.lastname().isBlank()) throw new ClientException(messages.getMessage(Messages.MESSAGES_ERROR_CLIENT_LASTNAME));
        if (!validations.isValidName(dto.lastname())) throw new ClientException(messages.getMessage(Messages.MESSAGES_ERROR_CLIENT_LASTNAME_INVALID));
        if (dto.email() == null || dto.email().isBlank()) throw new ClientException(messages.getMessage(Messages.MESSAGES_ERROR_CLIENT_EMAIL));
        if (!validations.isValidEmail(dto.email())) throw new ClientException(messages.getMessage(Messages.MESSAGES_ERROR_CLIENT_EMAIL_INVALID));
        if (dto.password() == null || dto.password().isBlank()) throw new ClientException(messages.getMessage(Messages.MESSAGES_ERROR_CLIENT_PASSWORD));
        if (!validations.isValidPassword(dto.password())) throw new ClientException(messages.getMessage(Messages.MESSAGES_ERROR_CLIENT_PASSWORD_INVALID));
        if (dto.address() == null) throw new ClientException(messages.getMessage(Messages.MESSAGES_ERROR_CLIENT_ADDRESS));
        if (dto.birthdate() == null) throw new ClientException(messages.getMessage(Messages.MESSAGES_ERROR_CLIENT_BIRTHDATE));
        if (dto.registrationdate() == null) throw new ClientException(messages.getMessage(Messages.MESSAGES_ERROR_CLIENT_REGISTRATIONDATE));
        if (dto.licensesListeList() == null || dto.licensesListeList().isEmpty()) throw new ClientException(messages.getMessage(Messages.MESSAGES_ERROR_CLIENT_LICENSES));
    }


    private void auditor(ClientRequestDto dto) {

        if (dto == null) throw new ClientException(messages.getMessage(Messages.MESSAGES_ERROR_CLIENT_NOTFOUND));
        if (dto.firstname() != null && !validations.isValidName(dto.firstname())) throw new ClientException(messages.getMessage(Messages.MESSAGES_ERROR_CLIENT_FIRSTNAME_INVALID));
        if (dto.lastname() != null && !validations.isValidName(dto.lastname())) throw new ClientException(messages.getMessage(Messages.MESSAGES_ERROR_CLIENT_LASTNAME_INVALID));
        if (dto.email() != null && !validations.isValidEmail(dto.email())) throw new ClientException(messages.getMessage(Messages.MESSAGES_ERROR_CLIENT_EMAIL_INVALID));
        if (dto.password() != null && !validations.isValidPassword(dto.password())) throw new ClientException(messages.getMessage(Messages.MESSAGES_ERROR_CLIENT_PASSWORD_INVALID));
        if (dto.licensesListeList() != null && dto.licensesListeList().isEmpty()) {throw new ClientException(messages.getMessage(Messages.MESSAGES_ERROR_CLIENT_LICENSES));
        }
    }
}


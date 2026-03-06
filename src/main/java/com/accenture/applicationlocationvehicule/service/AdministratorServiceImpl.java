package com.accenture.applicationlocationvehicule.service;

import com.accenture.applicationlocationvehicule.exception.AdministratorException;
import com.accenture.applicationlocationvehicule.mapper.AdministratorMapper;
import com.accenture.applicationlocationvehicule.model.Administrator;
import com.accenture.applicationlocationvehicule.repository.AdministratorDao;
import com.accenture.applicationlocationvehicule.service.dto.AdministratorRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.AdministratorResponseDto;
import com.accenture.applicationlocationvehicule.utils.Messages;
import com.accenture.applicationlocationvehicule.utils.Validations;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class AdministratorServiceImpl implements AdministratorService {
    private final AdministratorDao administratorDao;
    private final AdministratorMapper administratorMapper;
    private final MessageSourceAccessor messages;
    private final Validations validations;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AdministratorResponseDto addAdministrator(AdministratorRequestDto dto) throws AdministratorException {
        auditor(dto);
        Administrator administrator = administratorMapper.toAdministrator(dto);
        administrator.setPassword(passwordEncoder.encode(dto.password()));
        Administrator saved = administratorDao.save(administrator);
        return administratorMapper.toAdministratorResponseDto(saved);
    }

    @Override
    public List<AdministratorResponseDto> findAllAdministrators() {
        return administratorDao.findAll().stream()
                .map(administratorMapper::toAdministratorResponseDto)
                .toList();
    }

    @Override
    public AdministratorResponseDto findAdministratorById(int id) {
        Administrator administrator = administratorDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(messages.getMessage(Messages.MESSAGES_ERROR_ADMINISTRATOR_NOTFOUND)));
        return administratorMapper.toAdministratorResponseDto(administrator);
    }

    @Override
    public void deleteAdministrator(int id) {
        Administrator administrator = administratorDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(messages.getMessage(Messages.MESSAGES_ERROR_ADMINISTRATOR_NOTFOUND)));
        administratorDao.delete(administrator);
    }

    @Override
    public AdministratorResponseDto updateAdministratorPartially(int id, AdministratorRequestDto requestDto) {

        auditor(requestDto);

        Administrator administrator = administratorDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        messages.getMessage(Messages.MESSAGES_ERROR_ADMINISTRATOR_NOTFOUND)));

        applyPartiallyUpdate(administrator, requestDto);

        administratorDao.save(administrator);

        return administratorMapper.toAdministratorResponseDto(administrator);
    }


    //Sous-méthode
    private void applyPartiallyUpdate(Administrator administrator, AdministratorRequestDto dto) {
        if (dto.firstname() != null && !dto.firstname().isBlank()) {administrator.setFirstname(dto.firstname());}
        if (dto.lastname() != null && !dto.lastname().isBlank()) {administrator.setLastname(dto.lastname());}
        if (dto.email() != null && !dto.email().isBlank()) {administrator.setEmail(dto.email());}
        if (dto.function() != null) {administrator.setFunction(dto.function());}
    }

    private void auditor(AdministratorRequestDto dto) {

        if (dto == null) throw new AdministratorException(messages.getMessage(Messages.MESSAGES_ERROR_ADMINISTRATOR_NOTFOUND));
        if (dto.firstname() == null || dto.firstname().isBlank()) throw new AdministratorException(messages.getMessage(Messages.MESSAGES_ERROR_ADMINISTRATOR_FIRSTNAME));
        if (!validations.isValidName(dto.firstname())) throw new AdministratorException(messages.getMessage(Messages.MESSAGES_ERROR_ADMINISTRATOR_FIRSTNAME_INVALID));
        if (dto.lastname() == null || dto.lastname().isBlank()) throw new AdministratorException(messages.getMessage(Messages.MESSAGES_ERROR_ADMINISTRATOR_LASTNAME));
        if (!validations.isValidName(dto.lastname())) throw new AdministratorException(messages.getMessage(Messages.MESSAGES_ERROR_ADMINISTRATOR_LASTNAME_INVALID));
        if (dto.email() == null || dto.email().isBlank()) throw new AdministratorException(messages.getMessage(Messages.MESSAGES_ERROR_ADMINISTRATOR_EMAIL));
        if (!validations.isValidEmail(dto.email())) throw new AdministratorException(messages.getMessage(Messages.MESSAGES_ERROR_ADMINISTRATOR_EMAIL_INVALID));
        if (dto.password() == null || dto.password().isBlank()) throw new AdministratorException(messages.getMessage(Messages.MESSAGES_ERROR_ADMINISTRATOR_PASSWORD));
        }




}


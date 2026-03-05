package com.accenture.applicationlocationvehicule.service;

import com.accenture.applicationlocationvehicule.exception.MotorCycleException;
import com.accenture.applicationlocationvehicule.mapper.MotorCycleMapper;
import com.accenture.applicationlocationvehicule.model.MotorCycle;
import com.accenture.applicationlocationvehicule.repository.MotorCycleDao;
import com.accenture.applicationlocationvehicule.service.dto.MotorCycleRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.MotorCycleResponseDto;
import com.accenture.applicationlocationvehicule.utils.Messages;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class MotorCycleServiceImpl implements MotorCycleService {

    private final MotorCycleDao motorCycleDao;
    private final MotorCycleMapper motorCycleMapper;
    private final MessageSourceAccessor messages;

    @Override
    public MotorCycleResponseDto addMotorCycle(MotorCycleRequestDto dto) {
        auditor(dto);
        MotorCycle saved = motorCycleDao.save(motorCycleMapper.toMotorCycle(dto));
        return motorCycleMapper.toMotorCycleResponseDto(saved);
    }

    @Override
    public List<MotorCycleResponseDto> findAllMotorCycles() {
        return motorCycleDao.findAll().stream()
                .map(motorCycleMapper::toMotorCycleResponseDto)
                .toList();
    }

    @Override
    public MotorCycleResponseDto findMotorCycleById(int id) {
        MotorCycle motorCycle = motorCycleDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(messages.getMessage(Messages.MESSAGES_ERROR_MOTORCYCLE_NOTFOUND)));

        return motorCycleMapper.toMotorCycleResponseDto(motorCycle);
    }

    @Override
    public void deleteMotorCycle(int id) {
        MotorCycle motorCycle = motorCycleDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(messages.getMessage(Messages.MESSAGES_ERROR_MOTORCYCLE_NOTFOUND)));

        motorCycleDao.delete(motorCycle);
    }


    @Override
    public MotorCycleResponseDto updateMotorCyclePartially(int id, MotorCycleRequestDto dto) {
        MotorCycle motorCycle = motorCycleDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(messages.getMessage(Messages.MESSAGES_ERROR_MOTORCYCLE_NOTFOUND)));

        applyPartiallyUpdate(motorCycle, dto);

        motorCycleDao.save(motorCycle);

        return motorCycleMapper.toMotorCycleResponseDto(motorCycle);
    }

        //  Sous-méthodes

    private void applyPartiallyUpdate(MotorCycle motorCycle, MotorCycleRequestDto dto) {
        if (dto.brand() != null && !dto.brand().isBlank()) motorCycle.setBrand(dto.brand());
        if (dto.model() != null && !dto.model().isBlank()) motorCycle.setModel(dto.model());
        if (dto.color() != null && !dto.color().isBlank()) motorCycle.setColor(dto.color());
        if (dto.fuelType() != null) motorCycle.setFuelType(dto.fuelType());
        if (dto.dailyRate() != null && dto.dailyRate() > 0) motorCycle.setDailyRate(dto.dailyRate());
        if (dto.mileage() != null && dto.mileage() >= 0) motorCycle.setMileage(dto.mileage());
        if (dto.active() != null) motorCycle.setActive(dto.active());
        if (dto.parkRemove() != null) motorCycle.setParkRemove(dto.parkRemove());
        if (dto.licenses() != null ) motorCycle.setLicenses(dto.licenses());
        if (dto.cylindree() != null) motorCycle.setCylindree(dto.cylindree());
        if (dto.nbCylindree() != null && dto.nbCylindree() > 0) motorCycle.setNbCylindree(dto.nbCylindree());
        if (dto.weight() != null && dto.weight() > 0) motorCycle.setWeight(dto.weight());
        if (dto.powerKw() != null && dto.powerKw() > 0) motorCycle.setPowerKw(dto.powerKw());
        if (dto.saddleHeight() != null && dto.saddleHeight() > 0) motorCycle.setSaddleHeight(dto.saddleHeight());
        if (dto.transmission() != null) motorCycle.setTransmission(dto.transmission());
        if (dto.types() != null) motorCycle.setTypes(dto.types());
    }

    private void auditor(MotorCycleRequestDto dto) {
        if (dto == null) throw new MotorCycleException(messages.getMessage(Messages.MESSAGES_ERROR_MOTORCYCLE_NOTFOUND));
        if (dto.brand() == null || dto.brand().isBlank()) throw new MotorCycleException(messages.getMessage(Messages.MESSAGES_ERROR_MOTORCYCLE_BRAND));
        if (dto.model() == null || dto.model().isBlank()) throw new MotorCycleException(messages.getMessage(Messages.MESSAGES_ERROR_MOTORCYCLE_MODEL));
        if (dto.color() == null || dto.color().isBlank()) throw new MotorCycleException(messages.getMessage(Messages.MESSAGES_ERROR_MOTORCYCLE_COLOR));
        if (dto.fuelType() == null) throw new MotorCycleException(messages.getMessage(Messages.MESSAGES_ERROR_MOTORCYCLE_FUELTYPE));
        if (dto.dailyRate() == null) throw new MotorCycleException(messages.getMessage(Messages.MESSAGES_ERROR_MOTORCYCLE_DAILYRATE_NULL));
        if (dto.dailyRate() <= 0) throw new MotorCycleException(messages.getMessage(Messages.MESSAGES_ERROR_MOTORCYCLE_DAILYRATE_MIN));
        if (dto.mileage() == null) throw new MotorCycleException(messages.getMessage(Messages.MESSAGES_ERROR_MOTORCYCLE_MILEAGE_NULL));
        if (dto.mileage() < 0) throw new MotorCycleException(messages.getMessage(Messages.MESSAGES_ERROR_MOTORCYCLE_MILEAGE_MIN));
        if (dto.active() == null) throw new MotorCycleException(messages.getMessage(Messages.MESSAGES_ERROR_MOTORCYCLE_ACTIVE));
        if (dto.parkRemove() == null) throw new MotorCycleException(messages.getMessage(Messages.MESSAGES_ERROR_MOTORCYCLE_PARKREMOVE));
        if (dto.licenses() == null) throw new MotorCycleException(messages.getMessage(Messages.MESSAGES_ERROR_MOTORCYCLE_LICENSES));
        if (dto.nbCylindree() == null || dto.nbCylindree() <= 0) throw new MotorCycleException(messages.getMessage(Messages.MESSAGES_ERROR_MOTORCYCLE_NBCYLINDREE));
        if (dto.cylindree() == null || dto.cylindree() <= 0) throw new MotorCycleException(messages.getMessage(Messages.MESSAGES_ERROR_MOTORCYCLE_CYLINDREE));
        if (dto.weight() == null || dto.weight() <= 0) throw new MotorCycleException(messages.getMessage(Messages.MESSAGES_ERROR_MOTORCYCLE_WEIGHT));
        if (dto.powerKw() == null || dto.powerKw() <= 0) throw new MotorCycleException(messages.getMessage(Messages.MESSAGES_ERROR_MOTORCYCLE_POWERKW));
        if (dto.saddleHeight() == null || dto.saddleHeight() <= 0) throw new MotorCycleException(messages.getMessage(Messages.MESSAGES_ERROR_MOTORCYCLE_SADDLEHEIGHT));
        if (dto.transmission() == null) throw new MotorCycleException(messages.getMessage(Messages.MESSAGES_ERROR_MOTORCYCLE_TRANSMISSION));
        if (dto.types() == null) throw new MotorCycleException(messages.getMessage(Messages.MESSAGES_ERROR_MOTORCYCLE_TYPES));

    }
}

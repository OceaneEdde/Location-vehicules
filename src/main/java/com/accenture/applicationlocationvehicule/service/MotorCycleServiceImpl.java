package com.accenture.applicationlocationvehicule.service;

import com.accenture.applicationlocationvehicule.exception.MotorCycleException;
import com.accenture.applicationlocationvehicule.mapper.MotorCycleMapper;
import com.accenture.applicationlocationvehicule.model.MotorCycle;
import com.accenture.applicationlocationvehicule.repository.MotorCycleDao;
import com.accenture.applicationlocationvehicule.service.dto.MotorCycleRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.MotorCycleResponseDto;
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
                .orElseThrow(() -> new EntityNotFoundException(messages.getMessage("motorcycle.id.notfound")));

        return motorCycleMapper.toMotorCycleResponseDto(motorCycle);
    }

    @Override
    public void deleteMotorCycle(int id) {
        MotorCycle motorCycle = motorCycleDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(messages.getMessage("motorcycle.id.notfound")));

        motorCycleDao.delete(motorCycle);
    }

    @Override
    public MotorCycleResponseDto updateMotorCycle(int id, MotorCycleRequestDto dto) {
        MotorCycle motorCycle = motorCycleDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(messages.getMessage("motorcycle.id.notfound")));

        auditor(dto);

        motorCycle.setBrand(dto.brand());
        motorCycle.setModel(dto.model());
        motorCycle.setColor(dto.color());
        motorCycle.setFuelType(dto.fuelType());
        motorCycle.setDailyRate(dto.dailyRate());
        motorCycle.setMileage(dto.mileage());
        motorCycle.setActive(dto.active());
        motorCycle.setParkRemove(dto.parkRemove());
        motorCycle.setRequiredPermit(dto.requiredPermit());
        motorCycle.setCylindree(dto.cylindree());
        motorCycle.setTypeMoto(dto.typeMoto());

        return motorCycleMapper.toMotorCycleResponseDto(motorCycle);
    }

    @Override
    public MotorCycleResponseDto updateMotorCyclePartially(int id, MotorCycleRequestDto dto) {
        MotorCycle motorCycle = motorCycleDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(messages.getMessage("motorcycle.id.notfound")));

        if (dto.brand() != null && !dto.brand().isBlank())
            motorCycle.setBrand(dto.brand());

        if (dto.model() != null && !dto.model().isBlank())
            motorCycle.setModel(dto.model());

        if (dto.color() != null && !dto.color().isBlank())
            motorCycle.setColor(dto.color());

        if (dto.fuelType() != null)
            motorCycle.setFuelType(dto.fuelType());

        if (dto.dailyRate() != null && dto.dailyRate() > 0)
            motorCycle.setDailyRate(dto.dailyRate());

        if (dto.mileage() != null && dto.mileage() >= 0)
            motorCycle.setMileage(dto.mileage());

        if (dto.active() != null)
            motorCycle.setActive(dto.active());

        if (dto.parkRemove() != null)
            motorCycle.setParkRemove(dto.parkRemove());

        if (dto.requiredPermit() != null && !dto.requiredPermit().isBlank())
            motorCycle.setRequiredPermit(dto.requiredPermit());


        if (dto.cylindree() != null)
            motorCycle.setCylindree(dto.cylindree());

        return motorCycleMapper.toMotorCycleResponseDto(motorCycle);
    }

    private void auditor(MotorCycleRequestDto dto) {
        if (dto == null)
            throw new MotorCycleException(messages.getMessage("motorcycle.null"));

        if (dto.brand() == null || dto.brand().isBlank())
            throw new MotorCycleException(messages.getMessage("motorcycle.brand.null"));

        if (dto.model() == null || dto.model().isBlank())
            throw new MotorCycleException(messages.getMessage("motorcycle.model.null"));

        if (dto.color() == null || dto.color().isBlank())
            throw new MotorCycleException(messages.getMessage("motorcycle.color.null"));

        if (dto.fuelType() == null)
            throw new MotorCycleException(messages.getMessage("motorcycle.fueltype.null"));

        if (dto.dailyRate() == null)
            throw new MotorCycleException(messages.getMessage("motorcycle.dailyrate.null"));
        if (dto.dailyRate() <= 0)
            throw new MotorCycleException(messages.getMessage("motorcycle.dailyrate.min"));

        if (dto.mileage() == null)
            throw new MotorCycleException(messages.getMessage("motorcycle.mileage.null"));
        if (dto.mileage() < 0)
            throw new MotorCycleException(messages.getMessage("motorcycle.mileage.min"));

        if (dto.active() == null)
            throw new MotorCycleException(messages.getMessage("motorcycle.active.null"));

        if (dto.parkRemove() == null)
            throw new MotorCycleException(messages.getMessage("motorcycle.parkremove.null"));

        if (dto.requiredPermit() == null || dto.requiredPermit().isBlank())
            throw new MotorCycleException(messages.getMessage("motorcycle.requiredpermit.null"));
    }
}

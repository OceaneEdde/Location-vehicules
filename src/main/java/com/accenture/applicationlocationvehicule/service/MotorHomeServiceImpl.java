package com.accenture.applicationlocationvehicule.service;

import com.accenture.applicationlocationvehicule.exception.MotorCycleException;
import com.accenture.applicationlocationvehicule.exception.MotorHomeException;
import com.accenture.applicationlocationvehicule.mapper.MotorHomeMapper;
import com.accenture.applicationlocationvehicule.model.MotorHome;
import com.accenture.applicationlocationvehicule.repository.MotorHomeDao;
import com.accenture.applicationlocationvehicule.service.dto.MotorHomeRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.MotorHomeResponseDto;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class MotorHomeServiceImpl implements MotorHomeService {

    private final MotorHomeDao motorHomeDao;
    private final MotorHomeMapper motorHomeMapper;
    private final MessageSourceAccessor messages;

    @Override
    public MotorHomeResponseDto addMotorHome(MotorHomeRequestDto dto) {
        auditor(dto);
        MotorHome saved = motorHomeDao.save(motorHomeMapper.toMotorHome(dto));
        return motorHomeMapper.toMotorHomeResponseDto(saved);
    }

    @Override
    public List<MotorHomeResponseDto> findAllMotorHomes() {
        return motorHomeDao.findAll().stream()
                .map(motorHomeMapper::toMotorHomeResponseDto)
                .toList();
    }

    @Override
    public MotorHomeResponseDto findMotorHomeById(int id) {
        MotorHome motorHome = motorHomeDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(messages.getMessage("motorHome.id.notfound")));

        return motorHomeMapper.toMotorHomeResponseDto(motorHome);
    }

    @Override
    public void deleteMotorHome(int id) {
        MotorHome motorHome = motorHomeDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(messages.getMessage("motorHome.id.notfound")));

        motorHomeDao.delete(motorHome);
    }

    @Override
    public MotorHomeResponseDto updateMotorHome(int id, MotorHomeRequestDto dto) {
        MotorHome motorHome = motorHomeDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(messages.getMessage("motorHome.id.notfound")));

        auditor(dto);

        motorHome.setBrand(dto.brand());
        motorHome.setModel(dto.model());
        motorHome.setColor(dto.color());
        motorHome.setFuelType(dto.fuelType());
        motorHome.setDailyRate(dto.dailyRate());
        motorHome.setMileage(dto.mileage());
        motorHome.setActive(dto.active());
        motorHome.setParkRemove(dto.parkRemove());
        motorHome.setLicences(dto.licences());
        motorHome.setNbPlaces(dto.nbPlaces());
        motorHome.setPtac(dto.ptac());
        motorHome.setHeight(dto.height());
        motorHome.setKitchen(dto.kitchen());
        motorHome.setNbBed(dto.nbBed());
        motorHome.setBedLinen(dto.bedLinen());
        motorHome.setFridge(dto.fridge());
        motorHome.setShower(dto.shower());
        motorHome.setTypes(dto.types());
        motorHome.setTransmission(dto.transmission());


        return motorHomeMapper.toMotorHomeResponseDto(motorHome);
    }

    @Override
    public MotorHomeResponseDto updateMotorHomePartially(int id, MotorHomeRequestDto dto) {
        MotorHome motorHome = motorHomeDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(messages.getMessage("motorHome.id.notfound")));

        if (dto.brand() != null && !dto.brand().isBlank())
            motorHome.setBrand(dto.brand());

        if (dto.model() != null && !dto.model().isBlank())
            motorHome.setModel(dto.model());

        if (dto.color() != null && !dto.color().isBlank())
            motorHome.setColor(dto.color());

        if (dto.fuelType() != null) {
            motorHome.setFuelType(dto.fuelType());
        }

        if (dto.dailyRate() != null && dto.dailyRate() > 0)
            motorHome.setDailyRate(dto.dailyRate());

        if (dto.mileage() != null && dto.mileage() >= 0)
            motorHome.setMileage(dto.mileage());

        if (dto.active() != null)
            motorHome.setActive(dto.active());

        if (dto.parkRemove() != null)
            motorHome.setParkRemove(dto.parkRemove());

        if (dto.licences() != null )
            motorHome.setLicences(dto.licences());

        if (dto.nbPlaces() != null && dto.nbPlaces() > 0)
            motorHome.setNbPlaces(dto.nbPlaces());

        if (dto.ptac() != null && dto.ptac() > 0)
            motorHome.setPtac(dto.ptac());

        if (dto.height() != null && dto.height() > 0)
            motorHome.setHeight(dto.height());

        if (dto.kitchen() != null)
            motorHome.setKitchen(dto.kitchen());

        if (dto.nbBed() != null && dto.nbBed() > 0)
            motorHome.setNbBed(dto.nbBed());

        if (dto.bedLinen() != null)
            motorHome.setBedLinen(dto.bedLinen());

        if (dto.fridge() != null)
            motorHome.setFridge(dto.fridge());

        if (dto.shower() != null)
            motorHome.setShower(dto.shower());

        if (dto.types() != null )
            motorHome.setTypes(dto.types());

        if (dto.transmission() != null)
            motorHome.setTransmission(dto.transmission());


        return motorHomeMapper.toMotorHomeResponseDto(motorHome);
    }

    private void auditor(MotorHomeRequestDto dto) {
        if (dto == null)
            throw new MotorHomeException(messages.getMessage("motorHome.null"));

        if (dto.brand() == null || dto.brand().isBlank())
            throw new MotorHomeException(messages.getMessage("motorHome.brand.null"));

        if (dto.model() == null || dto.model().isBlank())
            throw new MotorHomeException(messages.getMessage("motorHome.model.null"));

        if (dto.color() == null || dto.color().isBlank())
            throw new MotorHomeException(messages.getMessage("motorHome.color.null"));

        if (dto.fuelType() == null)
            throw new MotorHomeException(messages.getMessage("motorHome.fueltype.null"));

        if (dto.dailyRate() == null)
            throw new MotorHomeException(messages.getMessage("motorHome.dailyrate.null"));
        if (dto.dailyRate() <= 0)
            throw new MotorHomeException(messages.getMessage("motorHome.dailyrate.min"));

        if (dto.mileage() == null)
            throw new MotorHomeException(messages.getMessage("motorHome.mileage.null"));
        if (dto.mileage() < 0)
            throw new MotorHomeException(messages.getMessage("motorHome.mileage.min"));

        if (dto.active() == null)
            throw new MotorHomeException(messages.getMessage("motorHome.active.null"));

        if (dto.parkRemove() == null)
            throw new MotorHomeException(messages.getMessage("motorHome.parkremove.null"));

        if (dto.licences() == null)
            throw new MotorHomeException(messages.getMessage("motorHome.licences.null"));

        if (dto.nbPlaces() == null || dto.nbPlaces() <= 0)
            throw new MotorHomeException(messages.getMessage("motorHome.nbplaces.invalid"));

        if (dto.ptac() == null || dto.ptac() <= 0)
            throw new MotorHomeException(messages.getMessage("motorHome.ptac.invalid"));

        if (dto.height() == null || dto.height() <= 0)
            throw new MotorHomeException(messages.getMessage("motorHome.height.invalid"));

        if (dto.kitchen() == null)
            throw new MotorHomeException(messages.getMessage("motorHome.kitchen.null"));

        if (dto.nbBed() == null || dto.nbBed() <= 0)
            throw new MotorHomeException(messages.getMessage("motorHome.nbbed.invalid"));

        if (dto.bedLinen() == null)
            throw new MotorHomeException(messages.getMessage("motorHome.bedlinen.null"));

        if (dto.fridge() == null)
            throw new MotorHomeException(messages.getMessage("motorHome.fridge.null"));

        if (dto.shower() == null)
            throw new MotorHomeException(messages.getMessage("motorHome.shower.null"));

        if (dto.types() == null )
            throw new MotorHomeException(messages.getMessage("motorHome.types.null"));

        if (dto.transmission() == null)
            throw new MotorCycleException(messages.getMessage("motorHome.transmission.null"));

    }
}

package com.accenture.applicationlocationvehicule.service;

import com.accenture.applicationlocationvehicule.exception.MotorCycleException;
import com.accenture.applicationlocationvehicule.exception.MotorHomeException;
import com.accenture.applicationlocationvehicule.mapper.MotorHomeMapper;
import com.accenture.applicationlocationvehicule.model.MotorHome;
import com.accenture.applicationlocationvehicule.repository.MotorHomeDao;
import com.accenture.applicationlocationvehicule.service.dto.MotorHomeRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.MotorHomeResponseDto;
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
                .orElseThrow(() -> new EntityNotFoundException(messages.getMessage(Messages.MESSAGES_ERROR_MOTORHOME_NOTFOUND)));

        return motorHomeMapper.toMotorHomeResponseDto(motorHome);
    }

    @Override
    public void deleteMotorHome(int id) {
        MotorHome motorHome = motorHomeDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(messages.getMessage(Messages.MESSAGES_ERROR_MOTORHOME_NOTFOUND)));

        motorHomeDao.delete(motorHome);
    }

        @Override
        public MotorHomeResponseDto updateMotorHomePartially(int id, MotorHomeRequestDto dto) {
            MotorHome motorHome = motorHomeDao.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException(messages.getMessage(Messages.MESSAGES_ERROR_MOTORHOME_NOTFOUND)));

            applyPartiallyUpdate(motorHome, dto);

            motorHomeDao.save(motorHome);

            return motorHomeMapper.toMotorHomeResponseDto(motorHome);

        }

    //  Sous-méthodes

    private void applyPartiallyUpdate(MotorHome motorHome, MotorHomeRequestDto dto){
        if (dto.brand() != null && !dto.brand().isBlank()) motorHome.setBrand(dto.brand());
        if (dto.model() != null && !dto.model().isBlank()) motorHome.setModel(dto.model());
        if (dto.color() != null && !dto.color().isBlank()) motorHome.setColor(dto.color());
        if (dto.fuelType() != null) motorHome.setFuelType(dto.fuelType());
        if (dto.dailyRate() != null && dto.dailyRate() > 0) motorHome.setDailyRate(dto.dailyRate());
        if (dto.mileage() != null && dto.mileage() >= 0) motorHome.setMileage(dto.mileage());
        if (dto.active() != null) motorHome.setActive(dto.active());
        if (dto.parkRemove() != null) motorHome.setParkRemove(dto.parkRemove());
        if (dto.licenses() != null ) motorHome.setLicenses(dto.licenses());
        if (dto.nbPlaces() != null && dto.nbPlaces() > 0) motorHome.setNbPlaces(dto.nbPlaces());
        if (dto.ptac() != null && dto.ptac() > 0) motorHome.setPtac(dto.ptac());
        if (dto.height() != null && dto.height() > 0) motorHome.setHeight(dto.height());
        if (dto.kitchen() != null) motorHome.setKitchen(dto.kitchen());
        if (dto.nbBed() != null && dto.nbBed() > 0) motorHome.setNbBed(dto.nbBed());
        if (dto.bedLinen() != null) motorHome.setBedLinen(dto.bedLinen());
        if (dto.fridge() != null) motorHome.setFridge(dto.fridge());
        if (dto.shower() != null) motorHome.setShower(dto.shower());
        if (dto.types() != null ) motorHome.setTypes(dto.types());
        if (dto.transmission() != null) motorHome.setTransmission(dto.transmission());

    }

    private void auditor(MotorHomeRequestDto dto) {
        if (dto == null) throw new MotorHomeException(messages.getMessage(Messages.MESSAGES_ERROR_MOTORHOME_NOTFOUND));
        if (dto.brand() == null || dto.brand().isBlank()) throw new MotorHomeException(messages.getMessage(Messages.MESSAGES_ERROR_MOTORHOME_BRAND));
        if (dto.model() == null || dto.model().isBlank()) throw new MotorHomeException(messages.getMessage(Messages.MESSAGES_ERROR_MOTORHOME_MODEL));
        if (dto.color() == null || dto.color().isBlank()) throw new MotorHomeException(messages.getMessage(Messages.MESSAGES_ERROR_MOTORHOME_COLOR));
        if (dto.fuelType() == null) throw new MotorHomeException(messages.getMessage(Messages.MESSAGES_ERROR_MOTORHOME_FUELTYPE));
        if (dto.dailyRate() == null) throw new MotorHomeException(messages.getMessage(Messages.MESSAGES_ERROR_MOTORHOME_DAYLIRATE_NULL));
        if (dto.dailyRate() <= 0) throw new MotorHomeException(messages.getMessage(Messages.MESSAGES_ERROR_MOTORHOME_DAYLIRATE_MIN));
        if (dto.mileage() == null) throw new MotorHomeException(messages.getMessage(Messages.MESSAGES_ERROR_MOTORHOME_MILEAGE_NULL));
        if (dto.mileage() < 0) throw new MotorHomeException(messages.getMessage(Messages.MESSAGES_ERROR_MOTORHOME_MILEAGE_MIN));
        if (dto.active() == null) throw new MotorHomeException(messages.getMessage(Messages.MESSAGES_ERROR_MOTORHOME_ACTIVE));
        if (dto.parkRemove() == null) throw new MotorHomeException(messages.getMessage(Messages.MESSAGES_ERROR_MOTORHOME_PARKREMOVE));
        if (dto.licenses() == null) throw new MotorHomeException(messages.getMessage(Messages.MESSAGES_ERROR_MOTORHOME_LICENSES));
        if (dto.nbPlaces() == null || dto.nbPlaces() <= 0) throw new MotorHomeException(messages.getMessage(Messages.MESSAGES_ERROR_MOTORHOME_NBPLACES));
        if (dto.ptac() == null || dto.ptac() <= 0) throw new MotorHomeException(messages.getMessage(Messages.MESSAGES_ERROR_MOTORHOME_PTAC));
        if (dto.height() == null || dto.height() <= 0) throw new MotorHomeException(messages.getMessage(Messages.MESSAGES_ERROR_MOTORHOME_HEIGHT));
        if (dto.kitchen() == null) throw new MotorHomeException(messages.getMessage(Messages.MESSAGES_ERROR_MOTORHOME_KITCHEN));
        if (dto.nbBed() == null || dto.nbBed() <= 0) throw new MotorHomeException(messages.getMessage(Messages.MESSAGES_ERROR_MOTORHOME_NBBED));
        if (dto.bedLinen() == null) throw new MotorHomeException(messages.getMessage(Messages.MESSAGES_ERROR_MOTORHOME_NBLINEN));
        if (dto.fridge() == null) throw new MotorHomeException(messages.getMessage(Messages.MESSAGES_ERROR_MOTORHOME_FRIDGE));
        if (dto.shower() == null) throw new MotorHomeException(messages.getMessage(Messages.MESSAGES_ERROR_MOTORHOME_SHOWER));
        if (dto.types() == null ) throw new MotorHomeException(messages.getMessage(Messages.MESSAGES_ERROR_MOTORHOME_TYPES));
        if (dto.transmission() == null) throw new MotorCycleException(messages.getMessage(Messages.MESSAGES_ERROR_MOTORHOME_TRANSMISSION));

    }
}

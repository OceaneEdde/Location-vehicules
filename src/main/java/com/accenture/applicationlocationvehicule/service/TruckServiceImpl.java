package com.accenture.applicationlocationvehicule.service;
import com.accenture.applicationlocationvehicule.exception.TruckException;
import com.accenture.applicationlocationvehicule.mapper.TruckMapper;
import com.accenture.applicationlocationvehicule.model.Truck;
import com.accenture.applicationlocationvehicule.repository.TruckDao;
import com.accenture.applicationlocationvehicule.service.dto.TruckRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.TruckResponseDto;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class TruckServiceImpl implements TruckService {

    private final TruckDao truckDao;
    private final TruckMapper truckMapper;
    private final MessageSourceAccessor messages;

    @Override
    public TruckResponseDto addTruck(TruckRequestDto dto) {
        auditor(dto);
        Truck saved = truckDao.save(truckMapper.toTruck(dto));
        return truckMapper.toTruckResponseDto(saved);
    }

    @Override
    public List<TruckResponseDto> findAllTrucks() {
        return truckDao.findAll().stream()
                .map(truckMapper::toTruckResponseDto)
                .toList();
    }

    @Override
    public TruckResponseDto findTruckById(int id) {
        Truck truck = truckDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(messages.getMessage("truck.id.notfound")));

        return truckMapper.toTruckResponseDto(truck);
    }

    @Override
    public void deleteTruck(int id) {
        Truck truck = truckDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(messages.getMessage("truck.id.notfound")));

        truckDao.delete(truck);
    }

    @Override
    public TruckResponseDto updateTruck(int id, TruckRequestDto dto) {
        Truck truck = truckDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(messages.getMessage("truck.id.notfound")));

        auditor(dto);

        truck.setBrand(dto.brand());
        truck.setModel(dto.model());
        truck.setColor(dto.color());
        truck.setFuelType(dto.fuelType());
        truck.setDailyRate(dto.dailyRate());
        truck.setMileage(dto.mileage());
        truck.setActive(dto.active());
        truck.setParkRemove(dto.parkRemove());
        truck.setLicences(dto.licences());
        truck.setNbPlaces(dto.nbPlaces());
        truck.setLoadMax(dto.loadMax());
        truck.setCapacity(dto.capacity());
        truck.setPtac(dto.ptac());
        truck.setTransmission(dto.transmission());
        truck.setConditioningAir(dto.conditioningAir());
        truck.setTypes(dto.types());


        return truckMapper.toTruckResponseDto(truck);
    }

    @Override
    public TruckResponseDto updateTruckPartially(int id, TruckRequestDto dto) {
        Truck truck = truckDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(messages.getMessage("truck.id.notfound")));

        if (dto.brand() != null && !dto.brand().isBlank())
            truck.setBrand(dto.brand());

        if (dto.model() != null && !dto.model().isBlank())
            truck.setModel(dto.model());

        if (dto.color() != null && !dto.color().isBlank())
            truck.setColor(dto.color());

        if (dto.fuelType() != null) {
            truck.setFuelType(dto.fuelType());
        }
        if (dto.dailyRate() != null && dto.dailyRate() > 0)
            truck.setDailyRate(dto.dailyRate());

        if (dto.mileage() != null && dto.mileage() >= 0)
            truck.setMileage(dto.mileage());

        if (dto.active() != null)
            truck.setActive(dto.active());

        if (dto.parkRemove() != null)
            truck.setParkRemove(dto.parkRemove());

        if (dto.licences() != null)
            truck.setLicences(dto.licences());

        if (dto.nbPlaces() != null && dto.nbPlaces() > 0)
            truck.setNbPlaces(dto.nbPlaces());

        if (dto.loadMax() != null && dto.loadMax() > 0)
            truck.setLoadMax(dto.loadMax());

        if (dto.capacity() != null && dto.capacity() > 0)
            truck.setCapacity(dto.capacity());

        if (dto.ptac() != null && dto.ptac() > 0)
            truck.setPtac(dto.ptac());

        if (dto.transmission() != null)
            truck.setTransmission(dto.transmission());

        if (dto.conditioningAir() != null)
            truck.setConditioningAir(dto.conditioningAir());

        if (dto.types() != null )
            truck.setTypes(dto.types());


        return truckMapper.toTruckResponseDto(truck);
    }

    private void auditor(TruckRequestDto dto) {
        if (dto == null)
            throw new TruckException(messages.getMessage("Truck.null"));

        if (dto.brand() == null || dto.brand().isBlank())
            throw new TruckException(messages.getMessage("truck.brand.null"));

        if (dto.model() == null || dto.model().isBlank())
            throw new TruckException(messages.getMessage("truck.model.null"));

        if (dto.color() == null || dto.color().isBlank())
            throw new TruckException(messages.getMessage("truck.color.null"));

        if (dto.fuelType() == null)
            throw new TruckException(messages.getMessage("truck.fueltype.null"));

        if (dto.dailyRate() == null)
            throw new TruckException(messages.getMessage("truck.dailyrate.null"));
        if (dto.dailyRate() <= 0)
            throw new TruckException(messages.getMessage("truck.dailyrate.min"));

        if (dto.mileage() == null)
            throw new TruckException(messages.getMessage("truck.mileage.null"));
        if (dto.mileage() < 0)
            throw new TruckException(messages.getMessage("truck.mileage.min"));

        if (dto.active() == null)
            throw new TruckException(messages.getMessage("truck.active.null"));

        if (dto.parkRemove() == null)
            throw new TruckException(messages.getMessage("truck.parkremove.null"));

        if (dto.licences() == null)
            throw new TruckException(messages.getMessage("truck.licences.null"));

        if (dto.nbPlaces() == null || dto.nbPlaces() <= 0)
            throw new TruckException(messages.getMessage("truck.nbplaces.invalid"));

        if (dto.loadMax() == null || dto.loadMax() <= 0)
            throw new TruckException(messages.getMessage("truck.loadmax.invalid"));

        if (dto.capacity() == null || dto.capacity() <= 0)
            throw new TruckException(messages.getMessage("truck.capacity.invalid"));

        if (dto.ptac() == null || dto.ptac() <= 0)
            throw new TruckException(messages.getMessage("truck.ptac.invalid"));

        if (dto.transmission() == null)
            throw new TruckException(messages.getMessage("truck.transmission.null"));

        if (dto.conditioningAir() == null)
            throw new TruckException(messages.getMessage("truck.conditioningair.null"));

        if (dto.types() == null)
            throw new TruckException(messages.getMessage("truck.types.null"));

    }
}

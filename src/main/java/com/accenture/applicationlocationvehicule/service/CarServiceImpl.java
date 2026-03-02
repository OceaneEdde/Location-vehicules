package com.accenture.applicationlocationvehicule.service;

import com.accenture.applicationlocationvehicule.exception.CarException;
import com.accenture.applicationlocationvehicule.mapper.CarMapper;
import com.accenture.applicationlocationvehicule.model.Car;
import com.accenture.applicationlocationvehicule.model.FuelType;
import com.accenture.applicationlocationvehicule.repository.CarDao;
import com.accenture.applicationlocationvehicule.service.dto.CarRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.CarResponseDto;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class CarServiceImpl implements CarService {

    private final CarDao carDao;
    private final CarMapper carMapper;
    private final MessageSourceAccessor messages;

    @Override
    public CarResponseDto addCar(CarRequestDto dto) {
        auditor(dto);
        Car saved = carDao.save(carMapper.toCar(dto));
        return carMapper.toCarResponseDto(saved);
    }

    @Override
    public List<CarResponseDto> findAllCars() {
        return carDao.findAll().stream()
                .map(carMapper::toCarResponseDto)
                .toList();
    }

    @Override
    public CarResponseDto findCarById(int id) {
        Car car = carDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(messages.getMessage("car.id.notfound")));

        return carMapper.toCarResponseDto(car);
    }

    @Override
    public void deleteCar(int id) {
        Car car = carDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(messages.getMessage("car.id.notfound")));

        carDao.delete(car);
    }

    @Override
    public CarResponseDto updateCar(int id, CarRequestDto dto) {
        Car car = carDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(messages.getMessage("car.id.notfound")));

        auditor(dto);

        car.setBrand(dto.brand());
        car.setModel(dto.model());
        car.setColor(dto.color());
        car.setFuelType((FuelType) dto.fuelType());
        car.setDailyRate(dto.dailyRate());
        car.setMileage(dto.mileage());
        car.setActive(dto.active());
        car.setParkRemove(dto.parkRemove());
        car.setRequiredPermit(dto.requiredPermit());

        return carMapper.toCarResponseDto(car);
    }

    @Override
    public CarResponseDto updateCarPartially(int id, CarRequestDto dto) {
        Car car = carDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(messages.getMessage("car.id.notfound")));

        if (dto.brand() != null && !dto.brand().isBlank())
            car.setBrand(dto.brand());

        if (dto.model() != null && !dto.model().isBlank())
            car.setModel(dto.model());

        if (dto.color() != null && !dto.color().isBlank())
            car.setColor(dto.color());

        if (dto.fuelType() != null)
            car.setFuelType((FuelType) dto.fuelType());

        if (dto.dailyRate() != null && dto.dailyRate() > 0)
            car.setDailyRate(dto.dailyRate());

        if (dto.mileage() != null && dto.mileage() >= 0)
            car.setMileage(dto.mileage());

        if (dto.active() != null)
            car.setActive(dto.active());

        if (dto.parkRemove() != null)
            car.setParkRemove(dto.parkRemove());

        if (dto.requiredPermit() != null && !dto.requiredPermit().isBlank())
            car.setRequiredPermit(dto.requiredPermit());

        return carMapper.toCarResponseDto(car);
    }

    private void auditor(CarRequestDto dto) {
        if (dto == null)
            throw new CarException(messages.getMessage("motorCycle.null"));

        if (dto.brand() == null || dto.brand().isBlank())
            throw new CarException(messages.getMessage("car.brand.null"));

        if (dto.model() == null || dto.model().isBlank())
            throw new CarException(messages.getMessage("car.model.null"));

        if (dto.color() == null || dto.color().isBlank())
            throw new CarException(messages.getMessage("car.color.null"));

        if (dto.fuelType() == null)
            throw new CarException(messages.getMessage("car.fueltype.null"));

        if (dto.dailyRate() == null)
            throw new CarException(messages.getMessage("car.dailyrate.null"));
        if (dto.dailyRate() <= 0)
            throw new CarException(messages.getMessage("car.dailyrate.min"));

        if (dto.mileage() == null)
            throw new CarException(messages.getMessage("car.mileage.null"));
        if (dto.mileage() < 0)
            throw new CarException(messages.getMessage("car.mileage.min"));

        if (dto.active() == null)
            throw new CarException(messages.getMessage("car.active.null"));

        if (dto.parkRemove() == null)
            throw new CarException(messages.getMessage("car.parkremove.null"));

        if (dto.requiredPermit() == null || dto.requiredPermit().isBlank())
            throw new CarException(messages.getMessage("car.requiredpermit.null"));
    }
}

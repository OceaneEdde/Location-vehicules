package com.accenture.applicationlocationvehicule.service;

import com.accenture.applicationlocationvehicule.exception.CarException;
import com.accenture.applicationlocationvehicule.mapper.CarMapper;
import com.accenture.applicationlocationvehicule.model.Car;
import com.accenture.applicationlocationvehicule.repository.CarDao;
import com.accenture.applicationlocationvehicule.service.dto.CarRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.CarResponseDto;
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
                .orElseThrow(() -> new EntityNotFoundException(messages.getMessage(Messages.MESSAGES_ERROR_CAR_NOTFOUND)));

        return carMapper.toCarResponseDto(car);
    }

    @Override
    public void deleteCar(int id) {
        Car car = carDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(messages.getMessage(Messages.MESSAGES_ERROR_CAR_NOTFOUND)));

        carDao.delete(car);
    }

    @Override
    public CarResponseDto updateCar(int id, CarRequestDto dto) {
        Car car = carDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(messages.getMessage(Messages.MESSAGES_ERROR_CAR_NOTFOUND)));

        auditor(dto);

        applyFullUpdate(car, dto);

        carDao.save(car);

        return carMapper.toCarResponseDto(car);
    }

    @Override
    public CarResponseDto updateCarPartially(int id, CarRequestDto dto) {
        Car car = carDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(messages.getMessage(Messages.MESSAGES_ERROR_CAR_NOTFOUND)));

        applyPartiallyUpdate(car, dto);

        carDao.save(car);

        return carMapper.toCarResponseDto(car);
    }


    //  Sous-méthode
    private void applyFullUpdate(Car car, CarRequestDto dto){
        car.setBrand(dto.brand());
        car.setModel(dto.model());
        car.setColor(dto.color());
        car.setFuelType(dto.fuelType());
        car.setDailyRate(dto.dailyRate());
        car.setMileage(dto.mileage());
        car.setActive(dto.active());
        car.setParkRemove(dto.parkRemove());
        car.setLicenses(dto.licenses());
        car.setNbPlaces(dto.nbPlaces());
        car.setNbDoors(dto.nbDoors());
        car.setConditioningAir(dto.conditioningAir());
        car.setTransmission(dto.transmission());
        car.setTypes(dto.types());
    }


    private void applyPartiallyUpdate(Car car, CarRequestDto dto){
        if (dto.brand() != null && !dto.brand().isBlank()) car.setBrand(dto.brand());
        if (dto.model() != null && !dto.model().isBlank()) car.setModel(dto.model());
        if (dto.color() != null && !dto.color().isBlank()) car.setColor(dto.color());
        if (dto.fuelType() != null) car.setFuelType(dto.fuelType());
        if (dto.dailyRate() != null && dto.dailyRate() > 0) car.setDailyRate(dto.dailyRate());
        if (dto.mileage() != null && dto.mileage() >= 0) car.setMileage(dto.mileage());
        if (dto.active() != null) car.setActive(dto.active());
        if (dto.parkRemove() != null) car.setParkRemove(dto.parkRemove());
        if (dto.licenses() != null) car.setLicenses(dto.licenses());
        if (dto.nbPlaces() != null && dto.nbPlaces() > 0) car.setNbPlaces(dto.nbPlaces());
        if (dto.nbDoors() != null && dto.nbDoors() > 0) car.setNbDoors(dto.nbDoors());
        if (dto.conditioningAir() != null) car.setConditioningAir(dto.conditioningAir());
        if (dto.transmission() != null) car.setTransmission(dto.transmission());
        if (dto.types() != null) car.setTypes(dto.types());


    }

    private void auditor(CarRequestDto dto) {
        if (dto == null) throw new CarException(messages.getMessage(Messages.MESSAGES_ERROR_CAR_NOTFOUND));
        if (dto.brand() == null || dto.brand().isBlank()) throw new CarException(messages.getMessage(Messages.MESSAGES_ERROR_CAR_BRAND));
        if (dto.model() == null || dto.model().isBlank()) throw new CarException(messages.getMessage(Messages.MESSAGES_ERROR_CAR_MODEL));
        if (dto.color() == null || dto.color().isBlank()) throw new CarException(messages.getMessage(Messages.MESSAGES_ERROR_CAR_COLOR));
        if (dto.fuelType() == null) throw new CarException(messages.getMessage(Messages.MESSAGES_ERROR_CAR_FUELTYPE));
        if (dto.dailyRate() == null) throw new CarException(messages.getMessage(Messages.MESSAGES_ERROR_CAR_DAILYRATE_NULL));
        if (dto.dailyRate() <= 0) throw new CarException(messages.getMessage(Messages.MESSAGES_ERROR_CAR_DAILYRATE_MIN));
        if (dto.mileage() == null) throw new CarException(messages.getMessage(Messages.MESSAGES_ERROR_CAR_MILEAGE_NULL));
        if (dto.mileage() < 0) throw new CarException(messages.getMessage(Messages.MESSAGES_ERROR_CAR_MILEAGE_MIN));
        if (dto.active() == null) throw new CarException(messages.getMessage(Messages.MESSAGES_ERROR_CAR_ACTIVE));
        if (dto.parkRemove() == null) throw new CarException(messages.getMessage(Messages.MESSAGES_ERROR_CAR_PARKREMOVE));
        if (dto.licenses() == null ) throw new CarException(messages.getMessage(Messages.MESSAGES_ERROR_CAR_LICENSES));
        if (dto.nbPlaces() == null || dto.nbPlaces() <= 0) throw new CarException(messages.getMessage(Messages.MESSAGES_ERROR_CAR_NBPLACES));
        if (dto.nbDoors() == null || dto.nbDoors() <= 0) throw new CarException(messages.getMessage(Messages.MESSAGES_ERROR_CAR_NBDOORS));
        if (dto.conditioningAir() == null) throw new CarException(messages.getMessage(Messages.MESSAGES_ERROR_CAR_CONDITIONINGAIR));
        if (dto.transmission() == null) throw new CarException(messages.getMessage(Messages.MESSAGES_ERROR_CAR_TRANSMISSION));
        if (dto.types() == null) throw new CarException(messages.getMessage(Messages.MESSAGES_ERROR_CAR_TYPES));
    }
}

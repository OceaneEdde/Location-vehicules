package com.accenture.applicationlocationvehicule.service.fake;

import com.accenture.applicationlocationvehicule.mapper.CarMapper;
import com.accenture.applicationlocationvehicule.model.Car;
import com.accenture.applicationlocationvehicule.service.dto.CarRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.CarResponseDto;


import java.util.concurrent.atomic.AtomicInteger;

public class FakeCarMapper implements CarMapper {
    private final AtomicInteger seq = new AtomicInteger(1);

    @Override
    public Car toCar(CarRequestDto dto) {
        Car c = new Car();
        c.setId(seq.getAndIncrement());
        c.setBrand(dto.brand());
        c.setModel(dto.model());
        c.setColor(dto.color());
        c.setFuelType(dto.fuelType());
        c.setDailyRate(dto.dailyRate());
        c.setMileage(dto.mileage());
        c.setActive(dto.active());
        c.setParkRemove(dto.parkRemove());
        c.setLicenses(dto.licenses());
        c.setNbPlaces(dto.nbPlaces());
        c.setNbDoors(dto.nbDoors());
        c.setConditioningAir(dto.conditioningAir());
        c.setTransmission(dto.transmission());
        c.setTypes(dto.types());
        return c;
    }

    @Override
    public CarResponseDto toCarResponseDto(Car car) {
        return new CarResponseDto(
                car.getId(),
                car.getBrand(),
                car.getModel(),
                car.getColor(),
                car.getFuelType(),
                car.getDailyRate(),
                car.getMileage(),
                car.getActive(),
                car.getParkRemove(),
                car.getLicenses(),
                car.getNbPlaces(),
                car.getNbDoors(),
                car.getConditioningAir(),
                car.getTransmission(),
                car.getTypes()
        );
    }
}


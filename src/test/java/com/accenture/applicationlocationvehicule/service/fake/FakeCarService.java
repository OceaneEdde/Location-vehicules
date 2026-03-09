package com.accenture.applicationlocationvehicule.service.fake;


import com.accenture.applicationlocationvehicule.exception.CarException;
import com.accenture.applicationlocationvehicule.model.Car;
import com.accenture.applicationlocationvehicule.service.CarService;
import com.accenture.applicationlocationvehicule.service.dto.CarRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.CarResponseDto;


import java.util.List;

public class FakeCarService implements CarService {

    private final FakeCarDao dao;
    private final FakeCarMapper mapper;

    public FakeCarService(FakeCarDao dao, FakeCarMapper mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    @Override
    public CarResponseDto addCar(CarRequestDto dto) throws CarException {
        Car car = mapper.toCar(dto);
        dao.save(car);
        return mapper.toCarResponseDto(car);
    }

    @Override
    public CarResponseDto updateCarPartially(int id, CarRequestDto dto) {
        Car car = dao.findById(id).orElseThrow();
        if (dto.color() != null) car.setColor(dto.color());
        if (dto.model() != null) car.setModel(dto.model());
        if (dto.brand() != null) car.setBrand(dto.brand());
        dao.save(car);
        return mapper.toCarResponseDto(car);
    }

    @Override
    public List<CarResponseDto> findAllCars() {
        return dao.findAll().stream()
                .map(mapper::toCarResponseDto)
                .toList();
    }

    @Override
    public CarResponseDto findCarById(int id) {
        return dao.findById(id)
                .map(mapper::toCarResponseDto)
                .orElse(null);
    }

    @Override
    public void deleteCar(int id) {
        dao.deleteById(id);
    }
}

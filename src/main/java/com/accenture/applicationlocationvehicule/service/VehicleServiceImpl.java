package com.accenture.applicationlocationvehicule.service;

import com.accenture.applicationlocationvehicule.exception.VehicleException;
import com.accenture.applicationlocationvehicule.mapper.VehicleMapper;
import com.accenture.applicationlocationvehicule.model.Vehicle;
import com.accenture.applicationlocationvehicule.repository.VehicleDao;
import com.accenture.applicationlocationvehicule.service.dto.VehicleRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.VehicleResponseDto;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
@Transactional
public class VehicleServiceImpl implements VehicleService {

    private final VehicleDao vehicleDao;
    private final VehicleMapper vehicleMapper;
    private final MessageSourceAccessor messages;

    @Override
    public VehicleResponseDto addVehicle(VehicleRequestDto dto) throws VehicleException {
        auditor(dto);
        Vehicle saved = vehicleDao.save(vehicleMapper.toVehicle(dto));
        return vehicleMapper.toVehicleResponseDto(saved);
    }


    @Override
    public List<VehicleResponseDto> findAllVehicles() {
        List<Vehicle> vehicles = vehicleDao.findAll();
        return vehicles.stream()
                .map(vehicleMapper::toVehicleResponseDto)
                .toList();
    }

    @Override
    public VehicleResponseDto findById(int id) {
        Optional<Vehicle> optvehicle = vehicleDao.findById(id);
        if (optvehicle.isEmpty())
            throw new EntityNotFoundException(messages.getMessage("vehicle.id.notfound"));
        return vehicleMapper.toVehicleResponseDto(optvehicle.get());
    }

    @Override
    public void deleteVehicle(int id) throws VehicleException {
        Optional<Vehicle> optvehicle = vehicleDao.findById(id);
        if (optvehicle.isEmpty())
            throw new EntityNotFoundException(messages.getMessage("vehicle.id.notfound"));
        vehicleDao.delete(optvehicle.get());
        //TODO
//        if (carService.finByVehicle(optVehicle.get().getId()).isEmpty())
//            vehicleDao.delete(optvehicle.get());
//        else
//            throw new VehicleException(messages.getMessage("vehicle.car.existe"));
    }



    @Override
    public VehicleResponseDto updateVehicle(int idVehicle, VehicleRequestDto requestDto) {
        Optional<Vehicle> optvehicle = vehicleDao.findById(idVehicle);
        if (optvehicle.isEmpty())
            throw new EntityNotFoundException(messages.getMessage("vehicle.id.notfound"));

        auditor(requestDto);

        Vehicle vehicle = optvehicle.get();
        vehicle.setBrand(requestDto.brand());
        vehicle.setModel(requestDto.model());
        vehicle.setColor(requestDto.color());
        vehicle.setFuelType(requestDto.fuelType());
        vehicle.setDailyRate(requestDto.dailyRate());
        vehicle.getMileage();
        vehicle.getActive();
        vehicle.getParkRemove();
        vehicle.getRequiredPermit();
        return vehicleMapper.toVehicleResponseDto(vehicle);
    }

    public VehicleResponseDto updateVehiclePartially(int idVehicle, VehicleRequestDto requestDto) {
        Optional<Vehicle>optVehicle = vehicleDao.findById(idVehicle);
        if (optVehicle.isEmpty())
            throw new EntityNotFoundException(messages.getMessage("vehicle.id.notfound"));
        Vehicle vehicle = optVehicle.get();
        if (requestDto.brand() != null) throw new VehicleException(messages.getMessage("vehicle.brand.null"));

        if (requestDto.model() == null || requestDto.model().isBlank())
            throw new VehicleException(messages.getMessage("vehicle.model.null"));

        if (requestDto.color() == null || requestDto.color().isBlank())
            throw new VehicleException(messages.getMessage("vehicle.color.null"));

        if (requestDto.fuelType() == null)
            throw new VehicleException(messages.getMessage("vehicle.fueltype.null"));

        if (requestDto.dailyRate() == null)
            throw new VehicleException(messages.getMessage("vehicle.dailyrate.null"));
        if (requestDto.dailyRate() <= 0)
            throw new VehicleException(messages.getMessage("vehicle.dailyrate.min"));

        if (requestDto.mileage() == null)
            throw new VehicleException(messages.getMessage("vehicle.mileage.null"));
        if (requestDto.mileage() < 0)
            throw new VehicleException(messages.getMessage("vehicle.mileage.min"));

        if (requestDto.active() == null)
            throw new VehicleException(messages.getMessage("vehicle.active.null"));

        if (requestDto.parkRemove() == null)
            throw new VehicleException(messages.getMessage("vehicle.parkremove.null"));

        if (requestDto.requiredPermit() == null || requestDto.requiredPermit().isBlank())
            throw new VehicleException(messages.getMessage("vehicle.requiredpermit.null"));
        return vehicleMapper.toVehicleResponseDto(vehicle);
    }


    private void auditor(VehicleRequestDto dto) {
        if (dto == null)
            throw new VehicleException(messages.getMessage("vehicle.null"));

        if (dto.brand() == null || dto.brand().isBlank())
            throw new VehicleException(messages.getMessage("vehicle.brand.null"));

        if (dto.model() == null || dto.model().isBlank())
            throw new VehicleException(messages.getMessage("vehicle.model.null"));

        if (dto.color() == null || dto.color().isBlank())
            throw new VehicleException(messages.getMessage("vehicle.color.null"));

        if (dto.fuelType() == null)
            throw new VehicleException(messages.getMessage("vehicle.fueltype.null"));

        if (dto.dailyRate() == null)
            throw new VehicleException(messages.getMessage("vehicle.dailyrate.null"));
        if (dto.dailyRate() <= 0)
            throw new VehicleException(messages.getMessage("vehicle.dailyrate.min"));

        if (dto.mileage() == null)
            throw new VehicleException(messages.getMessage("vehicle.mileage.null"));
        if (dto.mileage() < 0)
            throw new VehicleException(messages.getMessage("vehicle.mileage.min"));

        if (dto.active() == null)
            throw new VehicleException(messages.getMessage("vehicle.active.null"));

        if (dto.parkRemove() == null)
            throw new VehicleException(messages.getMessage("vehicle.parkremove.null"));

        if (dto.requiredPermit() == null || dto.requiredPermit().isBlank())
            throw new VehicleException(messages.getMessage("vehicle.requiredpermit.null"));
    }

}


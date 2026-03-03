package com.accenture.applicationlocationvehicule.service;

import com.accenture.applicationlocationvehicule.exception.BikeException;
import com.accenture.applicationlocationvehicule.mapper.BikeMapper;
import com.accenture.applicationlocationvehicule.model.Bike;
import com.accenture.applicationlocationvehicule.repository.BikeDao;
import com.accenture.applicationlocationvehicule.service.dto.BikeRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.BikeResponseDto;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class BikeServiceImpl implements BikeService {

    private final BikeDao bikeDao;
    private final BikeMapper bikeMapper;
    private final MessageSourceAccessor messages;

    @Override
    public BikeResponseDto addBike(BikeRequestDto dto) {
        auditor(dto);
        Bike saved = bikeDao.save(bikeMapper.toBike(dto));
        return bikeMapper.toBikeResponseDto(saved);
    }

    @Override
    public List<BikeResponseDto> findAllBikes() {
        return bikeDao.findAll().stream()
                .map(bikeMapper::toBikeResponseDto)
                .toList();
    }

    @Override
    public BikeResponseDto findBikeById(int id) {
        Bike bike = bikeDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(messages.getMessage("bike.id.notfound")));

        return bikeMapper.toBikeResponseDto(bike);
    }

    @Override
    public void deleteBike(int id) {
        Bike bike = bikeDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(messages.getMessage("bike.id.notfound")));

        bikeDao.delete(bike);
    }

    @Override
    public BikeResponseDto updateBike(int id, BikeRequestDto dto) {
        Bike bike = bikeDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(messages.getMessage("bike.id.notfound")));

        auditor(dto);

        bike.setBrand(dto.brand());
        bike.setModel(dto.model());
        bike.setColor(dto.color());
        bike.setDailyRate(dto.dailyRate());
        bike.setMileage(dto.mileage());
        bike.setActive(dto.active());
        bike.setParkRemove(dto.parkRemove());
        bike.setLicences(dto.licences());
        bike.setWeight(dto.weight());
        bike.setFrameSize(dto.frameSize());
        bike.setElectric(dto.electric());
        bike.setCapacityBattery(dto.capacityBattery());
        bike.setAutonomy(dto.autonomy());
        bike.setDiscBrake(dto.discBrake());
        bike.setTypes(dto.types());


        return bikeMapper.toBikeResponseDto(bike);
    }

    @Override
    public BikeResponseDto updateBikePartially(int id, BikeRequestDto dto) {
        Bike bike = bikeDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(messages.getMessage("bike.id.notfound")));

        if (dto.brand() != null && !dto.brand().isBlank())
            bike.setBrand(dto.brand());

        if (dto.model() != null && !dto.model().isBlank())
            bike.setModel(dto.model());

        if (dto.color() != null && !dto.color().isBlank())
            bike.setColor(dto.color());

        if (dto.dailyRate() != null && dto.dailyRate() > 0)
            bike.setDailyRate(dto.dailyRate());

        if (dto.mileage() != null && dto.mileage() >= 0)
            bike.setMileage(dto.mileage());

        if (dto.active() != null)
            bike.setActive(dto.active());

        if (dto.parkRemove() != null)
            bike.setParkRemove(dto.parkRemove());

        if (dto.licences() != null)
            bike.setLicences(dto.licences());

        if (dto.weight() != null && dto.weight() > 0)
            bike.setWeight(dto.weight());

        if (dto.frameSize() != null && !dto.frameSize().isBlank())
            bike.setFrameSize(dto.frameSize());

        if (dto.electric() != null)
            bike.setElectric(dto.electric());

        if (dto.capacityBattery() != null && dto.capacityBattery() > 0)
            bike.setCapacityBattery(dto.capacityBattery());

        if (dto.autonomy() != null && dto.autonomy() > 0)
            bike.setAutonomy(dto.autonomy());

        if (dto.discBrake() != null)
            bike.setDiscBrake(dto.discBrake());

        if (dto.types() != null )
            bike.setTypes(dto.types());

        return bikeMapper.toBikeResponseDto(bike);
    }

    private void auditor(BikeRequestDto dto) {
        if (dto == null)
            throw new BikeException(messages.getMessage("bike.null"));

        if (dto.brand() == null || dto.brand().isBlank())
            throw new BikeException(messages.getMessage("bike.brand.null"));

        if (dto.model() == null || dto.model().isBlank())
            throw new BikeException(messages.getMessage("bike.model.null"));

        if (dto.color() == null || dto.color().isBlank())
            throw new BikeException(messages.getMessage("bike.color.null"));

        if (dto.dailyRate() == null)
            throw new BikeException(messages.getMessage("bike.dailyrate.null"));
        if (dto.dailyRate() <= 0)
            throw new BikeException(messages.getMessage("bike.dailyrate.min"));

        if (dto.mileage() == null)
            throw new BikeException(messages.getMessage("bike.mileage.null"));
        if (dto.mileage() < 0)
            throw new BikeException(messages.getMessage("bike.mileage.min"));

        if (dto.active() == null)
            throw new BikeException(messages.getMessage("bike.active.null"));

        if (dto.parkRemove() == null)
            throw new BikeException(messages.getMessage("bike.parkremove.null"));

        if (dto.licences() == null)
            throw new BikeException(messages.getMessage("bike.licences.null"));

        if (dto.weight() == null || dto.weight() <= 0)
            throw new BikeException(messages.getMessage("bike.weight.invalid"));

        if (dto.frameSize() == null || dto.frameSize().isBlank())
            throw new BikeException(messages.getMessage("bike.framesize.null"));

        if (dto.electric() == null)
            throw new BikeException(messages.getMessage("bike.electric.null"));

        if (dto.capacityBattery() == null || dto.capacityBattery() <= 0)
            throw new BikeException(messages.getMessage("bike.capacitybattery.invalid"));

        if (dto.autonomy() == null || dto.autonomy() <= 0)
            throw new BikeException(messages.getMessage("bike.autonomy.invalid"));

        if (dto.discBrake() == null)
            throw new BikeException(messages.getMessage("bike.discbrake.null"));

        if (dto.types() == null)
            throw new BikeException(messages.getMessage("bike.types.null"));

    }
}

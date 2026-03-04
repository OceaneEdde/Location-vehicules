package com.accenture.applicationlocationvehicule.service;

import com.accenture.applicationlocationvehicule.exception.BikeException;
import com.accenture.applicationlocationvehicule.mapper.BikeMapper;
import com.accenture.applicationlocationvehicule.model.Bike;
import com.accenture.applicationlocationvehicule.repository.BikeDao;
import com.accenture.applicationlocationvehicule.service.dto.BikeRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.BikeResponseDto;
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
                .orElseThrow(() -> new EntityNotFoundException(messages.getMessage(Messages.MESSAGES_ERROR_BIKE_NOTFOUND)));

        return bikeMapper.toBikeResponseDto(bike);
    }

    @Override
    public void deleteBike(int id) {
        Bike bike = bikeDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(messages.getMessage(Messages.MESSAGES_ERROR_BIKE_NOTFOUND)));

        bikeDao.delete(bike);
    }

    @Override
    public BikeResponseDto updateBike(int id, BikeRequestDto dto) {
        Bike bike = bikeDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(messages.getMessage(Messages.MESSAGES_ERROR_BIKE_NOTFOUND)));

        auditor(dto);

        applyFullUpdate(bike, dto);

        bikeDao.save(bike);

        return bikeMapper.toBikeResponseDto(bike);

    }


    @Override
    public BikeResponseDto updateBikePartially(int id, BikeRequestDto dto) {
        Bike bike = bikeDao.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException(messages.getMessage(Messages.MESSAGES_ERROR_BIKE_NOTFOUND)));

        applyPartiallyUpdate(bike, dto);

        bikeDao.save(bike);

        return bikeMapper.toBikeResponseDto(bike);

    }



    //  Sous-méthodes
    private void applyFullUpdate(Bike bike, BikeRequestDto dto) {
        bike.setBrand(dto.brand());
        bike.setModel(dto.model());
        bike.setColor(dto.color());
        bike.setDailyRate(dto.dailyRate());
        bike.setMileage(dto.mileage());
        bike.setActive(dto.active());
        bike.setParkRemove(dto.parkRemove());
        bike.setWeight(dto.weight());
        bike.setFrameSize(dto.frameSize());
        bike.setElectric(dto.electric());
        bike.setCapacityBattery(dto.capacityBattery());
        bike.setAutonomy(dto.autonomy());
        bike.setDiscBrake(dto.discBrake());
        bike.setTypes(dto.types());

    }

    private void applyPartiallyUpdate(Bike bike, BikeRequestDto dto) {
        if (dto.brand() != null && !dto.brand().isBlank()) bike.setBrand(dto.brand());
        if (dto.model() != null && !dto.model().isBlank()) bike.setModel(dto.model());
        if (dto.color() != null && !dto.color().isBlank()) bike.setColor(dto.color());
        if (dto.dailyRate() != null && dto.dailyRate() > 0) bike.setDailyRate(dto.dailyRate());
        if (dto.mileage() != null && dto.mileage() >= 0) bike.setMileage(dto.mileage());
        if (dto.active() != null) bike.setActive(dto.active());
        if (dto.parkRemove() != null) bike.setParkRemove(dto.parkRemove());
        if (dto.weight() != null && dto.weight() > 0) bike.setWeight(dto.weight());
        if (dto.frameSize() != null && !dto.frameSize().isBlank()) bike.setFrameSize(dto.frameSize());
        if (dto.electric() != null) bike.setElectric(dto.electric());
        if (dto.capacityBattery() != null && dto.capacityBattery() > 0) bike.setCapacityBattery(dto.capacityBattery());
        if (dto.autonomy() != null && dto.autonomy() > 0) bike.setAutonomy(dto.autonomy());
        if (dto.discBrake() != null) bike.setDiscBrake(dto.discBrake());
        if (dto.types() != null ) bike.setTypes(dto.types());

    }

    private void auditor(BikeRequestDto dto) {
        if (dto == null) throw new BikeException(messages.getMessage(Messages.MESSAGES_ERROR_BIKE_NULL));
        if (dto.brand() == null || dto.brand().isBlank()) throw new BikeException(messages.getMessage(Messages.MESSAGES_ERROR_BIKE_BRAND));
        if (dto.model() == null || dto.model().isBlank()) throw new BikeException(messages.getMessage(Messages.MESSAGES_ERROR_BIKE_MODEL));
        if (dto.color() == null || dto.color().isBlank()) throw new BikeException(messages.getMessage(Messages.MESSAGES_ERROR_BIKE_COLOR));
        if (dto.dailyRate() == null) throw new BikeException(messages.getMessage(Messages.MESSAGES_ERROR_BIKE_DAILYRATE_NULL));
        if (dto.dailyRate() <= 0) throw new BikeException(messages.getMessage(Messages.MESSAGES_ERROR_BIKE_DAILYRATE_MIN ));
        if (dto.mileage() == null) throw new BikeException(messages.getMessage(Messages.MESSAGES_ERROR_BIKE_MILEAGE_NULL));
        if (dto.mileage() < 0) throw new BikeException(messages.getMessage(Messages.MESSAGES_ERROR_BIKE_MILEAGE_MIN));
        if (dto.active() == null) throw new BikeException(messages.getMessage(Messages.MESSAGES_ERROR_BIKE_ACTIVE));
        if (dto.parkRemove() == null) throw new BikeException(messages.getMessage(Messages.MESSAGES_ERROR_BIKE_PARKREMOVE));
        if (dto.weight() == null || dto.weight() <= 0) throw new BikeException(messages.getMessage(Messages.MESSAGES_ERROR_BIKE_WEIGHT));
        if (dto.frameSize() == null || dto.frameSize().isBlank()) throw new BikeException(messages.getMessage(Messages.MESSAGES_ERROR_BIKE_FRAMESIZE));
        if (dto.electric() == null) throw new BikeException(messages.getMessage(Messages.MESSAGES_ERROR_BIKE_ELECTRIC));
        if (dto.capacityBattery() == null || dto.capacityBattery() <= 0) throw new BikeException(messages.getMessage(Messages.MESSAGES_ERROR_BIKE_CAPACITYBATTERY));
        if (dto.autonomy() == null || dto.autonomy() <= 0) throw new BikeException(messages.getMessage(Messages.MESSAGES_ERROR_BIKE_AUTONOMY));
        if (dto.discBrake() == null) throw new BikeException(messages.getMessage(Messages.MESSAGES_ERROR_BIKE_DISCBRAKE));
        if (dto.types() == null) throw new BikeException(messages.getMessage(Messages.MESSAGES_ERROR_BIKE_TYPES));

    }
}

package com.accenture.applicationlocationvehicule.service;

import com.accenture.applicationlocationvehicule.exception.CarException;
import com.accenture.applicationlocationvehicule.model.Car;
import com.accenture.applicationlocationvehicule.model.enums.FuelType;
import com.accenture.applicationlocationvehicule.model.enums.Licenses;
import com.accenture.applicationlocationvehicule.model.enums.Transmission;
import com.accenture.applicationlocationvehicule.model.enums.Types;
import com.accenture.applicationlocationvehicule.service.dto.CarRequestDto;
import com.accenture.applicationlocationvehicule.service.dto.CarResponseDto;
import com.accenture.applicationlocationvehicule.service.fake.FakeCarDao;
import com.accenture.applicationlocationvehicule.service.fake.FakeCarMapper;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.StaticMessageSource;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarServiceImplTest {
    private FakeCarDao carDao;
    private FakeCarMapper carMapper;
    private CarServiceImpl service;

    @BeforeEach
    void setup() {
        carDao = new FakeCarDao();
        carMapper = new FakeCarMapper();
        service = new CarServiceImpl(carDao, carMapper, messageAccessor());
    }

    @Test
    @DisplayName("addCar OK")
    void addCar_ok() {
        CarRequestDto req = new CarRequestDto("Peugeot", "308", "Bleu", FuelType.DIESEL, 49.90, 45200.0,
                true, false, Licenses.B, 5, 5, true, Transmission.AUTOMATIC, Types.CITY_CAR);

        CarResponseDto res = service.addCar(req);

        assertEquals("Peugeot", res.brand());
        assertEquals("308", res.model());
        assertEquals(1, carDao.store.size());
    }

    @Test
    @DisplayName("addCar null")
    void addCar_null() {
        assertThrows(CarException.class, () -> service.addCar(null));
    }


    @Test
    @DisplayName("findCarById not found")
    void findCarById_notfound() {
        assertThrows(EntityNotFoundException.class, () -> service.findCarById(99));
    }


    @Test
    @DisplayName("patchCar OK")
    void patchCarOk() {
        carDao.store.put(1, car(1, "OldBrand", "OldModel"));

        CarRequestDto req = new CarRequestDto(null, "NewModel", null, null, 0.0, 0.0,
                true, false, null, 0, 0, true, null, null);

        CarResponseDto res = service.updateCarPartially(1, req);

        assertEquals("OldBrand", res.brand());
        assertEquals("NewModel", res.model());
    }


    private Car car(int id, String brand, String model) {
        Car c = new Car();
        c.setId(id);
        c.setBrand(brand);
        c.setModel(model);
        return c;
    }

    private MessageSourceAccessor messageAccessor() {
        StaticMessageSource sms = new StaticMessageSource();
        sms.addMessage("car.id.notfound", Locale.getDefault(), "car.id.notfound");
        sms.addMessage("car.null", Locale.getDefault(), "car.null");
        sms.addMessage("car.brand", Locale.getDefault(), "car.brand");
        sms.addMessage("car.model", Locale.getDefault(), "car.model");
        return new MessageSourceAccessor(sms);
    }

}

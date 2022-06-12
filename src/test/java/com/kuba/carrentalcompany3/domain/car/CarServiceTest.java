package com.kuba.carrentalcompany3.domain.car;

import com.kuba.carrentalcompany3.domain.car.model.Car;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.car.entity.CarType;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.car.entity.DoorNumber;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.car.entity.FuelType;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.car.entity.GearboxType;
import com.kuba.config.junit.repository.CarRepositoryMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class CarServiceTest {
    private static final String BRAND = "Mercedes";
    private static final String MODEL = "EQE";
    private static final CarType CAR_TYPE = CarType.PASSENGER;
    private static final FuelType FUEL_TYPE = FuelType.PETROL;
    private static final GearboxType GEARBOX_TYPE = GearboxType.MANUAL;
    private static final DoorNumber DOOR_NUMBER = DoorNumber._3;
    private static final double BOOT_CAPACITY = 350;
    private static final String OFFICE_ID = "ASD123-QWZ098";

    private static final CarRepositoryMock repo = new CarRepositoryMock();
    private static final CarService carService = new CarService(repo);

    @BeforeEach
    void setUp() {
        repo.clean();
    }

    @Test
    public void shouldSetPassedCarData() {
        //when
        Car createdCar = carService.createCar(BRAND, MODEL, CAR_TYPE, FUEL_TYPE,GEARBOX_TYPE,DOOR_NUMBER,BOOT_CAPACITY,
                OFFICE_ID);

        //then
        assertTrue(Objects.nonNull(createdCar.getId()));
        assertFalse(createdCar.getId().isBlank());
        assertEquals(createdCar.getBrand(), BRAND);
        assertEquals(createdCar.getModel(), MODEL);
        assertEquals(createdCar.getCarType(), CAR_TYPE);
        assertEquals(createdCar.getFuelType(), FUEL_TYPE);
        assertEquals(createdCar.getGearboxType(), GEARBOX_TYPE);
        assertEquals(createdCar.getDoorNumber(), DOOR_NUMBER);
        assertEquals(createdCar.getBootCapacity(), BOOT_CAPACITY);
        assertEquals(createdCar.getOfficeId(), OFFICE_ID);
    }

    @Test
    void shouldThrowExceptionWhenBrandIsNull() {
        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> carService.createCar(null, MODEL, CAR_TYPE, FUEL_TYPE, GEARBOX_TYPE, DOOR_NUMBER,
                       BOOT_CAPACITY,OFFICE_ID));
        assertEquals("Pole z marką nie może być puste.", runtimeException.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenModelIsNull() {
        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> carService.createCar(BRAND, null, CAR_TYPE, FUEL_TYPE, GEARBOX_TYPE, DOOR_NUMBER,
                        BOOT_CAPACITY,OFFICE_ID));
        assertEquals("Pole z modelem nie może być puste.", runtimeException.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenCarTypeIsNull() {
        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> carService.createCar(BRAND, MODEL, null, FUEL_TYPE, GEARBOX_TYPE, DOOR_NUMBER,
                        BOOT_CAPACITY,OFFICE_ID));
        assertEquals("Pole z nadwoziem nie może być puste.", runtimeException.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenFuelIsNull() {
        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> carService.createCar(BRAND, MODEL, CAR_TYPE, null, GEARBOX_TYPE, DOOR_NUMBER,
                        BOOT_CAPACITY,OFFICE_ID));
        assertEquals("Pole z paliwem nie może być puste.", runtimeException.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenGearboxIsNull() {
        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> carService.createCar(BRAND, MODEL, CAR_TYPE, FUEL_TYPE, null, DOOR_NUMBER,
                        BOOT_CAPACITY,OFFICE_ID));
        assertEquals("Pole ze skrzynią biegów nie może być puste.", runtimeException.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenDoorIsNull() {
        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> carService.createCar(BRAND, MODEL, CAR_TYPE, FUEL_TYPE, GEARBOX_TYPE, null,
                        BOOT_CAPACITY,OFFICE_ID));
        assertEquals("Pole z liczbą drzwi nie może być puste.", runtimeException.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenBootCapacityIsNull() {
        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> carService.createCar(BRAND, MODEL, CAR_TYPE, FUEL_TYPE, GEARBOX_TYPE, DOOR_NUMBER,
                        null,OFFICE_ID));
        assertEquals("Pole z pojemnością bagarznika nie może być puste.", runtimeException.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenOfficeIdIsNull() {
        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> carService.createCar(BRAND, MODEL, CAR_TYPE, FUEL_TYPE, GEARBOX_TYPE, DOOR_NUMBER,
                        BOOT_CAPACITY,null));
        assertEquals("Pole z identyfikatorem biura nie może być puste.", runtimeException.getMessage());
    }
}
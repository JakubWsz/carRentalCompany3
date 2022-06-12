package com.kuba.carrentalcompany3.domain.car.validator;
import com.kuba.carrentalcompany3.domain.exception.CarExceptionCode;
import com.kuba.carrentalcompany3.domain.exception.DomainException;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.car.entity.CarType;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.car.entity.DoorNumber;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.car.entity.FuelType;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.car.entity.GearboxType;
import com.kuba.carrentalcompany3.lib.Assertion;

import com.kuba.carrentalcompany3.domain.car.model.Car;

public class CarValidator {
    public static void validateCar(Car car) {
        validateBrandIsNotNull(car.getBrand());
        validateModelIsNotNull(car.getModel());
        validateCarTypeIsNotNull(car.getCarType());
        validateFuelTypeIsNotNull(car.getFuelType());
        validateGearboxTypeIsNotNull(car.getGearboxType());
        validateDoorNumberIsNotNull(car.getDoorNumber());
        validateBootCapacityIsNotNull(car.getBootCapacity());
        validateOfficeIdIsNotNull(car.getOfficeId());
    }

    private static void validateBootCapacityIsNotNull(Double bootCapacity) {
        Assertion.notNull(bootCapacity, () -> new DomainException(
                CarExceptionCode.BOOT_CAPACITY_CANT_BE_NULL));
    }

    private static void validateDoorNumberIsNotNull(DoorNumber doorNumber) {
        Assertion.notNull(doorNumber, () -> new DomainException(
                CarExceptionCode.DOOR_NUMBER_TYPE_CANT_BE_NULL));
    }

    private static void validateGearboxTypeIsNotNull(GearboxType gearboxType) {
        Assertion.notNull(gearboxType, () -> new DomainException(
                CarExceptionCode.GEARBOX_TYPE_CANT_BE_NULL));
    }

    private static void validateFuelTypeIsNotNull(FuelType fuelType) {
        Assertion.notNull(fuelType, () -> new DomainException(
                CarExceptionCode.FUEL_TYPE_CANT_BE_NULL));
    }

    private static void validateCarTypeIsNotNull(CarType carType) {
        Assertion.notNull(carType, () -> new DomainException(
                CarExceptionCode.CAR_TYPE_CANT_BE_NULL));
    }

    private static void validateModelIsNotNull(String model) {
        Assertion.notNull(model, () -> new DomainException(
                CarExceptionCode.MODEL_CANT_BE_NULL));
        Assertion.notEmpty(model, () -> new DomainException(
                CarExceptionCode.MODEL_CANT_BE_NULL));
    }

    private static void validateBrandIsNotNull(String brand) {
        Assertion.notNull(brand, () -> new DomainException(
                CarExceptionCode.BRAND_CANT_BE_NULL));
        Assertion.notEmpty(brand, () -> new DomainException(
                CarExceptionCode.BRAND_CANT_BE_NULL));
    }

    private static void validateOfficeIdIsNotNull(String officeId) {
        Assertion.notNull(officeId, () -> new DomainException(
                CarExceptionCode.OFFICE_ID_CANT_BE_NULL));
        Assertion.notEmpty(officeId, () -> new DomainException(
                CarExceptionCode.OFFICE_ID_CANT_BE_NULL));
    }
}

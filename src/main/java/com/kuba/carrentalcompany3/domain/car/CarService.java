package com.kuba.carrentalcompany3.domain.car;

import com.kuba.carrentalcompany3.domain.car.model.Car;
import com.kuba.carrentalcompany3.domain.car.validator.CarValidator;
import com.kuba.carrentalcompany3.domain.exception.CarExceptionCode;
import com.kuba.carrentalcompany3.domain.exception.DomainException;
import com.kuba.carrentalcompany3.domain.exception.EmployeeExceptionCode;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.car.entity.CarType;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.car.entity.DoorNumber;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.car.entity.FuelType;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.car.entity.GearboxType;

import java.util.UUID;

public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car createCar(String brand, String model, CarType carType, FuelType fuelType,
                         GearboxType gearboxType, DoorNumber doorNumber, Double bootCapacity, String officeId) {
        Car car = new Car.CarBuilder()
                .setId(UUID.randomUUID().toString())
                .setRegistration(null)
                .setBrand(brand)
                .setModel(model)
                .setCarType(carType)
                .setFuelType(fuelType)
                .setGearboxType(gearboxType)
                .setDoorNumber(doorNumber)
                .setBootCapacity(bootCapacity)
                .setOfficeId(officeId)
                .build();
        CarValidator.validateCar(car);
        return carRepository.save(car);
    }

    public void removeCar(String domainId) {
        Car car = getCar(domainId);
        car.markAsDeleted();
        carRepository.update(car);
    }

    private Car getCar(String domainId) {
        Car car = carRepository.getCar(domainId)
                .orElseThrow(() -> new DomainException(EmployeeExceptionCode.EMPLOYEE_DOESNT_EXISTS));
        isEmployeeRemovedValidator(car.isDeleted());
        return car;
    }

    private void isEmployeeRemovedValidator(boolean deleted) {
        if (deleted) {
            throw new DomainException(EmployeeExceptionCode.EMPLOYEE_ALREADY_DELETED);
        }
    }
}

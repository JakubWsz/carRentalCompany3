package com.kuba.carrentalcompany3.infrastructure.converter.car.jpa;

import com.kuba.carrentalcompany3.domain.car.model.Car;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.car.entity.CarDAO;
import org.springframework.core.convert.converter.Converter;

public class CarToCarDAO implements Converter<Car, CarDAO> {
    @Override
    public CarDAO convert(Car car) {
        return new CarDAO(
                car.isDeleted(),
                car.getId(),
                car.getRegistration(),
                car.getBrand(),
                car.getModel(),
                car.getCarType(),
                car.getFuelType(),
                car.getGearboxType(),
                car.getDoorNumber(),
                car.getBootCapacity(),
                car.getOfficeId()
        );
    }
}

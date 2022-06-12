package com.kuba.carrentalcompany3.infrastructure.converter.car.jpa;

import com.kuba.carrentalcompany3.domain.car.model.Car;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.car.entity.CarDAO;
import org.springframework.core.convert.converter.Converter;

public class CarDAOToCar implements Converter<CarDAO, Car>{
    @Override
    public Car convert(CarDAO carDAO) {
        return new Car.CarBuilder()
                .setId(carDAO.getDomainId())
                .setRegistration(carDAO.getRegistration())
                .setBrand(carDAO.getBrand())
                .setModel(carDAO.getModel())
                .setCarType(carDAO.getCarType())
                .setFuelType(carDAO.getFuelType())
                .setGearboxType(carDAO.getGearboxType())
                .setDoorNumber(carDAO.getDoorNumber())
                .setBootCapacity(carDAO.getBootCapacity())
                .setOfficeId(carDAO.getOfficeId())
                .setDeleted(carDAO.isDeleted())
                .build();
    }
}

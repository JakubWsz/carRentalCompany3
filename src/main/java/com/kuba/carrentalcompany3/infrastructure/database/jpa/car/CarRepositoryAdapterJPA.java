package com.kuba.carrentalcompany3.infrastructure.database.jpa.car;

import com.kuba.carrentalcompany3.domain.car.CarRepository;
import com.kuba.carrentalcompany3.domain.car.model.Car;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.car.entity.CarDAO;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.client.entity.ClientDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.ConversionService;

import java.time.LocalDateTime;
import java.util.Optional;

public class CarRepositoryAdapterJPA implements CarRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(CarRepositoryAdapterJPA.class);
    private final CarRepositoryJPA carRepositoryJPA;
    private final ConversionService conversionService;

    public CarRepositoryAdapterJPA(CarRepositoryJPA carRepositoryJPA, ConversionService conversionService) {
        this.carRepositoryJPA = carRepositoryJPA;
        this.conversionService = conversionService;
    }

    @Override
    public Car save(Car car) {
        CarDAO carDAO = carRepositoryJPA.save(conversionService.convert(car, CarDAO.class));
        return conversionService.convert(carDAO, Car.class);
    }

    @Override
    public void update(Car car) {
        Optional<CarDAO> carDaoOptional = carRepositoryJPA.findByDomainId(car.getId());

        if (carDaoOptional.isPresent() ){
            CarDAO carDAO = conversionService.convert(car, CarDAO.class);
            carDAO.assignIdForUpdatingObject(carDaoOptional.get());
            carDAO.setModificationDate(LocalDateTime.now());
            carRepositoryJPA.save(carDAO);
        }
    }

    @Override
    public Optional<Car> getCar(String domainId) {
        try {
            Optional<CarDAO> CarDaoOptional = carRepositoryJPA.findByDomainId(domainId);
            return Optional.ofNullable(conversionService.convert(CarDaoOptional.get(), Car.class));
        } catch (Exception e) {
            LOGGER.error("getCar error occurred", e);
            return Optional.empty();
        }
    }
}

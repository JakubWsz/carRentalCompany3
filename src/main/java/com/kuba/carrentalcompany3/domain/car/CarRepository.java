package com.kuba.carrentalcompany3.domain.car;

import com.kuba.carrentalcompany3.domain.car.model.Car;

import java.util.Optional;

public interface CarRepository {
    Car save(Car car);
    void update(Car car);
    Optional<Car> getCar(String id);
}

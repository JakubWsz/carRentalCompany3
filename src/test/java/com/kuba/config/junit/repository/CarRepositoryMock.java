package com.kuba.config.junit.repository;

import com.kuba.carrentalcompany3.domain.car.CarRepository;
import com.kuba.carrentalcompany3.domain.car.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CarRepositoryMock implements CarRepository {
    List<Car>cars = new ArrayList<>();

    @Override
    public Car save(Car car) {
        cars.add(car);
        return car;
    }

    @Override
    public void update(Car car) {
    save(car);
    }

    @Override
    public Optional<Car> getCar(String id) {
         return cars.stream()
                .filter(car -> car.getRegistration().equals(id))
                .findAny();
    }

    public void clean() {
        cars.clear();
    }
}

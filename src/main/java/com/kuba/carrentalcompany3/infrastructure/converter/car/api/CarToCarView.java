package com.kuba.carrentalcompany3.infrastructure.converter.car.api;

import com.kuba.carrentalcompany3.api.dto.car.CarView;
import com.kuba.carrentalcompany3.domain.car.model.Car;
import org.springframework.core.convert.converter.Converter;

public class CarToCarView implements Converter<Car, CarView> {
    @Override
    public CarView convert(Car car) {
        return new CarView(
                car.getBrand(),
                car.getModel(),
                car.getCarType(),
                car.getFuelType(),
                car.getGearboxType(),
                car.getDoorNumber(),
                car.getBootCapacity()
        );
    }
}

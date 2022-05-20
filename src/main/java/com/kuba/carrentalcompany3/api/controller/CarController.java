package com.kuba.carrentalcompany3.api.controller;

import com.kuba.carrentalcompany3.api.dto.car.CarView;
import com.kuba.carrentalcompany3.api.dto.car.CreateCarRequest;
import com.kuba.carrentalcompany3.api.dto.client.ClientView;
import com.kuba.carrentalcompany3.api.dto.client.CreateClientRequest;
import com.kuba.carrentalcompany3.domain.car.CarService;
import com.kuba.carrentalcompany3.domain.car.model.Car;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
public class CarController {
    private final ConversionService conversionService;
    private final CarService carService;

    public CarController(ConversionService conversionService, CarService carService) {
        this.conversionService = conversionService;
        this.carService = carService;
    }

    @PostMapping("/create")
    public ResponseEntity<CarView> createAccount(@RequestBody CreateCarRequest createCarRequest) {
        Car car = carService.createCar(
                createCarRequest.getBrand(),
                createCarRequest.getModel(),
                createCarRequest.getCarType(),
                createCarRequest.getFuelType(),
                createCarRequest.getGearboxType(),
                createCarRequest.getDoorNumber(),
                createCarRequest.getBootCapacity());
        return new ResponseEntity<>(conversionService.convert(car, CarView.class), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}/remove")
    public void removeCar(@PathVariable String id) {
        carService.removeCar(id);
    }
}

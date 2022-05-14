package com.kuba.carrentalcompany3.api.dto.car;

import com.kuba.carrentalcompany3.infrastructure.database.jpa.car.entity.CarType;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.car.entity.FuelType;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.car.entity.GearboxType;

public class CarView {
    private final String brand;
    private final String model;
    private final CarType carType;
    private final FuelType fuelType;
    private final GearboxType gearboxType;
    private final int doorNumber;
    private final int bootCapacity;

    public CarView(String brand, String model, CarType carType,
                   FuelType fuelType, GearboxType gearboxType, int doorNumber, int bootCapacity) {
        this.brand = brand;
        this.model = model;
        this.carType = carType;
        this.fuelType = fuelType;
        this.gearboxType = gearboxType;
        this.doorNumber = doorNumber;
        this.bootCapacity = bootCapacity;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public CarType getCarType() {
        return carType;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public GearboxType getGearboxType() {
        return gearboxType;
    }

    public int getDoorNumber() {
        return doorNumber;
    }

    public int getBootCapacity() {
        return bootCapacity;
    }
}

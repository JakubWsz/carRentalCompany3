package com.kuba.carrentalcompany3.api.dto.car;

import com.kuba.carrentalcompany3.infrastructure.database.jpa.car.entity.CarType;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.car.entity.FuelType;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.car.entity.GearboxType;

public class CreateCarRequest {
    private final String brand;
    private final String model;
    private final CarType carType;
    private final FuelType fuelType;
    private final GearboxType gearboxType;
    private final int doorNumber;
    private final int bootCapacity;
    private final String officeId;

    public CreateCarRequest(String brand, String model, CarType carType, FuelType fuelType,
                            GearboxType gearboxType, int doorNumber, int bootCapacity, String officeId) {
        this.brand = brand;
        this.model = model;
        this.carType = carType;
        this.fuelType = fuelType;
        this.gearboxType = gearboxType;
        this.doorNumber = doorNumber;
        this.bootCapacity = bootCapacity;
        this.officeId = officeId;
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

    public String getOfficeId() {
        return officeId;
    }
}

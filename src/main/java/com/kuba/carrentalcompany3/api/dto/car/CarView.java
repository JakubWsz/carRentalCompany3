package com.kuba.carrentalcompany3.api.dto.car;

import com.kuba.carrentalcompany3.infrastructure.database.jpa.car.entity.CarType;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.car.entity.DoorNumber;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.car.entity.FuelType;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.car.entity.GearboxType;

public class CarView {
    private final String id;
    private final String registration;
    private final String brand;
    private final String model;
    private final CarType carType;
    private final FuelType fuelType;
    private final GearboxType gearboxType;
    private final DoorNumber doorNumber;
    private final double bootCapacity;
    private final String officeId;

    public CarView(String id, String registration, String brand, String model, CarType carType, FuelType fuelType,
                   GearboxType gearboxType, DoorNumber doorNumber, double bootCapacity, String officeId) {
        this.id = id;
        this.registration = registration;
        this.brand = brand;
        this.model = model;
        this.carType = carType;
        this.fuelType = fuelType;
        this.gearboxType = gearboxType;
        this.doorNumber = doorNumber;
        this.bootCapacity = bootCapacity;
        this.officeId = officeId;
    }

    public String getId() {
        return id;
    }

    public String getRegistration() {
        return registration;
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

    public DoorNumber getDoorNumber() {
        return doorNumber;
    }

    public double getBootCapacity() {
        return bootCapacity;
    }

    public String getOfficeId() {return officeId;}
}

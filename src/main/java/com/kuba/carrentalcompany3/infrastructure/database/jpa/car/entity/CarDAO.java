package com.kuba.carrentalcompany3.infrastructure.database.jpa.car.entity;

import com.kuba.carrentalcompany3.infrastructure.database.jpa.BaseEntity;

import javax.persistence.Entity;

@Entity
public class CarDAO extends BaseEntity {
    private String domainId;
    private String brand;
    private String model;
    private CarType carType;
    private FuelType fuelType;
    private GearboxType gearboxType;
    private int doorNumber;
    private int bootCapacity;
    private String officeId;

    public CarDAO() {
    }

    public CarDAO(String domainId, String brand, String model, CarType carType, FuelType fuelType,
                  GearboxType gearboxType, int doorNumber, int bootCapacity, String officeId) {
        this.domainId = domainId;
        this.brand = brand;
        this.model = model;
        this.carType = carType;
        this.fuelType = fuelType;
        this.gearboxType = gearboxType;
        this.doorNumber = doorNumber;
        this.bootCapacity = bootCapacity;
        this.officeId = officeId;
    }

    public String getDomainId() {
        return domainId;
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

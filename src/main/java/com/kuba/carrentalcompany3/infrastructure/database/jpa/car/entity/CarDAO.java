package com.kuba.carrentalcompany3.infrastructure.database.jpa.car.entity;

import com.kuba.carrentalcompany3.infrastructure.database.jpa.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class CarDAO extends BaseEntity {
    @Column(unique = true)
    private String domainId;
    @Column(unique = true)
    private String registration;
    private String brand;
    private String model;
    private CarType carType;
    private FuelType fuelType;
    private GearboxType gearboxType;
    private DoorNumber doorNumber;
    private Double bootCapacity;
    private String officeId;

    public CarDAO() {
    }

    public CarDAO(boolean deleted, String domainId, String registration, String brand, String model, CarType carType,
                  FuelType fuelType, GearboxType gearboxType, DoorNumber doorNumber, Double bootCapacity,
                  String officeId) {
        this.setDeleted(deleted);
        this.domainId = domainId;
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

    public DoorNumber getDoorNumber() {
        return doorNumber;
    }

    public Double getBootCapacity() {
        return bootCapacity;
    }

    public String getOfficeId() {
        return officeId;
    }

    public String getRegistration() {
        return registration;
    }
}

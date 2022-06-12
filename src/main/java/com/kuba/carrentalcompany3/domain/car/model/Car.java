package com.kuba.carrentalcompany3.domain.car.model;

import com.kuba.carrentalcompany3.infrastructure.database.jpa.car.entity.CarType;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.car.entity.DoorNumber;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.car.entity.FuelType;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.car.entity.GearboxType;

public class Car {
    private final String id;
    private final String registration;
    private final String brand;
    private final String model;
    private final CarType carType;
    private final FuelType fuelType;
    private final GearboxType gearboxType;
    private final DoorNumber doorNumber;
    private final Double bootCapacity;
    private final String officeId;
    private boolean deleted;

    private Car(String id, String registration, String brand, String model, CarType carType, FuelType fuelType,
                GearboxType gearboxType, DoorNumber doorNumber, Double bootCapacity, String officeId, boolean deleted) {
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
        this.deleted = deleted;
    }

    public static class CarBuilder {
        private String id;
        private String registration;
        private String brand;
        private String model;
        private CarType carType;
        private FuelType fuelType;
        private GearboxType gearboxType;
        private DoorNumber doorNumber;
        private Double bootCapacity;
        private String officeId;
        private boolean deleted;

        public CarBuilder setRegistration(String registration) {
            this.registration = registration;
            return this;
        }

        public CarBuilder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public CarBuilder setModel(String model) {
            this.model = model;
            return this;
        }

        public CarBuilder setCarType(CarType carType) {
            this.carType = carType;
            return this;
        }

        public CarBuilder setFuelType(FuelType fuelType) {
            this.fuelType = fuelType;
            return this;
        }

        public CarBuilder setGearboxType(GearboxType gearboxType) {
            this.gearboxType = gearboxType;
            return this;
        }

        public CarBuilder setDoorNumber(DoorNumber doorNumber) {
            this.doorNumber = doorNumber;
            return this;
        }

        public CarBuilder setBootCapacity(Double bootCapacity) {
            this.bootCapacity = bootCapacity;
            return this;
        }

        public CarBuilder setOfficeId(String officeId) {
            this.officeId = officeId;
            return this;
        }

        public CarBuilder setDeleted(boolean deleted) {
            this.deleted = deleted;
            return this;
        }

        public CarBuilder setId(String id) {
            this.id = id;
            return this;
        }

        public Car build() {
            return new Car(id, registration, brand, model, carType, fuelType, gearboxType, doorNumber, bootCapacity,
                    officeId, deleted);
        }
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

    public Double getBootCapacity() {
        return bootCapacity;
    }

    public String getOfficeId() {
        return officeId;
    }

    public String getId() {
        return id;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void markAsDeleted() {
        deleted = true;
    }
}

package com.kuba.carrentalcompany3.domain.car.model;

import com.kuba.carrentalcompany3.infrastructure.database.jpa.car.entity.CarType;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.car.entity.FuelType;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.car.entity.GearboxType;

public class Car {
    private String id;
    private String brand;
    private String model;
    private CarType carType;
    private FuelType fuelType;
    private GearboxType gearboxType;
    private int doorNumber;
    private int bootCapacity;
    private String officeId;
    private boolean deleted;

    private Car(String id, String brand, String model, CarType carType, FuelType fuelType,
                GearboxType gearboxType, int doorNumber, int bootCapacity, String officeId) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.carType = carType;
        this.fuelType = fuelType;
        this.gearboxType = gearboxType;
        this.doorNumber = doorNumber;
        this.bootCapacity = bootCapacity;
        this.officeId = officeId;
        this.deleted = false;
    }

    public static class CarBuilder {
        private String domainId;
        private String brand;
        private String model;
        private CarType carType;
        private FuelType fuelType;
        private GearboxType gearboxType;
        private int doorNumber;
        private int bootCapacity;
        private String officeId;

        public CarBuilder setDomainId(String domainId) {
            this.domainId = domainId;
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

        public CarBuilder setDoorNumber(int doorNumber) {
            this.doorNumber = doorNumber;
            return this;
        }

        public CarBuilder setBootCapacity(int bootCapacity) {
            this.bootCapacity = bootCapacity;
            return this;
        }

        public CarBuilder setOfficeId(String officeId) {
            this.officeId = officeId;
            return this;
        }

        public Car build() {
            return new Car(domainId, brand, model, carType, fuelType, gearboxType, doorNumber, bootCapacity, officeId);
        }
    }

    public String getId() {
        return id;
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

    public void setId(String id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public void setGearboxType(GearboxType gearboxType) {
        this.gearboxType = gearboxType;
    }

    public void setDoorNumber(int doorNumber) {
        this.doorNumber = doorNumber;
    }

    public void setBootCapacity(int bootCapacity) {
        this.bootCapacity = bootCapacity;
    }

    public void setOfficeId(String officeId) {
        this.officeId = officeId;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void markAsDeleted() {
        deleted = true;
    }
}

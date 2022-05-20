package com.kuba.carrentalcompany3.infrastructure.database.jpa;

import javax.persistence.Embeddable;

@Embeddable
public class AddressDAO {
    private String streetAddress;
    private String postalCode;
    private String cityName;

    public AddressDAO(String streetAddress, String postalCode, String cityName) {
        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
        this.cityName = cityName;
    }

    public AddressDAO() {

    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}

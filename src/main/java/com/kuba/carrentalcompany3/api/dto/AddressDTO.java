package com.kuba.carrentalcompany3.api.dto;

public class AddressDTO {
    private final String streetAddress;
    private final String postalCode;
    private final String cityName;

    public AddressDTO(String streetAddress, String postalCode, String cityName) {
        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
        this.cityName = cityName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCityName() {
        return cityName;
    }
}

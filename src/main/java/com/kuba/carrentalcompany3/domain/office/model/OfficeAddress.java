package com.kuba.carrentalcompany3.domain.office.model;

public class OfficeAddress {
    private final String officeStreetAddress;
    private final String officePostalCode;
    private final String officeCityName;

    public OfficeAddress(String officeStreetAddress, String officePostalCode, String officeCityName) {
        this.officeStreetAddress = officeStreetAddress;
        this.officePostalCode = officePostalCode;
        this.officeCityName = officeCityName;
    }

    public String getOfficeStreetAddress() {
        return officeStreetAddress;
    }

    public String getOfficePostalCode() {
        return officePostalCode;
    }

    public String getOfficeCityName() {
        return officeCityName;
    }
}
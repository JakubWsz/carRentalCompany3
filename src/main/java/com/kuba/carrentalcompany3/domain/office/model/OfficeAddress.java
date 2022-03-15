package com.kuba.carrentalcompany3.domain.office.model;

public class OfficeAddress {
    private final String officeStreetAddress;
    private final String officeCityCode;
    private final String officeCityName;

    public OfficeAddress(String officeStreetAddress, String officeCityCode, String officeCityName) {
        this.officeStreetAddress = officeStreetAddress;
        this.officeCityCode = officeCityCode;
        this.officeCityName = officeCityName;
    }

    public String getOfficeStreetAddress() {
        return officeStreetAddress;
    }

    public String getOfficeCityCode() {
        return officeCityCode;
    }

    public String getOfficeCityName() {
        return officeCityName;
    }
}

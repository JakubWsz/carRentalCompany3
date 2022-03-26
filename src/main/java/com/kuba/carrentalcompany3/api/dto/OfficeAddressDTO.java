package com.kuba.carrentalcompany3.api.dto;

public class OfficeAddressDTO {
    private final String officeStreetAddress;
    private final String officePostalCode;
    private final String officeCityName;

    public OfficeAddressDTO(String officeStreetAddress, String officeCityCode, String officeCityName) {
        this.officeStreetAddress = officeStreetAddress;
        this.officePostalCode = officeCityCode;
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

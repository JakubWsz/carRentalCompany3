package com.kuba.carrentalcompany3.infrastructure.database.jpa.office.entity;

import javax.persistence.Embeddable;

@Embeddable
public class OfficeAddressDAO {
    private String officeStreetAddress;
    private String officePostalCode;
    private String officeCityName;

    public OfficeAddressDAO() {
    }

    public OfficeAddressDAO(String officeStreetAddress, String officePostalCode, String officeCityName) {
        this.officeStreetAddress = officeStreetAddress;
        this.officePostalCode = officePostalCode;
        this.officeCityName = officeCityName;
    }

    public String getOfficeStreetAddress() {
        return officeStreetAddress;
    }

    public void setOfficeStreetAddress(String officeStreetAddress) {
        this.officeStreetAddress = officeStreetAddress;
    }

    public String getOfficePostalCode() {
        return officePostalCode;
    }

    public void setOfficePostalCode(String officeCityCode) {
        this.officePostalCode = officeCityCode;
    }

    public String getOfficeCityName() {
        return officeCityName;
    }

    public void setOfficeCityName(String officeCityName) {
        this.officeCityName = officeCityName;
    }
}

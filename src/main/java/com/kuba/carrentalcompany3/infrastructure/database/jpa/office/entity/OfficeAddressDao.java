package com.kuba.carrentalcompany3.infrastructure.database.jpa.office.entity;

import javax.persistence.Embeddable;

@Embeddable
public class OfficeAddressDao {
    private String officeStreetAddress;
    private String officeCityCode;
    private String officeCityName;

    public String getOfficeStreetAddress() {
        return officeStreetAddress;
    }

    public void setOfficeStreetAddress(String officeStreetAddress) {
        this.officeStreetAddress = officeStreetAddress;
    }

    public String getOfficeCityCode() {
        return officeCityCode;
    }

    public void setOfficeCityCode(String officeCityCode) {
        this.officeCityCode = officeCityCode;
    }

    public String getOfficeCityName() {
        return officeCityName;
    }

    public void setOfficeCityName(String officeCityName) {
        this.officeCityName = officeCityName;
    }
}

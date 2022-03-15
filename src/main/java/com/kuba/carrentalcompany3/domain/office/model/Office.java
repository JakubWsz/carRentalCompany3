package com.kuba.carrentalcompany3.domain.office.model;

public class Office {
    private final String id;
    private final OfficeAddress officeAddress;
    private final String websiteURL;
    private final String officeCEO;

    public Office(String id, OfficeAddress officeAddress, String websiteURL, String officeCEO) {
        this.id = id;
        this.officeAddress = officeAddress;
        this.websiteURL = websiteURL;
        this.officeCEO = officeCEO;
    }

    public String getId() {
        return id;
    }

    public OfficeAddress getOfficeAddress() {
        return officeAddress;
    }

    public String getWebsiteURL() {
        return websiteURL;
    }

    public String getOfficeCEO() {
        return officeCEO;
    }
}

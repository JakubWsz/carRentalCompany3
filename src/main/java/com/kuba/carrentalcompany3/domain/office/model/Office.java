package com.kuba.carrentalcompany3.domain.office.model;

public class Office {
    private final String id;
    private final OfficeAddress officeAddress;
    private final String websiteURL;
    private final String officeCEO;
    private boolean deleted;

    public Office(String id, OfficeAddress officeAddress, String websiteURL, String officeCEO, boolean deleted) {
        this.id = id;
        this.officeAddress = officeAddress;
        this.websiteURL = websiteURL;
        this.officeCEO = officeCEO;
        this.deleted = deleted;
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

    public boolean isDeleted() {
        return deleted;
    }

    public void markAsDelete() {
        deleted = true;
    }


}

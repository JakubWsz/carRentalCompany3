package com.kuba.carrentalcompany3.infrastructure.database.jpa.office.entity;

import com.kuba.carrentalcompany3.infrastructure.database.jpa.BaseEntity;

import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
public class OfficeDAO extends BaseEntity {
    private String domainId;
    @Embedded
    private OfficeAddressDAO officeAddress;
    private String websiteURL;
    private String officeCEO;


    public OfficeDAO(String domainId, OfficeAddressDAO officeAddress, String websiteURL, String officeCEO) {
        this.domainId = domainId;
        this.officeAddress = officeAddress;
        this.websiteURL = websiteURL;
        this.officeCEO = officeCEO;
    }

    public OfficeDAO(String domainId, OfficeAddressDAO officeAddress, String websiteURL, String officeCEO,
                     boolean deleted) {
        this.domainId = domainId;
        this.officeAddress = officeAddress;
        this.websiteURL = websiteURL;
        this.officeCEO = officeCEO;
        this.setDeleted(deleted);
    }

    public OfficeDAO() {
    }

    public String getDomainId() {
        return domainId;
    }

    public OfficeAddressDAO getOfficeAddress() {
        return officeAddress;
    }

    public String getWebsiteURL() {
        return websiteURL;
    }

    public String getOfficeCEO() {
        return officeCEO;
    }

}

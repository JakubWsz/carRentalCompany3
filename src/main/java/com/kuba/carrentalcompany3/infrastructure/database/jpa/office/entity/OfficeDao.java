package com.kuba.carrentalcompany3.infrastructure.database.jpa.office.entity;

import com.kuba.carrentalcompany3.domain.office.model.OfficeAddress;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.BaseEntity;

import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
public class OfficeDao extends BaseEntity {
    private String domainId;
    @Embedded
    private OfficeAddressDao officeAddress;
    private String websiteURL;
    private String officeCEO;

    public OfficeDao(String domainId, OfficeAddressDao officeAddress, String websiteURL, String officeCEO) {
        this.domainId = domainId;
        this.officeAddress = officeAddress;
        this.websiteURL = websiteURL;
        this.officeCEO = officeCEO;
    }

    public OfficeDao() {
    }

    public String getDomainId() {
        return domainId;
    }

    public OfficeAddressDao getOfficeAddress() {
        return officeAddress;
    }

    public String getWebsiteURL() {
        return websiteURL;
    }

    public String getOfficeCEO() {
        return officeCEO;
    }
}

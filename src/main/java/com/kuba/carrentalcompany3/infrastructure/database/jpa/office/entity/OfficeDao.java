package com.kuba.carrentalcompany3.infrastructure.database.jpa.office.entity;

import com.kuba.carrentalcompany3.infrastructure.database.jpa.BaseEntity;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.employee.entity.EmployeeDao;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
public class OfficeDao extends BaseEntity {
    private String domainId;
    @Embedded
    private OfficeAddressDao officeAddress;
    private String websiteURL;
    private String officeCEO;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<EmployeeDao> employeeDaoList;

    public OfficeDao(String domainId, OfficeAddressDao officeAddress, String websiteURL, String officeCEO) {
        this.domainId = domainId;
        this.officeAddress = officeAddress;
        this.websiteURL = websiteURL;
        this.officeCEO = officeCEO;
    }

    public OfficeDao(String domainId, OfficeAddressDao officeAddress, String websiteURL, String officeCEO,
                     boolean deleted) {
        this.domainId = domainId;
        this.officeAddress = officeAddress;
        this.websiteURL = websiteURL;
        this.officeCEO = officeCEO;
        this.setDeleted(deleted);
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

    public List<EmployeeDao> getEmployeeDaoList() {
        return employeeDaoList;
    }
}

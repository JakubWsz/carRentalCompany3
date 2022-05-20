package com.kuba.carrentalcompany3.infrastructure.database.jpa.employee.entity;

import com.kuba.carrentalcompany3.infrastructure.database.jpa.AddressDAO;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.BaseEntity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Entity
public class EmployeeDAO extends BaseEntity {
    private String domainId;
    private String firstname;
    private String lastname;
    @Embedded
    private AddressDAO address;
    private String pesel;
    private String accountNumber;
    private BigDecimal salaryAmount;
    @Enumerated(EnumType.STRING)
    private ContractType contractType;
    private String position;
    private String officeId;

    public EmployeeDAO() {
    }

    public EmployeeDAO(boolean deleted, String domainId, String firstname, String lastname, AddressDAO address,
                       String pesel, String accountNumber, BigDecimal salaryAmount, ContractType contractType,
                       String position, String officeId) {
        this.setDeleted(deleted);
        this.domainId = domainId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.pesel = pesel;
        this.accountNumber = accountNumber;
        this.salaryAmount = salaryAmount;
        this.contractType = contractType;
        this.position = position;
        this.officeId = officeId;
    }

    public String getDomainId() {
        return domainId;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public AddressDAO getAddress() {
        return address;
    }

    public String getPesel() {
        return pesel;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getSalaryAmount() {
        return salaryAmount;
    }

    public ContractType getContractType() {
        return contractType;
    }

    public String getPosition() {
        return position;
    }

    public String getOfficeId() {
        return officeId;
    }

}


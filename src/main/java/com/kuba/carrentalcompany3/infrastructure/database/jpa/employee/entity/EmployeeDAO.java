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

    public EmployeeDAO(String domainId, String firstname, String lastname, AddressDAO address, String pesel,
                       String accountNumber, BigDecimal salaryAmount, ContractType contractType, String position,
                       String officeId) {
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

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public AddressDAO getAddress() {
        return address;
    }

    public void setAddress(AddressDAO address) {
        this.address = address;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getSalaryAmount() {
        return salaryAmount;
    }

    public void setSalaryAmount(BigDecimal salaryAmount) {
        this.salaryAmount = salaryAmount;
    }

    public ContractType getContractType() {
        return contractType;
    }

    public void setContractType(ContractType typeOfContract) {
        this.contractType = typeOfContract;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getOfficeId() {
        return officeId;
    }

    public void setOfficeId(String officeId) {
        this.officeId = officeId;
    }
}


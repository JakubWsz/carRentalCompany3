package com.kuba.carrentalcompany3.domain.employee.model;

import com.kuba.carrentalcompany3.domain.Address;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.employee.entity.ContractType;

import java.math.BigDecimal;

public class Employee {
    private String id;
    private String firstname;
    private String lastname;
    private Address address;
    private String pesel;
    private String accountNumber;
    private BigDecimal salaryAmount;
    private ContractType contractType;
    private String position;
    private String officeId;
    private boolean deleted;

    public Employee() {
    }

    private Employee(String id, String firstname, String lastname, Address address, String pesel,
            String accountNumber, BigDecimal salaryAmount, ContractType contractType, String position,
            String officeId, boolean deleted) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.pesel = pesel;
        this.accountNumber = accountNumber;
        this.salaryAmount = salaryAmount;
        this.contractType = contractType;
        this.position = position;
        this.officeId = officeId;
        this.deleted = deleted;
    }

    public static class EmployeeBuilder {
        private String id;
        private String firstname;
        private String lastname;
        private Address address;
        private String pesel;
        private String accountNumber;
        private BigDecimal salaryAmount;
        private ContractType contractType;
        private String position;
        private String officeId;
        private boolean deleted;

        public EmployeeBuilder setId(String id) {
            this.id = id;
            return this;
        }

        public EmployeeBuilder setFirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public EmployeeBuilder setLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public EmployeeBuilder setAddress(Address address) {
            this.address = address;
            return this;
        }

        public EmployeeBuilder setPesel(String pesel) {
            this.pesel = pesel;
            return this;
        }

        public EmployeeBuilder setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public EmployeeBuilder setSalaryAmount(BigDecimal salaryAmount) {
            this.salaryAmount = salaryAmount;
            return this;
        }

        public EmployeeBuilder setTypeOfContract(ContractType contractType) {
            this.contractType = contractType;
            return this;
        }

        public EmployeeBuilder setPosition(String position) {
            this.position = position;
            return this;
        }

        public EmployeeBuilder setOfficeId(String officeId) {
            this.officeId = officeId;
            return this;
        }

        public EmployeeBuilder setDeleted(boolean deleted) {
            this.deleted = deleted;
            return this;
        }

        public Employee build() {
            return new Employee(id, firstname, lastname, address, pesel, accountNumber, salaryAmount, contractType,
                    position, officeId, deleted);
        }
    }

    public String getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Address getAddress() {
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

    public boolean isDeleted() {
        return deleted;
    }

    public void markAsDeleted() {
        deleted = true;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setSalaryAmount(BigDecimal salaryAmount) {
        this.salaryAmount = salaryAmount;
    }

    public void setContractType(ContractType contractType) {
        this.contractType = contractType;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setOfficeId(String officeId) {
        this.officeId = officeId;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public void updateStreetAddress(String streetAddress) {
        address = new Address(streetAddress, address.getPostalCode(), address.getCityName());
    }

    public void updatePostalCode(String postalCode) {
        address = new Address(address.getStreetAddress(), postalCode, address.getCityName());
    }

    public void updateCityName(String cityName) {
        address = new Address(address.getStreetAddress(), address.getPostalCode(), cityName);
    }

    @Override
    public String toString() {
        return "Employee{" +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", pesel=" + pesel +
                ", accountNumber=" + accountNumber +
                ", salaryAmount=" + salaryAmount +
                ", typeOfContract='" + contractType + '\'' +
                ", position='" + position + '\'' +
                ", officeId='" + officeId + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}

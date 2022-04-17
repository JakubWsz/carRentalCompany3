package com.kuba.carrentalcompany3.domain.employee.model;

import java.math.BigDecimal;

public class Employee {
    private String id;
    private String firstname;
    private String lastname;
    private String address;
    private int pesel;
    private int accountNumber;
    private BigDecimal salaryAmount;
    private String typeOfContract;
    private String position;
    private String officeId;
    private boolean deleted;

    private Employee(String id, String firstname, String lastname, String address, int pesel, int accountNumber,
                     BigDecimal salaryAmount, String typeOfContract, String position, String officeId, boolean deleted) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.pesel = pesel;
        this.accountNumber = accountNumber;
        this.salaryAmount = salaryAmount;
        this.typeOfContract = typeOfContract;
        this.position = position;
        this.officeId = officeId;
        this.deleted = deleted;
    }

    public static class EmployeeBuilder {
        private String id;
        private String firstname;
        private String lastname;
        private String address;
        private int pesel;
        private int accountNumber;
        private BigDecimal salaryAmount;
        private String typeOfContract;
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

        public EmployeeBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public EmployeeBuilder setPesel(int pesel) {
            this.pesel = pesel;
            return this;
        }

        public EmployeeBuilder setAccountNumber(int accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public EmployeeBuilder setSalaryAmount(BigDecimal salaryAmount) {
            this.salaryAmount = salaryAmount;
            return this;
        }

        public EmployeeBuilder setTypeOfContract(String typeOfContract) {
            this.typeOfContract = typeOfContract;
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
            return new Employee(id, firstname, lastname, address, pesel, accountNumber, salaryAmount, typeOfContract,
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

    public String getAddress() {
        return address;
    }

    public int getPesel() {
        return pesel;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getSalaryAmount() {
        return salaryAmount;
    }

    public String getTypeOfContract() {
        return typeOfContract;
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

    public void setId(String id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPesel(int pesel) {
        this.pesel = pesel;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setSalaryAmount(BigDecimal salaryAmount) {
        this.salaryAmount = salaryAmount;
    }

    public void setTypeOfContract(String typeOfContract) {
        this.typeOfContract = typeOfContract;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", pesel=" + pesel +
                ", accountNumber=" + accountNumber +
                ", salaryAmount=" + salaryAmount +
                ", typeOfContract='" + typeOfContract + '\'' +
                ", position='" + position + '\'' +
                ", officeId='" + officeId + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}

package com.kuba.carrentalcompany3.api.dto.response;

import java.math.BigDecimal;

public class EmployeeView {
    private final String id;
    private final String firstname;
    private final String lastname;
    private final String address;
    private final int pesel;
    private final int accountNumber;
    private final BigDecimal salaryAmount;
    private final String typeOfContract;
    private final String position;
    private final String officeStreetAddress;
    private final boolean deleted;

    public EmployeeView(String id, String firstname, String lastname, String address, int pesel, int accountNumber,
                        BigDecimal salaryAmount, String typeOfContract, String position, String officeStreetAddress,
                        boolean deleted) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.pesel = pesel;
        this.accountNumber = accountNumber;
        this.salaryAmount = salaryAmount;
        this.typeOfContract = typeOfContract;
        this.position = position;
        this.officeStreetAddress = officeStreetAddress;
        this.deleted = deleted;
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

    public String getOfficeStreetAddress() {
        return officeStreetAddress;
    }

    public boolean isDeleted() {
        return deleted;
    }
}

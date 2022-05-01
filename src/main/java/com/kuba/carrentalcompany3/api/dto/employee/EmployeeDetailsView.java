package com.kuba.carrentalcompany3.api.dto.employee;

import com.kuba.carrentalcompany3.api.dto.employee.EmployeeAddressDTO;

import java.math.BigDecimal;

public class EmployeeDetailsView {
    private final String firstname;
    private final String lastname;
    private final EmployeeAddressDTO address;
    private final int pesel;
    private final int accountNumber;
    private final BigDecimal salaryAmount;
    private final String typeOfContract;
    private final String position;
    private final String officeId;

    public EmployeeDetailsView( String firstname, String lastname, EmployeeAddressDTO address, int pesel,
                               int accountNumber, BigDecimal salaryAmount, String typeOfContract,
                               String position, String officeId) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.pesel = pesel;
        this.accountNumber = accountNumber;
        this.salaryAmount = salaryAmount;
        this.typeOfContract = typeOfContract;
        this.position = position;
        this.officeId = officeId;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public EmployeeAddressDTO getAddress() {
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
}

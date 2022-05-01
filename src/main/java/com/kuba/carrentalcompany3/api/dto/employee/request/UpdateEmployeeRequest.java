package com.kuba.carrentalcompany3.api.dto.employee.request;

import com.kuba.carrentalcompany3.api.dto.employee.EmployeeAddressDTO;

import java.math.BigDecimal;

public class UpdateEmployeeRequest {
    private final String firstname;
    private final String lastname;
    private final EmployeeAddressDTO address;
    private final String accountNumber;
    private final BigDecimal salaryAmount;
    private final String typeOfContract;

    public UpdateEmployeeRequest(String firstname, String lastname, EmployeeAddressDTO address, String accountNumber,
                                 BigDecimal salaryAmount, String typeOfContract) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.accountNumber = accountNumber;
        this.salaryAmount = salaryAmount;
        this.typeOfContract = typeOfContract;
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

    public String getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getSalaryAmount() {
        return salaryAmount;
    }

    public String getTypeOfContract() {
        return typeOfContract;
    }
}

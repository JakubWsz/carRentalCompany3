package com.kuba.carrentalcompany3.api.dto.employee.request;

import com.kuba.carrentalcompany3.api.dto.employee.EmployeeAddressDTO;

import java.math.BigDecimal;

public class CreateEmployeeRequest {
    private final String firstname;
    private final String lastname;
    private final EmployeeAddressDTO employeeAddressDTO;
    private final int pesel;
    private final String accountNumber;
    private final BigDecimal salaryAmount;
    private final String typeOfContract;
    private final String position;
    private final String officeId;

    public CreateEmployeeRequest(String firstname, String lastname, EmployeeAddressDTO employeeAddressDTO, int pesel,
                                 String accountNumber, BigDecimal salaryAmount, String typeOfContract, String position,
                                 String officeId) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.employeeAddressDTO = employeeAddressDTO;
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

    public EmployeeAddressDTO getEmployeeAddressDTO() {
        return employeeAddressDTO;
    }

    public int getPesel() {
        return pesel;
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

    public String getPosition() {
        return position;
    }

    public String getOfficeId() {
        return officeId;
    }
}

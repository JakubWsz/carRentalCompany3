package com.kuba.carrentalcompany3.api.dto.employee.request;

import com.kuba.carrentalcompany3.api.dto.AddressDTO;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.employee.entity.ContractType;

import java.math.BigDecimal;

public class CreateEmployeeRequest {
    private final String firstname;
    private final String lastname;
    private final AddressDTO addressDTO;
    private final String pesel;
    private final String accountNumber;
    private final BigDecimal salaryAmount;
    private final ContractType contractType;
    private final String position;
    private final String officeId;

    public CreateEmployeeRequest(String firstname, String lastname, AddressDTO addressDTO, String pesel,
                                 String accountNumber, BigDecimal salaryAmount, ContractType contractType, String position,
                                 String officeId) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.addressDTO = addressDTO;
        this.pesel = pesel;
        this.accountNumber = accountNumber;
        this.salaryAmount = salaryAmount;
        this.contractType = contractType;
        this.position = position;
        this.officeId = officeId;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public AddressDTO getAddressDTO() {
        return addressDTO;
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

package com.kuba.carrentalcompany3.api.dto.employee.request;

import com.kuba.carrentalcompany3.api.dto.AddressDTO;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.employee.entity.ContractType;

import java.math.BigDecimal;

public class UpdateEmployeeRequest {
    private final String firstname;
    private final String lastname;
    private final AddressDTO addressDTO;
    private final String accountNumber;
    private final BigDecimal salaryAmount;
    private final ContractType contractType;

    public UpdateEmployeeRequest(String firstname, String lastname, AddressDTO addressDTO, String accountNumber,
                                 BigDecimal salaryAmount, ContractType contractType) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.addressDTO = addressDTO;
        this.accountNumber = accountNumber;
        this.salaryAmount = salaryAmount;
        this.contractType = contractType;
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

    public String getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getSalaryAmount() {
        return salaryAmount;
    }

    public ContractType getContractType() {
        return contractType;
    }
}

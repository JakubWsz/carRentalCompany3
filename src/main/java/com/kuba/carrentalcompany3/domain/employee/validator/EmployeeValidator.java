package com.kuba.carrentalcompany3.domain.employee.validator;

import com.kuba.carrentalcompany3.domain.AddressValidator;
import com.kuba.carrentalcompany3.domain.employee.model.Employee;

public class EmployeeValidator {

    public static void validateEmployee(Employee employee) {
        AddressValidator.validateIsEmployeeAddressNotNull(employee.getAddress());
        AddressValidator.validateAddressData(employee.getAddress());
    }
}

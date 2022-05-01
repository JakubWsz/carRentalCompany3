package com.kuba.carrentalcompany3.infrastructure.converter.employee.api;

import com.kuba.carrentalcompany3.api.dto.employee.EmployeeAddressDTO;
import com.kuba.carrentalcompany3.domain.employee.model.EmployeeAddress;
import org.springframework.core.convert.converter.Converter;

public class EmployeeAddressDTOToEmployeeAddress implements Converter<EmployeeAddressDTO, EmployeeAddress> {
    @Override
    public EmployeeAddress convert(EmployeeAddressDTO employeeAddressDTO) {
        return new EmployeeAddress(
                employeeAddressDTO.getEmployeeStreetAddress(),
                employeeAddressDTO.getEmployeePostalCode(),
                employeeAddressDTO.getEmployeeCityName());
    }
}

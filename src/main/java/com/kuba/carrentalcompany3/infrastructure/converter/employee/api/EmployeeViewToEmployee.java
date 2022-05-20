package com.kuba.carrentalcompany3.infrastructure.converter.employee.api;

import com.kuba.carrentalcompany3.api.dto.AddressDTO;
import com.kuba.carrentalcompany3.api.dto.employee.EmployeeView;
import com.kuba.carrentalcompany3.domain.Address;
import com.kuba.carrentalcompany3.domain.employee.model.Employee;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

public class EmployeeViewToEmployee implements Converter<EmployeeView, Employee> {
    private final ConversionService conversionService;

    public EmployeeViewToEmployee(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public Employee convert(EmployeeView employeeView) {
        return new Employee.EmployeeBuilder()
                .setId(employeeView.getId())
                .setFirstname(employeeView.getFirstname())
                .setLastname(employeeView.getLastname())
                .setAddress(conversionService.convert(employeeView.getAddress(), Address.class))
                .setPesel(employeeView.getPesel())
                .setAccountNumber(employeeView.getAccountNumber())
                .setSalaryAmount(employeeView.getSalaryAmount())
                .setTypeOfContract(employeeView.getContractType())
                .setPosition(employeeView.getPosition())
                .setOfficeId(employeeView.getOfficeId())
                .build();
    }
}

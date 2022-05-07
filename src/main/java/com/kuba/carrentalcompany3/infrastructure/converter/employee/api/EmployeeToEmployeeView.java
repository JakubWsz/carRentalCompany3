package com.kuba.carrentalcompany3.infrastructure.converter.employee.api;

import com.kuba.carrentalcompany3.api.dto.AddressDTO;
import com.kuba.carrentalcompany3.api.dto.employee.EmployeeView;
import com.kuba.carrentalcompany3.domain.employee.model.Employee;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

public class EmployeeToEmployeeView implements Converter<Employee, EmployeeView> {
    private final ConversionService conversionService;

    public EmployeeToEmployeeView(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public EmployeeView convert(Employee employee) {
        return new EmployeeView(
                employee.getDomainId(),
                employee.getFirstname(),
                employee.getLastname(),
                conversionService.convert(employee.getAddress(), AddressDTO.class),
                employee.getPesel(),
                employee.getAccountNumber(),
                employee.getSalaryAmount(),
                employee.getContractType(),
                employee.getPosition(),
                employee.getOfficeId()
        );
    }
}

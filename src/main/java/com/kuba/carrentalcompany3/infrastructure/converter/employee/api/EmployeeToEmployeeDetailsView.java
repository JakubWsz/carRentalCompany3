package com.kuba.carrentalcompany3.infrastructure.converter.employee.api;

import com.kuba.carrentalcompany3.api.dto.AddressDTO;
import com.kuba.carrentalcompany3.api.dto.employee.EmployeeDetailsView;
import com.kuba.carrentalcompany3.domain.employee.model.Employee;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

public class EmployeeToEmployeeDetailsView implements Converter<Employee, EmployeeDetailsView> {
    private final ConversionService conversionService;

    public EmployeeToEmployeeDetailsView(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public EmployeeDetailsView convert(Employee employee) {
        return new EmployeeDetailsView(
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

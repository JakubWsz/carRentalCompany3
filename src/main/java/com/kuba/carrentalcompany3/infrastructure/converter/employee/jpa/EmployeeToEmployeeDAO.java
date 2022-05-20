package com.kuba.carrentalcompany3.infrastructure.converter.employee.jpa;

import com.kuba.carrentalcompany3.domain.employee.model.Employee;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.AddressDAO;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.employee.entity.EmployeeDAO;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

public class EmployeeToEmployeeDAO implements Converter<Employee, EmployeeDAO> {
    private final ConversionService conversionService;

    public EmployeeToEmployeeDAO(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public EmployeeDAO convert(Employee employee) {
        return new EmployeeDAO(
                employee.isDeleted(),
                employee.getId(),
                employee.getFirstname(),
                employee.getLastname(),
                conversionService.convert(employee.getAddress(), AddressDAO.class),
                employee.getPesel(),
                employee.getAccountNumber(),
                employee.getSalaryAmount(),
                employee.getContractType(),
                employee.getPosition(),
                employee.getOfficeId()
        );
    }
}

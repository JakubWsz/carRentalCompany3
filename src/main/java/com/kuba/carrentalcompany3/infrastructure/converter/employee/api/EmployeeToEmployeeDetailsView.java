package com.kuba.carrentalcompany3.infrastructure.converter.employee.api;

import com.kuba.carrentalcompany3.api.dto.response.EmployeeDetailsView;
import com.kuba.carrentalcompany3.domain.employee.model.Employee;
import org.springframework.core.convert.converter.Converter;

public class EmployeeToEmployeeDetailsView implements Converter<Employee, EmployeeDetailsView> {
    @Override
    public EmployeeDetailsView convert(Employee employee) {
        return new EmployeeDetailsView(
                employee.getFirstname(),
                employee.getLastname(),
                employee.getAddress(),
                employee.getPesel(),
                employee.getAccountNumber(),
                employee.getSalaryAmount(),
                employee.getTypeOfContract(),
                employee.getPosition(),
                employee.getOfficeId()
        );
    }
}

package com.kuba.carrentalcompany3.infrastructure.database.jpa.employee;

import com.kuba.carrentalcompany3.domain.employee.EmployeeRepository;
import com.kuba.carrentalcompany3.domain.employee.model.Employee;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.employee.entity.EmployeeDAO;
import org.springframework.core.convert.ConversionService;

import java.util.Optional;

public class EmployeeRepositoryAdapterJPA implements EmployeeRepository {
    private final EmployeeRepositoryJPA employeeRepositoryJPA;
    private final ConversionService conversionService;

    public EmployeeRepositoryAdapterJPA(EmployeeRepositoryJPA employeeRepositoryJPA,
                                        ConversionService conversionService) {
        this.employeeRepositoryJPA = employeeRepositoryJPA;
        this.conversionService = conversionService;
    }

    @Override
    public Employee save(Employee employee) {
        EmployeeDAO employeeDao = employeeRepositoryJPA.save(conversionService.convert(employee, EmployeeDAO.class));
        return conversionService.convert(employeeDao, Employee.class);
    }

    @Override
    public Optional<Employee> getEmployee(String domainId) {
        int intDomainId = Integer.parseInt(domainId);
        Optional<EmployeeDAO> employeeDaoOptional = employeeRepositoryJPA.findByDomainId(intDomainId);
        return Optional.ofNullable(conversionService.convert(employeeDaoOptional.get(), Employee.class));
    }

    @Override
    public void update(Employee employee) {
        EmployeeDAO employeeDao = conversionService.convert(employee, EmployeeDAO.class);
        employeeRepositoryJPA.save(employeeDao);
    }
}

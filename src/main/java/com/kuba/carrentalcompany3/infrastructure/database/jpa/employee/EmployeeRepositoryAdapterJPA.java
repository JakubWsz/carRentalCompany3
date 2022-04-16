package com.kuba.carrentalcompany3.infrastructure.database.jpa.employee;

import com.kuba.carrentalcompany3.domain.client.model.Client;
import com.kuba.carrentalcompany3.domain.employee.EmployeeRepository;
import com.kuba.carrentalcompany3.domain.employee.model.Employee;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.client.entity.ClientDao;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.employee.entity.EmployeeDao;
import org.springframework.core.convert.ConversionService;

public class EmployeeRepositoryAdapterJPA implements EmployeeRepository {
    private EmployeeRepositoryJPA employeeRepositoryJPA;
    private ConversionService conversionService;

    public EmployeeRepositoryAdapterJPA(EmployeeRepositoryJPA employeeRepositoryJPA) {
        this.employeeRepositoryJPA = employeeRepositoryJPA;
    }

    @Override
    public Employee save(Employee employee) {
        EmployeeDao employeeDao = employeeRepositoryJPA.save(conversionService.convert(employee, EmployeeDao.class));
        return conversionService.convert(employeeDao, Employee.class);
    }
}

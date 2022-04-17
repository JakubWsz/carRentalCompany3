package com.kuba.carrentalcompany3.infrastructure.database.jpa.employee;

import com.kuba.carrentalcompany3.domain.employee.EmployeeRepository;
import com.kuba.carrentalcompany3.domain.employee.model.Employee;
import com.kuba.carrentalcompany3.domain.office.model.Office;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.employee.entity.EmployeeDao;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.office.entity.OfficeDao;
import org.springframework.core.convert.ConversionService;

import java.util.Optional;

public class EmployeeRepositoryAdapterJPA implements EmployeeRepository {
    private final EmployeeRepositoryJPA employeeRepositoryJPA;
    private ConversionService conversionService;

    public EmployeeRepositoryAdapterJPA(EmployeeRepositoryJPA employeeRepositoryJPA) {
        this.employeeRepositoryJPA = employeeRepositoryJPA;
    }

    @Override
    public Employee save(Employee employee) {
        EmployeeDao employeeDao = employeeRepositoryJPA.save(conversionService.convert(employee, EmployeeDao.class));
        return conversionService.convert(employeeDao, Employee.class);
    }

    @Override
    public Optional<Employee> getEmployee(String pesel) {
        int intPesel = Integer.parseInt(pesel);
        Optional<EmployeeDao> employeeDaoOptional = employeeRepositoryJPA.findByPesel(intPesel);
        return Optional.ofNullable(conversionService.convert(employeeDaoOptional.get(), Employee.class));
    }

    @Override
    public void update(Employee employee) {
        EmployeeDao employeeDao = conversionService.convert(employee, EmployeeDao.class);
        employeeRepositoryJPA.save(employeeDao);
    }
}

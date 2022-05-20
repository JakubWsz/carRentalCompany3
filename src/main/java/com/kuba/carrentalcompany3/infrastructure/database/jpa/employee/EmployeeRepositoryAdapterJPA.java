package com.kuba.carrentalcompany3.infrastructure.database.jpa.employee;

import com.kuba.carrentalcompany3.domain.employee.EmployeeRepository;
import com.kuba.carrentalcompany3.domain.employee.model.Employee;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.employee.entity.EmployeeDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.ConversionService;

import java.util.Optional;

public class EmployeeRepositoryAdapterJPA implements EmployeeRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeRepositoryAdapterJPA.class);
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
        try {
            Optional<EmployeeDAO> employeeDaoOptional = employeeRepositoryJPA.findByDomainId(domainId);
            return Optional.ofNullable(conversionService.convert(employeeDaoOptional.get(), Employee.class));
        } catch (Exception e) {
            LOGGER.error("getEmployee error occurred", e);
            return Optional.empty();
        }
    }

    @Override
    public void update(Employee employee) {
        Optional<EmployeeDAO> employeeDaoOptional = employeeRepositoryJPA.findByDomainId(employee.getId());

       if (employeeDaoOptional.isPresent() ){
            EmployeeDAO employeeDao = conversionService.convert(employee, EmployeeDAO.class);
            employeeDao.setId(employeeDaoOptional.get().getId());
            employeeRepositoryJPA.save(employeeDao);
        }
    }
}

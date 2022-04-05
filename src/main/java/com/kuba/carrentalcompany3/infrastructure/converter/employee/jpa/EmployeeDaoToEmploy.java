package com.kuba.carrentalcompany3.infrastructure.converter.employee.jpa;

import com.kuba.carrentalcompany3.domain.employee.model.Employee;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.employee.entity.EmployeeDao;
import org.springframework.core.convert.converter.Converter;

public class EmployeeDaoToEmploy implements Converter<EmployeeDao, Employee> {
    @Override
    public Employee convert(EmployeeDao employeeDao) {
        return new Employee(
                employeeDao.getDomainId(),
                employeeDao.getFirstname(),
                employeeDao.getLastname(),
                employeeDao.getAddress(),
                employeeDao.getPesel(),
                employeeDao.getAccountNumber(),
                employeeDao.getSalaryAmount(),
                employeeDao.getTypeOfContract(),
                employeeDao.getPosition(),
                employeeDao.getAddress(),
                employeeDao.isDeleted()
        );
    }
}

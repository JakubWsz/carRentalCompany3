package com.kuba.carrentalcompany3.infrastructure.converter.employee.jpa;

import com.kuba.carrentalcompany3.domain.employee.model.Employee;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.employee.entity.EmployeeDao;
import org.springframework.core.convert.converter.Converter;

public class EmployeeDaoToEmploy implements Converter<EmployeeDao, Employee> {
    @Override
    public Employee convert(EmployeeDao employeeDao) {
        return new Employee.EmployeeBuilder()
                .setId(employeeDao.getDomainId())
                .setFirstname(employeeDao.getFirstname())
                .setLastname(employeeDao.getLastname())
                .setAddress(employeeDao.getAddress())
                .setPesel(employeeDao.getPesel())
                .setAccountNumber(employeeDao.getAccountNumber())
                .setSalaryAmount(employeeDao.getSalaryAmount())
                .setTypeOfContract(employeeDao.getTypeOfContract())
                .setPosition(employeeDao.getPosition())
                .setOfficeId(employeeDao.getAddress())
                .setDeleted(employeeDao.isDeleted())
                .build();
    }
}

package com.kuba.carrentalcompany3.infrastructure.converter.employee.jpa;

import com.kuba.carrentalcompany3.domain.employee.model.Employee;
import com.kuba.carrentalcompany3.domain.employee.model.EmployeeAddress;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.employee.entity.EmployeeAddressDAO;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.employee.entity.EmployeeDAO;
import org.springframework.core.convert.converter.Converter;

public class EmployeeDAOToEmploy implements Converter<EmployeeDAO, Employee> {
    @Override
    public Employee convert(EmployeeDAO employeeDao) {
        EmployeeAddressDAO employeeAddressDAO = employeeDao.getAddress();
        return new Employee.EmployeeBuilder()
                .setId(employeeDao.getDomainId())
                .setFirstname(employeeDao.getFirstname())
                .setLastname(employeeDao.getLastname())
                .setAddress(new EmployeeAddress(employeeAddressDAO.getEmployeeStreetAddress(),
                        employeeAddressDAO.getEmployeePostalCode(),
                        employeeAddressDAO.getEmployeeCityName()))
                .setPesel(employeeDao.getPesel())
                .setAccountNumber(employeeDao.getAccountNumber())
                .setSalaryAmount(employeeDao.getSalaryAmount())
                .setTypeOfContract(employeeDao.getTypeOfContract())
                .setPosition(employeeDao.getPosition())
                .setOfficeId(employeeDao.getOfficeId())
                .setDeleted(employeeDao.isDeleted())
                .build();
    }
}

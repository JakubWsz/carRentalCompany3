package com.kuba.carrentalcompany3.infrastructure.converter.employee.jpa;

import com.kuba.carrentalcompany3.domain.Address;
import com.kuba.carrentalcompany3.domain.employee.model.Employee;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.AddressDAO;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.employee.entity.EmployeeDAO;
import org.springframework.core.convert.converter.Converter;

public class EmployeeDAOToEmploy implements Converter<EmployeeDAO, Employee> {
    @Override
    public Employee convert(EmployeeDAO employeeDao) {
        AddressDAO addressDAO = employeeDao.getAddress();
        return new Employee.EmployeeBuilder()
                .setId(employeeDao.getDomainId())
                .setFirstname(employeeDao.getFirstname())
                .setLastname(employeeDao.getLastname())
                .setAddress(new Address(addressDAO.getStreetAddress(),
                        addressDAO.getPostalCode(),
                        addressDAO.getCityName()))
                .setPesel(employeeDao.getPesel())
                .setAccountNumber(employeeDao.getAccountNumber())
                .setSalaryAmount(employeeDao.getSalaryAmount())
                .setTypeOfContract(employeeDao.getContractType())
                .setPosition(employeeDao.getPosition())
                .setOfficeId(employeeDao.getOfficeId())
                .setDeleted(employeeDao.isDeleted())
                .build();
    }
}

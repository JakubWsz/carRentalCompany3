package com.kuba.carrentalcompany3.domain.employee;

import com.kuba.carrentalcompany3.domain.Address;
import com.kuba.carrentalcompany3.domain.employee.model.Employee;
import com.kuba.carrentalcompany3.domain.employee.model.EmployeeFieldType;
import com.kuba.carrentalcompany3.domain.employee.validator.EmployeeValidator;
import com.kuba.carrentalcompany3.domain.exception.DomainException;
import com.kuba.carrentalcompany3.domain.exception.EmployeeExceptionCode;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.employee.entity.ContractType;

import java.math.BigDecimal;
import java.util.Map;
import java.util.UUID;

public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee createEmployee(String firstname, String lastname, Address address, String pesel,
            String accountNumber, BigDecimal salaryAmount, ContractType contractType,
            String position, String officeId) {
        Employee employee = new Employee.EmployeeBuilder()
                .setId(UUID.randomUUID().toString())
                .setFirstname(firstname)
                .setLastname(lastname)
                .setAddress(address)
                .setPesel(pesel)
                .setAccountNumber(accountNumber)
                .setSalaryAmount(salaryAmount)
                .setTypeOfContract(contractType)
                .setPosition(position)
                .setOfficeId(officeId)
                .setDeleted(false)
                .build();
        EmployeeValidator.validateEmployee(employee);
        return employeeRepository.save(employee);
    }

    public void removeEmployee(String pesel) {
        Employee employee = getEmployee(pesel);
        employee.markAsDeleted();
        employeeRepository.update(employee);
    }

    public void updateEmployee(Map<EmployeeFieldType, String> fieldUpdates, String id) {
        Employee employee = getEmployee(id);
        EmployeeFieldsUpdater.updateAll(employee, fieldUpdates);
        employeeRepository.save(employee);
    }

    private Employee getEmployee(String domainId) {
        Employee employee = employeeRepository.getEmployee(domainId)
                .orElseThrow(() -> new DomainException(EmployeeExceptionCode.EMPLOYEE_DOESNT_EXISTS));
        isEmployeeRemovedValidator(employee.isDeleted());
        return employee;
    }

    private void isEmployeeRemovedValidator(boolean deleted) {
        if (deleted) {
            throw new DomainException(EmployeeExceptionCode.EMPLOYEE_ALREADY_DELETED);
        }
    }
}
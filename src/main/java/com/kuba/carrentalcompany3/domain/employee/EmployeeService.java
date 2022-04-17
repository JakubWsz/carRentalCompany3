package com.kuba.carrentalcompany3.domain.employee;

import com.kuba.carrentalcompany3.api.dto.request.ChangeEmployeePositionRequest;
import com.kuba.carrentalcompany3.api.dto.request.UpdateEmployeeRequest;
import com.kuba.carrentalcompany3.api.dto.response.EmployeeDetailsView;
import com.kuba.carrentalcompany3.domain.employee.model.Employee;
import com.kuba.carrentalcompany3.domain.exception.DomainException;
import com.kuba.carrentalcompany3.domain.exception.EmployeeExceptionCode;
import org.springframework.core.convert.ConversionService;

import java.math.BigDecimal;
import java.util.UUID;

public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private ConversionService conversionService;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee hireEmployee(String firstname, String lastname, String address, int pesel, int accountNumber,
                                 BigDecimal salaryAmount, String typeOfContract, String position,
                                 String officeId) {
        Employee employee = new Employee.EmployeeBuilder()
                .setId(UUID.randomUUID().toString())
                .setFirstname(firstname)
                .setLastname(lastname)
                .setAddress(address)
                .setPesel(pesel)
                .setAccountNumber(accountNumber)
                .setSalaryAmount(salaryAmount)
                .setTypeOfContract(typeOfContract)
                .setPosition(position)
                .setOfficeId(officeId)
                .setDeleted(false)
                .build();
        return employeeRepository.save(employee);
    }

    public void removeEmployee(String pesel) {
        Employee employee = getEmployee(pesel);
        employee.markAsDeleted();
        employeeRepository.update(employee);
    }

    public EmployeeDetailsView updateEmployee(UpdateEmployeeRequest updateRequest, String pesel) {
        Employee employee = getEmployee(pesel);
        updatePartiallyEmployee(employee,updateRequest);
        employeeRepository.save(employee);
        return conversionService.convert(employee,EmployeeDetailsView.class);
    }

    public EmployeeDetailsView changeEmployeePosition(ChangeEmployeePositionRequest request, String pesel) {
        Employee employee = getEmployee(pesel);
        updatePositionAndSalary(employee,request);
        employeeRepository.save(employee);
        return conversionService.convert(employee,EmployeeDetailsView.class);
    }

    private Employee getEmployee(String pesel) {
        Employee employee = employeeRepository.getEmployee(pesel).orElseThrow(()
                -> new DomainException(EmployeeExceptionCode.EMPLOYEE_DOESNT_EXISTS));
        isEmployeeRemovedValidator(employee.isDeleted());
        return employee;
    }

    private void isEmployeeRemovedValidator(boolean deleted) {
        if (deleted) {
            throw new DomainException(EmployeeExceptionCode.EMPLOYEE_ALREADY_DELETED);
        }
    }

    private void updatePositionAndSalary(Employee primaryEmployee,ChangeEmployeePositionRequest request) {
        if (request.getPosition() != null){
            primaryEmployee.setPosition(request.getPosition());
        }

        if (request.getPosition() != null) {
            primaryEmployee.setSalaryAmount(request.getSalaryAmount());
        }
    }

    private void updatePartiallyEmployee(Employee primaryEmployee, UpdateEmployeeRequest updateRequest) {
        if (updateRequest.getFirstname() != null){
            primaryEmployee.setFirstname(updateRequest.getFirstname());
        }

        if (updateRequest.getLastname() != null) {
            primaryEmployee.setLastname(updateRequest.getLastname());
        }

        if (updateRequest.getAddress() != null) {
            primaryEmployee.setAddress(updateRequest.getAddress());
        }

        if (updateRequest.getAccountNumber() != null) {
            primaryEmployee.setAccountNumber(Integer.parseInt(updateRequest.getAccountNumber()));
        }

        if (updateRequest.getSalaryAmount() != null) {
            primaryEmployee.setSalaryAmount(updateRequest.getSalaryAmount());
        }

        if (updateRequest.getTypeOfContract() != null) {
            primaryEmployee.setTypeOfContract(updateRequest.getTypeOfContract());
        }
    }
}
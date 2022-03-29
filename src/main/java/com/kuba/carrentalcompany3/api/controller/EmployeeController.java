package com.kuba.carrentalcompany3.api.controller;

import com.kuba.carrentalcompany3.api.dto.request.CreateEmployeeRequest;
import com.kuba.carrentalcompany3.api.dto.response.ClientView;
import com.kuba.carrentalcompany3.api.dto.response.EmployeeView;
import com.kuba.carrentalcompany3.domain.employee.EmployeeService;
import com.kuba.carrentalcompany3.domain.employee.model.Employee;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final ConversionService conversionService;
    private final EmployeeService employeeService;

    public EmployeeController(ConversionService conversionService, EmployeeService employeeService) {
        this.conversionService = conversionService;
        this.employeeService = employeeService;
    }

    @PostMapping("/hire-employee")
    public ResponseEntity<EmployeeView> hireEmployee(@RequestBody CreateEmployeeRequest employeeRequest){
        Employee employee = employeeService.hireEmployee(
                employeeRequest.getFirstname(),
                employeeRequest.getLastname(),
                employeeRequest.getAddress(),
                employeeRequest.getPesel(),
                employeeRequest.getAccountNumber(),
                employeeRequest.getSalaryAmount(),
                employeeRequest.getTypeOfContract(),
                employeeRequest.getPosition(),
                employeeRequest.getOfficeStreetAddress(),
                employeeRequest.getOfficeId());
        return new ResponseEntity<>(conversionService.convert(employee, EmployeeView.class), HttpStatus.CREATED);
    }
}

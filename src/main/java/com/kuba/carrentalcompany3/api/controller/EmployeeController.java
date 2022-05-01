package com.kuba.carrentalcompany3.api.controller;

import com.kuba.carrentalcompany3.api.dto.employee.request.ChangeEmployeePositionRequest;
import com.kuba.carrentalcompany3.api.dto.employee.request.CreateEmployeeRequest;
import com.kuba.carrentalcompany3.api.dto.employee.request.UpdateEmployeeRequest;
import com.kuba.carrentalcompany3.api.dto.employee.EmployeeDetailsView;
import com.kuba.carrentalcompany3.domain.employee.EmployeeService;
import com.kuba.carrentalcompany3.domain.employee.model.Employee;
import com.kuba.carrentalcompany3.domain.employee.model.EmployeeAddress;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final ConversionService conversionService;
    private final EmployeeService employeeService;

    public EmployeeController(ConversionService conversionService, EmployeeService employeeService) {
        this.conversionService = conversionService;
        this.employeeService = employeeService;
    }

    @PostMapping("/hire")
    public ResponseEntity<EmployeeDetailsView> createEmployee(@RequestBody CreateEmployeeRequest createEmployeeRequest) {
        Employee employee = employeeService.createEmployee(
                createEmployeeRequest.getFirstname(),
                createEmployeeRequest.getLastname(),
                conversionService.convert(createEmployeeRequest.getEmployeeAddressDTO(), EmployeeAddress.class),
                createEmployeeRequest.getPesel(),
                createEmployeeRequest.getAccountNumber(),
                createEmployeeRequest.getSalaryAmount(),
                createEmployeeRequest.getTypeOfContract(),
                createEmployeeRequest.getPosition(),
                createEmployeeRequest.getOfficeId());
        return new ResponseEntity<>(conversionService.convert(employee, EmployeeDetailsView.class), HttpStatus.CREATED);
    }

    @DeleteMapping("/remove")
    public void removeEmployee(String pesel) {
        employeeService.removeEmployee(pesel);
    }

    @PatchMapping("/update-data/{pesel}")
    public void updateEmployee(@RequestBody UpdateEmployeeRequest updateEmployeeRequest, @PathVariable String pesel) {
        employeeService.updateEmployee(new Employee.EmployeeBuilder()
                .setFirstname(updateEmployeeRequest.getFirstname())
                .setLastname(updateEmployeeRequest.getLastname())
                .setAddress(conversionService.convert(updateEmployeeRequest.getAddress(), EmployeeAddress.class))
                .setAccountNumber(updateEmployeeRequest.getAccountNumber())
                .setSalaryAmount(updateEmployeeRequest.getSalaryAmount())
                .setTypeOfContract(updateEmployeeRequest.getTypeOfContract())
                .build(),
                pesel);
    }

    @PatchMapping("/change-position/{pesel}")
    public void changePosition(@RequestBody ChangeEmployeePositionRequest request,
                               @PathVariable String pesel) {
        employeeService.changeEmployeePosition(request, pesel);
    }

}

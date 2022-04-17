package com.kuba.carrentalcompany3.api.controller;

import com.kuba.carrentalcompany3.api.dto.request.ChangeEmployeePositionRequest;
import com.kuba.carrentalcompany3.api.dto.request.HireEmployeeRequest;
import com.kuba.carrentalcompany3.api.dto.request.UpdateEmployeeRequest;
import com.kuba.carrentalcompany3.api.dto.response.EmployeeDetailsView;
import com.kuba.carrentalcompany3.api.dto.response.EmployeeView;
import com.kuba.carrentalcompany3.domain.employee.EmployeeService;
import com.kuba.carrentalcompany3.domain.employee.model.Employee;
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
    public ResponseEntity<EmployeeView> hireEmployee(@RequestBody HireEmployeeRequest employeeRequest) {
        Employee employee = employeeService.hireEmployee(
                employeeRequest.getFirstname(),
                employeeRequest.getLastname(),
                employeeRequest.getAddress(),
                employeeRequest.getPesel(),
                employeeRequest.getAccountNumber(),
                employeeRequest.getSalaryAmount(),
                employeeRequest.getTypeOfContract(),
                employeeRequest.getPosition(),
                employeeRequest.getOfficeId());
        return new ResponseEntity<>(conversionService.convert(employee, EmployeeView.class), HttpStatus.CREATED);
    }

    @DeleteMapping("/remove")
    public void removeEmployee(String pesel) {
        employeeService.removeEmployee(pesel);
    }

    @PatchMapping("/update-data/{pesel}")
    public EmployeeDetailsView updateEmployee(@RequestBody UpdateEmployeeRequest request, @PathVariable String pesel) {
        return employeeService.updateEmployee(request, pesel);
    }

    @PatchMapping("/change-position/{pesel}")
    public EmployeeDetailsView changePosition(@RequestBody ChangeEmployeePositionRequest request,
                                              @PathVariable String pesel) {
        return employeeService.changeEmployeePosition(request,pesel);
    }

}

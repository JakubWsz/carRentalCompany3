//package com.kuba.carrentalcompany3.domain.employee;

//import com.kuba.carrentalcompany3.domain.employee.model.Employee;
//import com.kuba.carrentalcompany3.domain.office.OfficeService;
//
//import java.math.BigDecimal;
//import java.util.List;
//import java.util.UUID;
//
//public class EmployeeService {
//    private final EmployeeRepository employeeRepository;
//    private final OfficeService officeService;
//
//    public EmployeeService(EmployeeRepository employeeRepository, OfficeService officeService) {
//        this.employeeRepository = employeeRepository;
//        this.officeService = officeService;
//    }
//
//    public Employee hireEmployee(String firstname, String lastname, String address, int pesel, int accountNumber,
//                                 BigDecimal salaryAmount, String typeOfContract, String position,
//                                 String officeStreetAddress, String officeId) {
//        Employee employee = new Employee(
//                UUID.randomUUID().toString(),
//                firstname,
//                lastname,
//                address,
//                pesel,
//                accountNumber,
//                salaryAmount,
//                typeOfContract,
//                position,
//                officeStreetAddress,
//                false);
//        List<Employee> employees = officeService.getEmployees(officeId);
//        employees.add(employee);
//        return employeeRepository.save(employee);
//    }
//}

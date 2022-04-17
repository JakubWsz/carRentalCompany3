package com.kuba.carrentalcompany3.domain.employee;

import com.kuba.carrentalcompany3.domain.employee.model.Employee;

import java.util.Optional;

public interface EmployeeRepository {
    Employee save(Employee employee);

    Optional<Employee> getEmployee(String pesel);

    void update(Employee employee);
}

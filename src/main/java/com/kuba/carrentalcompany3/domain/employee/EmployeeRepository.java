package com.kuba.carrentalcompany3.domain.employee;

import com.kuba.carrentalcompany3.domain.employee.model.Employee;

public interface EmployeeRepository {
    Employee save(Employee employee);
}

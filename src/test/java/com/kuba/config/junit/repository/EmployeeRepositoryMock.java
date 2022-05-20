package com.kuba.config.junit.repository;

import com.kuba.carrentalcompany3.domain.employee.EmployeeRepository;
import com.kuba.carrentalcompany3.domain.employee.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeRepositoryMock implements EmployeeRepository {
    private final List<Employee> employees = new ArrayList<>();

    @Override
    public Employee save(Employee employee) {
        employees.add(employee);
        return employee;
    }

    @Override
    public Optional<Employee> getEmployee(String pesel) {
        return employees.stream()
                .filter(employee -> pesel.equals(employee.getPesel()))
                .findFirst();
    }

    @Override
    public void update(Employee employee) {
        save(employee);
    }

    public void clean() {
        employees.clear();
    }
}

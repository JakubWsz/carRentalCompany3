package com.kuba.carrentalcompany3.domain.office;

import com.kuba.carrentalcompany3.domain.employee.model.Employee;
import com.kuba.carrentalcompany3.domain.office.model.Office;

import java.util.List;
import java.util.Optional;

public interface OfficeRepository {
    Office save(Office office);

    Optional<Office> getOffice(String id);

    void update(Office office);

    List<Employee> getEmployeeList(String officeId);

    List<Employee> saveEmployee(String officeId, Employee employee);
}

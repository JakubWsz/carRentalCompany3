package com.kuba.carrentalcompany3.infrastructure.database.jpa.employee;

import com.kuba.carrentalcompany3.infrastructure.database.jpa.employee.entity.EmployeeDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepositoryJPA extends JpaRepository<EmployeeDao,Long> {
}

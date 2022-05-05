package com.kuba.carrentalcompany3.infrastructure.database.jpa.employee;

import com.kuba.carrentalcompany3.infrastructure.database.jpa.employee.entity.EmployeeDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepositoryJPA extends JpaRepository<EmployeeDAO,Long> {
    Optional<EmployeeDAO> findByDomainId(int domainId);
}

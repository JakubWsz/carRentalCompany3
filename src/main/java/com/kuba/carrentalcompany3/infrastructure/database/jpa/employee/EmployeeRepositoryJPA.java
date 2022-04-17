package com.kuba.carrentalcompany3.infrastructure.database.jpa.employee;

import com.kuba.carrentalcompany3.infrastructure.database.jpa.employee.entity.EmployeeDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepositoryJPA extends JpaRepository<EmployeeDao,Long> {
    Optional<EmployeeDao> findByPesel(int pesel);
}

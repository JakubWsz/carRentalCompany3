package com.kuba.carrentalcompany3.infrastructure.database.jpa.car;

import com.kuba.carrentalcompany3.infrastructure.database.jpa.car.entity.CarDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarRepositoryJPA extends JpaRepository<CarDAO, Long> {
    Optional<CarDAO> findByDomainId(String domainId);
}

package com.kuba.carrentalcompany3.infrastructure.database.jpa.office;

import com.kuba.carrentalcompany3.infrastructure.database.jpa.office.entity.OfficeDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OfficeRepositoryJPA extends JpaRepository<OfficeDAO, Long> {
    Optional<OfficeDAO> getByDomainId(String domainId);
}

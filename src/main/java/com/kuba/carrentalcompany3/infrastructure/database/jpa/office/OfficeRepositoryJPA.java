package com.kuba.carrentalcompany3.infrastructure.database.jpa.office;

import com.kuba.carrentalcompany3.infrastructure.database.jpa.office.entity.OfficeDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OfficeRepositoryJPA extends JpaRepository<OfficeDao, Long> {
    Optional<OfficeDao> getByDomainId(String domainId);
}

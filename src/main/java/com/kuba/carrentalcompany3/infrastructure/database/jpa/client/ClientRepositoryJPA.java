package com.kuba.carrentalcompany3.infrastructure.database.jpa.client;

import com.kuba.carrentalcompany3.infrastructure.database.jpa.client.entity.ClientDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepositoryJPA extends JpaRepository<ClientDao, Long> {
}

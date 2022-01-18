package com.kuba.carrentalcompany3.repository;

import com.kuba.carrentalcompany3.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
    Client findClientById();
}

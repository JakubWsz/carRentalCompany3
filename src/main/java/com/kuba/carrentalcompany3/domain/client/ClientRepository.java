package com.kuba.carrentalcompany3.domain.client;

import com.kuba.carrentalcompany3.domain.client.model.Client;

import java.util.Optional;

public interface ClientRepository {
    Client save(Client client);
    boolean isEmailExists(String email);
    Optional<Client> getClient(String id);
    void update(Client client);
}

package com.kuba.carrentalcompany3.domain.client;

import com.kuba.carrentalcompany3.domain.client.model.Client;

public interface ClientRepository {
    Client save(Client client);
    boolean isEmailExists(String email);
}

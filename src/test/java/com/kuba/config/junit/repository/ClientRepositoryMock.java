package com.kuba.config.junit.repository;

import com.kuba.carrentalcompany3.domain.client.ClientRepository;
import com.kuba.carrentalcompany3.domain.client.model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientRepositoryMock implements ClientRepository {
    private final List<Client> clients = new ArrayList<>();

    @Override
    public Client save(Client client) {
        clients.add(client);
        return client;
    }

    @Override
    public boolean isEmailExists(String email) {
        return clients.stream()
                .anyMatch(client -> client.getEmail().equals(email));
    }

    @Override
    public Optional<Client> getClient(String id) {
        return clients.stream()
                .filter(client -> client.getDomainId().equals(id))
                .findAny();
    }

    @Override
    public void update(Client client) {
    save(client);
    }

    public void clean() {
        clients.clear();
    }
}
package com.kuba.carrentalcompany3.repository;

import com.kuba.carrentalcompany3.domain.client.ClientRepository;
import com.kuba.carrentalcompany3.domain.client.model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientRepositoryTest implements ClientRepository {
    private final List<Client> clients = new ArrayList<>();

    @Override
    public Client save(Client client) {
         clients.add(client);
         return client;
    }

    public Client getClient(){
        return clients.get(0);
//      return clients.stream()
//              .filter(client -> client.getEmail().equals(email))
//              .findAny();
    }

    public Optional<Client> getClientById(String id){
      return clients.stream()
              .filter(client -> client.getId().equals(id))
              .findAny();
    }
}

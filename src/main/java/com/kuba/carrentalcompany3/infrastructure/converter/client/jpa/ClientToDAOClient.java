package com.kuba.carrentalcompany3.infrastructure.converter.client.jpa;

import com.kuba.carrentalcompany3.domain.client.model.Client;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.client.entity.ClientDAO;
import org.springframework.core.convert.converter.Converter;

public class ClientToDAOClient implements Converter<Client, ClientDAO> {
    @Override
    public ClientDAO convert(Client client) {
        return new ClientDAO(
                client.getDomainId(),
                client.getFirstname(),
                client.getLastname(),
                client.getEmail(),
                client.getPassword(),
                client.getBirthdate());
    }
}

package com.kuba.carrentalcompany3.infrastructure.converter.client.jpa;

import com.kuba.carrentalcompany3.domain.client.model.Client;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.client.entity.ClientDao;
import org.springframework.core.convert.converter.Converter;

public class ClientToDaoClientConverter implements Converter<Client, ClientDao> {
    @Override
    public ClientDao convert(Client client) {
        return new ClientDao(
                client.getId(),
                client.getFirstname(),
                client.getLastname(),
                client.getEmail(),
                client.getPassword(),
                client.getBirthdate());
    }
}

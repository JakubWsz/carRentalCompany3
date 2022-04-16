package com.kuba.carrentalcompany3.infrastructure.converter.client.jpa;

import com.kuba.carrentalcompany3.domain.client.model.Client;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.client.entity.ClientDao;
import org.springframework.core.convert.converter.Converter;

public class ClientDaoToClientConverter implements Converter<ClientDao, Client> {
    @Override
    public Client convert(ClientDao clientDao) {
        return new Client.ClientBuilder()
                .setId(clientDao.getDomainId())
                .setFirstname(clientDao.getFirstname())
                .setLastname(clientDao.getLastname())
                .setEmail(clientDao.getEmail())
                .setPassword(clientDao.getPassword())
                .setBirthdate(clientDao.getBirthdate())
                .build();
    }
}

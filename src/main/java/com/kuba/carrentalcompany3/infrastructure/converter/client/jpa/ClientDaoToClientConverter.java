package com.kuba.carrentalcompany3.infrastructure.converter.client.jpa;

import com.kuba.carrentalcompany3.domain.client.model.Client;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.client.entity.ClientDao;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ClientDaoToClientConverter implements Converter<ClientDao, Client> {
    @Override
    public Client convert(ClientDao clientDao) {
        return new Client(
                clientDao.getDomainId(),
                clientDao.getFirstname(),
                clientDao.getLastname(),
                clientDao.getEmail(),
                clientDao.getPassword(),
                clientDao.getBirthdate());
    }
}

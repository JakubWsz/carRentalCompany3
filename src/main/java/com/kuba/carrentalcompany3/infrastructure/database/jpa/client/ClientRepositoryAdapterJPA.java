package com.kuba.carrentalcompany3.infrastructure.database.jpa.client;

import com.kuba.carrentalcompany3.domain.client.ClientRepository;
import com.kuba.carrentalcompany3.domain.client.model.Client;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.client.entity.ClientDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.ConversionService;

import java.time.LocalDateTime;
import java.util.Optional;

public class ClientRepositoryAdapterJPA implements ClientRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientRepositoryAdapterJPA.class);
    private final ClientRepositoryJPA clientRepositoryJPA;
    private final ConversionService conversionService;

    public ClientRepositoryAdapterJPA(ClientRepositoryJPA clientRepositoryJPA, ConversionService conversionService) {
        this.clientRepositoryJPA = clientRepositoryJPA;
        this.conversionService = conversionService;
    }

    @Override
    public Client save(Client client) {
        ClientDAO clientDao = clientRepositoryJPA.save(conversionService.convert(client, ClientDAO.class));
        return conversionService.convert(clientDao, Client.class);
    }

    @Override
    public boolean isEmailExists(String email) {
       return clientRepositoryJPA.existsByEmail(email);
    }

    @Override
    public Optional<Client> getClient(String domainId) {
        try {
            Optional<ClientDAO> clientDaoOptional = clientRepositoryJPA.findByDomainId(domainId);
            return Optional.ofNullable(conversionService.convert(clientDaoOptional.get(), Client.class));
        } catch (Exception e) {
            LOGGER.error("getClient error occurred", e);
            return Optional.empty();
        }
    }

    @Override
    public void update(Client client) {
        Optional<ClientDAO> clientDaoOptional = clientRepositoryJPA.findByDomainId(client.getDomainId());

        if (clientDaoOptional.isPresent() ){
            ClientDAO clientDAO = conversionService.convert(client, ClientDAO.class);
            clientDAO.assignIdForUpdatingObject(clientDaoOptional.get());
            clientDAO.setModificationDate(LocalDateTime.now());
            clientRepositoryJPA.save(clientDAO);
        }
    }
}

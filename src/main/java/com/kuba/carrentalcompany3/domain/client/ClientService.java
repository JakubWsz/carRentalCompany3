package com.kuba.carrentalcompany3.domain.client;

import com.kuba.carrentalcompany3.domain.client.model.Client;
import com.kuba.carrentalcompany3.domain.client.model.ClientFieldType;
import com.kuba.carrentalcompany3.domain.client.validator.ClientValidator;
import com.kuba.carrentalcompany3.domain.exception.ClientExceptionCode;
import com.kuba.carrentalcompany3.domain.exception.DomainException;

import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;

import static com.kuba.carrentalcompany3.domain.exception.ClientExceptionCode.EMAIL_ALREADY_EXISTS;

public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client createClient(String firstname, String lastname, String email, String password, LocalDate birthdate) {
        validateEmailDuplication(email);
        Client client = new Client.ClientBuilder()
                .setId( UUID.randomUUID().toString())
                .setFirstname(firstname)
                .setLastname(lastname)
                .setEmail(email)
                .setPassword(password)
                .setBirthdate(birthdate)
                .build();
        ClientValidator.validateClient(client);
        return clientRepository.save(client);
    }

    private void validateEmailDuplication(String email) {
        if (clientRepository.isEmailExists(email))
            throw new DomainException(EMAIL_ALREADY_EXISTS, email);
    }

    public void updateClient(Map<ClientFieldType, String> fieldUpdates, String id) {
        Client client = getClient(id);
        ClientFieldsUpdater.updateAll(client, fieldUpdates);
        clientRepository.update(client);
    }

    private Client getClient(String domainId) {
        return clientRepository.getClient(domainId)
                .orElseThrow(() -> new DomainException(ClientExceptionCode.CLIENT_DOESNT_EXISTS));
    }
}

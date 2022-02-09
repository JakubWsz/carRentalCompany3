package com.kuba.carrentalcompany3.domain.client;

import com.kuba.carrentalcompany3.domain.client.model.Client;
import com.kuba.carrentalcompany3.domain.validator.ClientValidator;

import java.time.LocalDate;
import java.util.UUID;

public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client createAccount(String firstname, String lastname, String email, String password, LocalDate birthdate) {
       validateEmailDuplication(email);
        Client client = new Client(
                UUID.randomUUID().toString(),
                firstname,
                lastname,
                email,
                password,
                birthdate);
        ClientValidator.validateClient(client);
        return clientRepository.save(client);
    }

    private void validateEmailDuplication(String email){
       if (clientRepository.isEmailExists(email))
           throw new RuntimeException(String.format("Provided email '%s' already exists", email));
    }
}

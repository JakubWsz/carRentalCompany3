package com.kuba.carrentalcompany3.api.controller;

import com.kuba.carrentalcompany3.api.dto.request.CreateAccountRequest;
import com.kuba.carrentalcompany3.api.dto.response.ClientView;
import com.kuba.carrentalcompany3.domain.client.ClientService;
import com.kuba.carrentalcompany3.domain.client.model.Client;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {
    private final ConversionService conversionService;
    private final ClientService clientService;

    public ClientController(ConversionService conversionService, ClientService clientService) {
        this.conversionService = conversionService;
        this.clientService = clientService;
    }

    @PostMapping("/create-account")
    public ResponseEntity<ClientView> createAccount(@RequestBody CreateAccountRequest createAccountRequest) {
        Client client = clientService.createAccount(
                createAccountRequest.getFirstname(),
                createAccountRequest.getLastname(),
                createAccountRequest.getEmail(),
                createAccountRequest.getPassword(),
                createAccountRequest.getBirthdate());
        return new ResponseEntity<>(conversionService.convert(client, ClientView.class), HttpStatus.CREATED);
    }
}

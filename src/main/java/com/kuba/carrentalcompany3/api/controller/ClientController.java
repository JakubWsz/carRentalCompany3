package com.kuba.carrentalcompany3.api.controller;

import com.kuba.carrentalcompany3.api.rest.CreateAccountRequest;
import com.kuba.carrentalcompany3.entity.Client;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("create-account")
    public Client createAccount(@RequestBody CreateAccountRequest createAccountRequest) {
        return clientService.createAccount(
                createAccountRequest.getFirstname(),
                createAccountRequest.getLastname(),
                createAccountRequest.getBirthdate(),
                createAccountRequest.getBirthdate(),
                createAccountRequest.getPassword()
        );
    }

    @PostMapping("login")
    public void login(@RequestParam String email, @RequestParam String password) {
        return clientService.login(email, password);
    }

    @PostMapping("logout")
    public void logout(@RequestParam long id) {
        return clientService.logout(id);
    }
}

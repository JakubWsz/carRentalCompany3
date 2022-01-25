package com.kuba.carrentalcompany3.api.controller;

import com.kuba.carrentalcompany3.api.dto.request.CreateAccountRequest;
import com.kuba.carrentalcompany3.api.dto.response.ClientView;
import com.kuba.carrentalcompany3.domain.client.ClientService;
import com.kuba.carrentalcompany3.domain.client.model.Client;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
    private final ConversionService conversionService;
    private final ClientService clientService;

    public ClientController(ConversionService conversionService, ClientService clientService) {
        this.conversionService = conversionService;
        this.clientService = clientService;
    }

    @PostMapping("create-account")
    public ClientView createAccount(@RequestBody CreateAccountRequest createAccountRequest) {
        Client client = clientService.createAccount(
                createAccountRequest.getFirstname(),
                createAccountRequest.getLastname(),
                createAccountRequest.getEmail(),
                createAccountRequest.getPassword(),
                createAccountRequest.getBirthdate());
        return conversionService.convert(client, ClientView.class);
    }
//
//    @PostMapping("login")
//    public void login(@RequestParam String email, @RequestParam String password) {
//        return clientService.login(email, password);
//    }
//
//    @PostMapping("logout")
//    public void logout(@RequestParam long id) {
//        return clientService.logout(id);
//    }
}

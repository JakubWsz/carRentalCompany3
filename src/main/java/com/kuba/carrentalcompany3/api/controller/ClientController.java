package com.kuba.carrentalcompany3.api.controller;

import com.kuba.carrentalcompany3.api.dto.FieldUpdateDTO;
import com.kuba.carrentalcompany3.api.dto.client.ClientView;
import com.kuba.carrentalcompany3.api.dto.client.request.CreateClientRequest;
import com.kuba.carrentalcompany3.api.dto.client.request.UpdateClientRequest;
import com.kuba.carrentalcompany3.domain.client.ClientService;
import com.kuba.carrentalcompany3.domain.client.model.Client;
import com.kuba.carrentalcompany3.domain.client.model.ClientFieldType;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/client")
public class ClientController {
    private final ConversionService conversionService;
    private final ClientService clientService;

    public ClientController(ConversionService conversionService, ClientService clientService) {
        this.conversionService = conversionService;
        this.clientService = clientService;
    }

    @PostMapping("/create")
    public ResponseEntity<ClientView> createClient(@RequestBody CreateClientRequest createClientRequest) {
        Client client = clientService.createClient(
                createClientRequest.getFirstname(),
                createClientRequest.getLastname(),
                createClientRequest.getEmail(),
                createClientRequest.getPassword(),
                createClientRequest.getBirthdate());
        return new ResponseEntity<>(conversionService.convert(client, ClientView.class), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}/update-data")
    public void updateOffice(@RequestBody UpdateClientRequest updateClientRequest, @PathVariable String id) {
        Map<ClientFieldType, String> fieldUpdates = updateClientRequest.getUpdateClient().stream()
                .collect(Collectors.toMap(FieldUpdateDTO::getFieldType, FieldUpdateDTO::getNewValue));
        clientService.updateClient(fieldUpdates, id);
    }
}

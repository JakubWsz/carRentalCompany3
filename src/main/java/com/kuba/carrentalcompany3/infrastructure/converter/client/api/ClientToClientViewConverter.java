package com.kuba.carrentalcompany3.infrastructure.converter.client.api;

import com.kuba.carrentalcompany3.api.dto.response.ClientView;
import com.kuba.carrentalcompany3.domain.client.model.Client;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ClientToClientViewConverter implements Converter<Client, ClientView> {
    @Override
    public ClientView convert(Client client) {
        return new ClientView(
                client.getId(),
                client.getFirstname(),
                client.getLastname(),
                client.getEmail(),
                client.getBirthdate());
    }
}

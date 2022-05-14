package com.kuba.carrentalcompany3.infrastructure.converter.client.api;

import com.kuba.carrentalcompany3.api.dto.client.ClientView;
import com.kuba.carrentalcompany3.domain.client.model.Client;
import org.springframework.core.convert.converter.Converter;

public class ClientToClientView implements Converter<Client, ClientView> {
    @Override
    public ClientView convert(Client client) {
        return new ClientView(
                client.getDomainId(),
                client.getFirstname(),
                client.getLastname(),
                client.getEmail(),
                client.getBirthdate());
    }
}

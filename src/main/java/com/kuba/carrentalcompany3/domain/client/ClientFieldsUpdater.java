package com.kuba.carrentalcompany3.domain.client;

import com.kuba.carrentalcompany3.domain.UpdateFieldProcess;
import com.kuba.carrentalcompany3.domain.client.model.Client;
import com.kuba.carrentalcompany3.domain.client.model.ClientFieldType;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Stream;

public enum ClientFieldsUpdater {
    EMAIL(ClientFieldType.EMAIL, Client::setEmail),
    PASSWORD(ClientFieldType.PASSWORD, Client::setPassword);

    private final ClientFieldType clientFieldType;
    private final UpdateFieldProcess<Client> updateFieldProcess;

    ClientFieldsUpdater(ClientFieldType clientFieldType, UpdateFieldProcess<Client> updateFieldProcess) {
        this.clientFieldType = clientFieldType;
        this.updateFieldProcess = updateFieldProcess;
    }

    public static void updateAll(Client client, Map<ClientFieldType, String> fieldUpdates) {
        fieldUpdates.forEach((obj, val) -> getByFieldType(obj).update(client, val));
    }

    public static ClientFieldsUpdater getByFieldType(ClientFieldType clientFieldType) {
        return Stream.of(ClientFieldsUpdater.values())
                .filter(clientFieldsUpdater -> clientFieldsUpdater.clientFieldType.equals(clientFieldType))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    private void update(Client client, String value) {
        if (Objects.nonNull(value)) {
            updateFieldProcess.update(client, value);
        }
    }
}

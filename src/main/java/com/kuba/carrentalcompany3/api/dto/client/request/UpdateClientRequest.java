package com.kuba.carrentalcompany3.api.dto.client.request;

import com.kuba.carrentalcompany3.api.dto.FieldUpdateDTO;
import com.kuba.carrentalcompany3.domain.client.model.ClientFieldType;
import com.kuba.carrentalcompany3.domain.employee.model.EmployeeFieldType;

import java.util.List;

public class UpdateClientRequest {
    private List<FieldUpdateDTO<ClientFieldType>> updateClient;

    public UpdateClientRequest() {
    }

    public UpdateClientRequest(List<FieldUpdateDTO<ClientFieldType>> updateClient) {
        this.updateClient = updateClient;
    }

    public List<FieldUpdateDTO<ClientFieldType>> getUpdateClient() {
        return updateClient;
    }
}

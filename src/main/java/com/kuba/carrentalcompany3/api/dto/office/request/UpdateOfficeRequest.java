package com.kuba.carrentalcompany3.api.dto.office.request;

import com.kuba.carrentalcompany3.api.dto.FieldUpdateDTO;
import com.kuba.carrentalcompany3.domain.office.model.OfficeFieldType;

import java.util.List;

public class UpdateOfficeRequest {
    private List<FieldUpdateDTO<OfficeFieldType>> updateOffice;

    public UpdateOfficeRequest() {
    }

    public UpdateOfficeRequest(List<FieldUpdateDTO<OfficeFieldType>> updateOffice) {
        this.updateOffice = updateOffice;
    }

    public List<FieldUpdateDTO<OfficeFieldType>> getUpdateEmployee() {
        return updateOffice;
    }
}

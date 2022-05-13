package com.kuba.carrentalcompany3.api.dto.employee.request;

import com.kuba.carrentalcompany3.api.dto.FieldUpdateDTO;
import com.kuba.carrentalcompany3.domain.employee.model.EmployeeFieldType;

import java.util.List;

public class UpdateEmployeeRequest {
    private List<FieldUpdateDTO<EmployeeFieldType>> updateEmployee;

    public UpdateEmployeeRequest() {
    }

    public UpdateEmployeeRequest(List<FieldUpdateDTO<EmployeeFieldType>> updateEmployee) {
        this.updateEmployee = updateEmployee;
    }

    public List<FieldUpdateDTO<EmployeeFieldType>> getUpdateEmployee() {
        return updateEmployee;
    }
}

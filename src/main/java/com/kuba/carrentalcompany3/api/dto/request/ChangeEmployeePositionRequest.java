package com.kuba.carrentalcompany3.api.dto.request;

import java.math.BigDecimal;

public class ChangeEmployeePositionRequest {
    private final BigDecimal salaryAmount;
    private final String position;

    public ChangeEmployeePositionRequest(BigDecimal salaryAmount, String position) {
        this.salaryAmount = salaryAmount;
        this.position = position;
    }

    public BigDecimal getSalaryAmount() {
        return salaryAmount;
    }

    public String getPosition() {
        return position;
    }
}

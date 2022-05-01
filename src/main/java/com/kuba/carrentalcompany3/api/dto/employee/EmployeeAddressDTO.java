package com.kuba.carrentalcompany3.api.dto.employee;

public class EmployeeAddressDTO {
    private final String employeeStreetAddress;
    private final String employeePostalCode;
    private final String employeeCityName;

    public EmployeeAddressDTO(String employeeStreetAddress, String employeePostalCode, String employeeCityName) {
        this.employeeStreetAddress = employeeStreetAddress;
        this.employeePostalCode = employeePostalCode;
        this.employeeCityName = employeeCityName;
    }

    public String getEmployeeStreetAddress() {
        return employeeStreetAddress;
    }

    public String getEmployeePostalCode() {
        return employeePostalCode;
    }

    public String getEmployeeCityName() {
        return employeeCityName;
    }
}

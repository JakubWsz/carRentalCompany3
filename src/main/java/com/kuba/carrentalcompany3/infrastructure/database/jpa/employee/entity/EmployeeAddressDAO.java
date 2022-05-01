package com.kuba.carrentalcompany3.infrastructure.database.jpa.employee.entity;

import javax.persistence.Embeddable;

@Embeddable
public class EmployeeAddressDAO {
    private String employeeStreetAddress;
    private String employeePostalCode;
    private String employeeCityName;

    public EmployeeAddressDAO() {
    }

    public EmployeeAddressDAO(String employeeStreetAddress, String employeePostalCode, String employeeCityName) {
        this.employeeStreetAddress = employeeStreetAddress;
        this.employeePostalCode = employeePostalCode;
        this.employeeCityName = employeeCityName;
    }

    public String getEmployeeStreetAddress() {
        return employeeStreetAddress;
    }

    public void setEmployeeStreetAddress(String employeeStreetAddress) {
        this.employeeStreetAddress = employeeStreetAddress;
    }

    public String getEmployeePostalCode() {
        return employeePostalCode;
    }

    public void setEmployeePostalCode(String employeePostalCode) {
        this.employeePostalCode = employeePostalCode;
    }

    public String getEmployeeCityName() {
        return employeeCityName;
    }

    public void setEmployeeCityName(String employeeCityName) {
        this.employeeCityName = employeeCityName;
    }
}
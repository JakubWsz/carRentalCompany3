package com.kuba.carrentalcompany3.api.dto.client.request;

import java.time.LocalDate;

public class CreateClientRequest {
    private final String firstname;
    private final String lastname;
    private final String email;
    private final String password;
    private final LocalDate birthdate;

    public CreateClientRequest(String firstname, String lastname, String email, String password, LocalDate birthdate) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.birthdate = birthdate;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }
}

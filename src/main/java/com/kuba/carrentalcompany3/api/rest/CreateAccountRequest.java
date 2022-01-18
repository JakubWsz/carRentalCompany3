package com.kuba.carrentalcompany3.api.rest;

import java.time.LocalDate;

public class CreateAccountRequest {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private LocalDate birthdate;

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

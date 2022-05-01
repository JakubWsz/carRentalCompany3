package com.kuba.carrentalcompany3.api.dto.client;

import java.time.LocalDate;

public class CreateClientRequest {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private LocalDate birthdate;

    public CreateClientRequest(String firstname, String lastname, String email, String password, LocalDate birthdate) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.birthdate = birthdate;
    }

    public CreateClientRequest() {
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

package com.kuba.carrentalcompany3.api.dto.response;

import java.time.LocalDate;

public class ClientView {
    private final String id;
    private final String firstname;
    private final String lastname;
    private final String email;
    private final LocalDate birthdate;

    public ClientView(String id, String firstname, String lastname, String email, LocalDate birthdate) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.birthdate = birthdate;
    }

    public String getId() {
        return id;
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

    public LocalDate getBirthdate() {
        return birthdate;
    }
}

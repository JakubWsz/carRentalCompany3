package com.kuba.carrentalcompany3.domain.client.model;

import java.time.LocalDate;

public class Client {
    private final String id;
    private final String firstname;
    private final String lastname;
    private final String email;
    private final String password;
    private final LocalDate birthdate;

    public Client(String id, String firstname, String lastname, String email, String password, LocalDate birthdate) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}

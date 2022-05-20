package com.kuba.carrentalcompany3.domain.client.model;

import java.time.LocalDate;

public class Client {
    private final String domainId;
    private final String firstname;
    private final String lastname;
    private String email;
    private String password;
    private final LocalDate birthdate;

    private Client(String id, String firstname, String lastname, String email, String password, LocalDate birthdate) {
        this.domainId = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.birthdate = birthdate;
    }

    public static class ClientBuilder {
        private String id;
        private String firstname;
        private String lastname;
        private String email;
        private String password;
        private LocalDate birthdate;

        public ClientBuilder setId(String id) {
            this.id = id;
            return this;
        }

        public ClientBuilder setFirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public ClientBuilder setLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public ClientBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public ClientBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public ClientBuilder setBirthdate(LocalDate birthdate) {
            this.birthdate = birthdate;
            return this;
        }

        public Client build() {
            return new Client(id, firstname, lastname, email, password, birthdate);
        }
    }

    public String getDomainId() {
        return domainId;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + domainId + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}

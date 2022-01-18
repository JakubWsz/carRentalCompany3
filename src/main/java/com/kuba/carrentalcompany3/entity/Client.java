package com.kuba.carrentalcompany3.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Client extends BaseEntity{
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private LocalDate birthdate;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Client client = (Client) o;
        return Objects.equals(firstname, client.firstname) && Objects.equals(lastname, client.lastname) && Objects.equals(email, client.email) && Objects.equals(password, client.password) && Objects.equals(birthdate, client.birthdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), firstname, lastname, email, password, birthdate);
    }

    @Override
    public String toString() {
        return "Client{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}

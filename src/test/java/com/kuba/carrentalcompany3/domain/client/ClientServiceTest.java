package com.kuba.carrentalcompany3.domain.client;

import com.kuba.carrentalcompany3.domain.client.model.Client;
import com.kuba.config.junit.repository.ClientRepositoryMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class ClientServiceTest {
    private static final String CLIENT_FIRSTNAME = "Jan";
    private static final String CLIENT_LASTNAME = "Rodo";
    private static final String CLIENT_EMAIL = "asd@gmail.com";
    private static final String CLIENT_PASSWORD = "Password6^";
    private static final LocalDate CLIENT_BIRTHDATE = LocalDate.ofYearDay(1992, 246);
    private static final ClientRepositoryMock repo = new ClientRepositoryMock();
    private static final ClientService clientService = new ClientService(repo);

    @BeforeEach
    void setUp() {
        repo.clean();
    }

    @Test
    void shouldSetPassedPersonalData() {
        //when
        Client createdAccount = clientService.createAccount(CLIENT_FIRSTNAME, CLIENT_LASTNAME,
                CLIENT_EMAIL, CLIENT_PASSWORD, CLIENT_BIRTHDATE);

        //then
        assertTrue(Objects.nonNull(createdAccount.getId()));
        assertFalse(createdAccount.getId().isBlank());
        assertEquals(createdAccount.getFirstname(), CLIENT_FIRSTNAME);
        assertEquals(createdAccount.getLastname(), CLIENT_LASTNAME);
        assertEquals(createdAccount.getEmail(), CLIENT_EMAIL);
        assertEquals(createdAccount.getPassword(), CLIENT_PASSWORD);
        assertEquals(createdAccount.getBirthdate(), CLIENT_BIRTHDATE);
    }

    @Test
    void shouldThrowExceptionWhenFirstnameIsNull() {

        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> clientService.createAccount(null, CLIENT_LASTNAME, CLIENT_EMAIL,
                        CLIENT_PASSWORD, CLIENT_BIRTHDATE));
        assertEquals("Pole z imieniem nie może być puste.", runtimeException.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenFirstnameIsLongerThen30Chars() {
        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> clientService.createAccount("Jannnnnnnnnnnnnnnnnnnnnnnnnnnnn",
                        CLIENT_LASTNAME, CLIENT_EMAIL,
                        CLIENT_PASSWORD, CLIENT_BIRTHDATE));
        assertEquals("Podane imię jest za długie.", runtimeException.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenLastNameIsNull() {
        //given
        ClientRepositoryMock repo = new ClientRepositoryMock();
        ClientService clientService = new ClientService(repo);
        Client client = new Client("xyz", "Jan", "Rodo", "asd@gmail.com", "Password6^",
                LocalDate.ofYearDay(1992, 246));
        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> clientService.createAccount(CLIENT_FIRSTNAME
                        , null, CLIENT_EMAIL,
                        CLIENT_PASSWORD, CLIENT_BIRTHDATE));
        assertEquals("Pole z nazwiskiem nie może być puste.", runtimeException.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenLastNameIsLongerThen30Chars() {
        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> clientService.createAccount(CLIENT_FIRSTNAME,
                        "Rodoooooooooooooooooooooooooooo", CLIENT_EMAIL,
                        CLIENT_PASSWORD, CLIENT_BIRTHDATE));
        assertEquals("Podane nazwisko jest za długie.", runtimeException.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenBirthdateIsNull() {
        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> clientService.createAccount(CLIENT_FIRSTNAME
                        , CLIENT_LASTNAME, CLIENT_EMAIL,
                        CLIENT_PASSWORD, null));
        assertEquals("Pole z imieniem nie może być puste.", runtimeException.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenClientIsUnderage() {
        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> clientService.createAccount(CLIENT_FIRSTNAME
                        , CLIENT_LASTNAME, CLIENT_EMAIL,
                        CLIENT_PASSWORD, LocalDate.ofYearDay(2006, 246)));
        assertEquals("Klienet jest niepełnoletni.", runtimeException.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenClientEmailIsNull() {
        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> clientService.createAccount(CLIENT_FIRSTNAME
                        , CLIENT_LASTNAME, null,
                        CLIENT_PASSWORD, CLIENT_BIRTHDATE));
        assertEquals("Pole z e-mailem nie może być puste.", runtimeException.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenClientPasswordIsNull() {
        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> clientService.createAccount(CLIENT_FIRSTNAME
                        , CLIENT_LASTNAME, CLIENT_EMAIL,
                        null, CLIENT_BIRTHDATE));
        assertEquals("Pole z hasłem nie może być puste.", runtimeException.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenClientEmailIsInvalid() {
        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> clientService.createAccount(CLIENT_FIRSTNAME
                        , CLIENT_LASTNAME, "abrakadabra",
                        CLIENT_PASSWORD, CLIENT_BIRTHDATE));
        assertEquals("Podany email jest nieprawidłowy.", runtimeException.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenClientPasswordIsToLong() {
        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> clientService.createAccount(CLIENT_FIRSTNAME
                        , CLIENT_LASTNAME, CLIENT_EMAIL,
                        "asdasdasdasdasdasdasdasdasL1@aa", CLIENT_BIRTHDATE));
        assertEquals("Podane hasło jest za długie.", runtimeException.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenClientPasswordIsToShort() {
        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> clientService.createAccount(CLIENT_FIRSTNAME
                        , CLIENT_LASTNAME, CLIENT_EMAIL,
                        "L1@aaaa", CLIENT_BIRTHDATE));
        assertEquals("Podane hasło jest za krótkie.", runtimeException.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenClientPasswordDontIncludeAnyCapitalLetter() {
        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> clientService.createAccount(CLIENT_FIRSTNAME
                        , CLIENT_LASTNAME, CLIENT_EMAIL,
                        "l1@aaaaa", CLIENT_BIRTHDATE));
        assertEquals("Podane hasło nie zawierda minimum jednej dużej litery.", runtimeException.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenClientPasswordDontIncludeAnySmallLetter() {
        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> clientService.createAccount(CLIENT_FIRSTNAME
                        , CLIENT_LASTNAME, CLIENT_EMAIL,
                        "L1@AAAAAA", CLIENT_BIRTHDATE));
        assertEquals("Podane hasło nie zawierda minimum jednej małej litery.", runtimeException.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenClientPasswordDontIncludeAnyNumbers() {
        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> clientService.createAccount(CLIENT_FIRSTNAME
                        , CLIENT_LASTNAME, CLIENT_EMAIL,
                        "l@AAAAAA", CLIENT_BIRTHDATE));
        assertEquals("Podane hasło nie zawierda minimum jednej cyfry.", runtimeException.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenClientPasswordDontIncludeAnySpecialSigns() {
        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> clientService.createAccount(CLIENT_FIRSTNAME
                        , CLIENT_LASTNAME, CLIENT_EMAIL,
                        "l1AAAAAA", CLIENT_BIRTHDATE));
        assertEquals("Podane hasło nie zawierda minimum jednego znaku specjlanego.", runtimeException.getMessage());
    }

    @Test
    void shouldSetIdWhenCreateAccount() {
        //when
        //then
        Client createdAccount = clientService.createAccount(CLIENT_FIRSTNAME, CLIENT_LASTNAME,
                CLIENT_EMAIL, CLIENT_PASSWORD, CLIENT_BIRTHDATE);

        //then
        assertTrue(Objects.nonNull(createdAccount.getId()));
        assertFalse(createdAccount.getId().isBlank());
    }
}
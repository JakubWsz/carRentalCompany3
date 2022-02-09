package com.kuba.carrentalcompany3.domain.client;

import com.kuba.carrentalcompany3.domain.client.model.Client;
import com.kuba.config.junit.repository.ClientRepositoryMock;
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
        assertEquals("Client firstname is null", runtimeException.getMessage());
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
        assertEquals("Client firstname is loner then 30 signs", runtimeException.getMessage());
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
        assertEquals("Client lastname is null", runtimeException.getMessage());
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
        assertEquals("Client lastname is loner then 30 signs", runtimeException.getMessage());
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
        assertEquals("Client birthdate is null", runtimeException.getMessage());
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
        assertEquals("Client is underage", runtimeException.getMessage());
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
        assertEquals("Client email is null", runtimeException.getMessage());
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
        assertEquals("Client password is null", runtimeException.getMessage());
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
        assertEquals("Client email is invalid", runtimeException.getMessage());
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
        assertEquals("Client password is too long", runtimeException.getMessage());
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
        assertEquals("Client password is too short", runtimeException.getMessage());
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
        assertEquals("Client password don't include any capital letter", runtimeException.getMessage());
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
        assertEquals("Client password don't include any small letter", runtimeException.getMessage());
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
        assertEquals("Client password don't include any numbers", runtimeException.getMessage());
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
        assertEquals("Client password don't include any special signs", runtimeException.getMessage());
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
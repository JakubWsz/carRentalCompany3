package com.kuba.carrentalcompany3.domain.client;

import com.kuba.carrentalcompany3.domain.client.model.Client;
import com.kuba.carrentalcompany3.repository.ClientRepositoryTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ClientServiceTest {

    @Test
    void shouldSetPassedPersonalDataExceptId() {
        //given
        ClientRepositoryTest repo = new ClientRepositoryTest();
        ClientService clientService = new ClientService(repo);
        Client client = new Client(null, "Jan", "Rodo", "asd@gmail.com", "Password6^",
                LocalDate.ofYearDay(1992, 246));

        //when
       Client client2 = clientService.createAccount(
                client.getFirstname(),
                client.getLastname(),
                client.getEmail(),
                client.getPassword(),
                client.getBirthdate());

        //then
        Client client1  = repo.getClientById(client2.getId()).get();

        Assertions.assertEquals(client1.getFirstname(), "Jan");
        Assertions.assertEquals(client1.getLastname(), "Rodo");
        Assertions.assertEquals(client1.getEmail(), "asd@gmail.com");
        Assertions.assertEquals(client1.getPassword(), "Password6^");
        Assertions.assertEquals(client1.getBirthdate(), LocalDate.ofYearDay(1992, 246));
    }

    @Test
    void shouldThrowExceptionWhenFirstnameIsNull() {
        //given
        ClientRepositoryTest repo = new ClientRepositoryTest();
        ClientService clientService = new ClientService(repo);
        Client client = new Client("xyz", null, "Rodo", "asd@gmail.com", "Password6^",
                LocalDate.ofYearDay(1992, 246));
        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> clientService.createAccount(null,client.getLastname(),client.getEmail(),
                        client.getPassword(),client.getBirthdate()));
        Assertions.assertEquals("Client firstname is null", runtimeException.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenFirstnameIsLongerThen30Chars() {
        //given
        ClientRepositoryTest repo = new ClientRepositoryTest();
        ClientService clientService = new ClientService(repo);
        Client client = new Client("xyz", null, "Rodo", "asd@gmail.com", "Password6^",
                LocalDate.ofYearDay(1992, 246));
        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> clientService.createAccount("Jannnnnnnnnnnnnnnnnnnnnnnnnnnnn"
                        ,client.getLastname(),client.getEmail(),
                        client.getPassword(),client.getBirthdate()));
        Assertions.assertEquals("Client firstname is loner then 30 signs", runtimeException.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenLastNameIsNull() {
        //given
        ClientRepositoryTest repo = new ClientRepositoryTest();
        ClientService clientService = new ClientService(repo);
        Client client = new Client("xyz", "Jan", "Rodo", "asd@gmail.com", "Password6^",
                LocalDate.ofYearDay(1992, 246));
        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> clientService.createAccount(client.getFirstname()
                        ,null,client.getEmail(),
                        client.getPassword(),client.getBirthdate()));
        Assertions.assertEquals("Client lastname is null", runtimeException.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenLastNameIsLongerThen30Chars() {
        //given
        ClientRepositoryTest repo = new ClientRepositoryTest();
        ClientService clientService = new ClientService(repo);
        Client client = new Client("xyz", "Jan", "Rodo", "asd@gmail.com", "Password6^",
                LocalDate.ofYearDay(1992, 246));
        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> clientService.createAccount(client.getFirstname()
                        ,"Rodoooooooooooooooooooooooooooo",client.getEmail(),
                        client.getPassword(),client.getBirthdate()));
        Assertions.assertEquals("Client lastname is loner then 30 signs", runtimeException.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenBirthdateIsNull() {
        //given
        ClientRepositoryTest repo = new ClientRepositoryTest();
        ClientService clientService = new ClientService(repo);
        Client client = new Client("xyz", "Jan", "Rodo", "asd@gmail.com", "Password6^",
                LocalDate.ofYearDay(1992, 246));
        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> clientService.createAccount(client.getFirstname()
                        ,client.getLastname(),client.getEmail(),
                        client.getPassword(),null));
        Assertions.assertEquals("Client birthdate is null", runtimeException.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenClientIsUnderage() {
        //given
        ClientRepositoryTest repo = new ClientRepositoryTest();
        ClientService clientService = new ClientService(repo);
        Client client = new Client("xyz", "Jan", "Rodo", "asd@gmail.com", "Password6^",
                LocalDate.ofYearDay(1992, 246));
        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> clientService.createAccount(client.getFirstname()
                        ,client.getLastname(),client.getEmail(),
                        client.getPassword(), LocalDate.ofYearDay(2006, 246)));
        Assertions.assertEquals("Client is underage", runtimeException.getMessage());
    }
}
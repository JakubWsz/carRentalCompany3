package com.kuba.carrentalcompany3.domain.employee;

import com.kuba.carrentalcompany3.domain.Address;
import com.kuba.carrentalcompany3.domain.employee.model.Employee;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.employee.entity.ContractType;
import com.kuba.config.junit.repository.EmployeeRepositoryMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


class EmployeeServiceTest {
    private static final String FIRSTNAME = "Jan";
    private static final String LASTNAME = "Kowalski";
    private static final String STREET_ADDRESS = "Malinowa 19";
    private static final String POSTAL_CODE = "00-123";
    private static final String CITY_NAME = "Wodogrzmotów";
    private static final Address ADDRESS = new Address(
            STREET_ADDRESS, POSTAL_CODE, CITY_NAME);
    private static final String PESEL = "39062808299";
    private static final String ACCOUNT_NUMBER = "00847000017362211118980391";
    private static final BigDecimal SALARY = BigDecimal.valueOf(5500);
    private static final ContractType CONTRACT_TYPE = ContractType.B2B;
    private static final String POSITION = "custemmer service";
    private static final String OFFICE_ID = UUID.randomUUID().toString();

    private static final EmployeeRepositoryMock repo = new EmployeeRepositoryMock();
    private static final EmployeeService employeeService = new EmployeeService(repo);

    @BeforeEach
    void setUp() {
        repo.clean();
    }

    @Test
    void shouldSetPassedEmployeeData() {
        //when
        Employee createdEmployee = employeeService.createEmployee(FIRSTNAME, LASTNAME, ADDRESS, PESEL, ACCOUNT_NUMBER, SALARY,
                CONTRACT_TYPE, POSITION, OFFICE_ID);

        //then
        assertTrue(Objects.nonNull(createdEmployee.getId()));
        assertFalse(createdEmployee.getId().isBlank());
        assertEquals(createdEmployee.getFirstname(), FIRSTNAME);
        assertEquals(createdEmployee.getLastname(), LASTNAME);
        assertEquals(createdEmployee.getAddress(), ADDRESS);
        assertEquals(createdEmployee.getAccountNumber(), ACCOUNT_NUMBER);
        assertEquals(createdEmployee.getSalaryAmount(), SALARY);
        assertEquals(createdEmployee.getContractType(), CONTRACT_TYPE);
        assertEquals(createdEmployee.getPosition(), POSITION);
        assertEquals(createdEmployee.getOfficeId(), OFFICE_ID);
    }

    @Test
    void shouldThrowExceptionWhenFirstnameIsNull() {
        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> employeeService.createEmployee(null, LASTNAME, ADDRESS, PESEL, ACCOUNT_NUMBER, SALARY,
                        CONTRACT_TYPE, POSITION, OFFICE_ID));
        assertEquals("Pole z imieniem nie może być puste.", runtimeException.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenLastnameIsNull() {
        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> employeeService.createEmployee(FIRSTNAME, null, ADDRESS, PESEL, ACCOUNT_NUMBER, SALARY,
                        CONTRACT_TYPE, POSITION, OFFICE_ID));
        assertEquals("Pole z nazwiskiem nie może być puste.", runtimeException.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenStreetAddressIsNull() {

        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> employeeService.createEmployee(
                        FIRSTNAME, LASTNAME, new Address(null,POSTAL_CODE,CITY_NAME),
                         PESEL, ACCOUNT_NUMBER, SALARY, CONTRACT_TYPE, POSITION, OFFICE_ID));
        assertEquals("Adres nie może być pusty.", runtimeException.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenPostalCodeIsNull() {
        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> employeeService.createEmployee(FIRSTNAME, LASTNAME,
                        new Address(CITY_NAME,null,CITY_NAME), PESEL, ACCOUNT_NUMBER, SALARY,
                        CONTRACT_TYPE, POSITION, OFFICE_ID));
        assertEquals("Kod pocztowy nie może być pusty.", runtimeException.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenCityNameIsNull() {
        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> employeeService.createEmployee(FIRSTNAME, LASTNAME,
                        new Address(CITY_NAME,POSTAL_CODE,null), PESEL, ACCOUNT_NUMBER, SALARY,
                        CONTRACT_TYPE, POSITION, OFFICE_ID));
        assertEquals("Nazwa miasta nie może być pusta.", runtimeException.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenCityNameIsToLong() {
        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> employeeService.createEmployee(FIRSTNAME, LASTNAME,
                        new Address(STREET_ADDRESS,
                                POSTAL_CODE,"toLoooooooooooooooooooooooooooooooooooooooooooooooooooooooooong"),
                        PESEL, ACCOUNT_NUMBER, SALARY, CONTRACT_TYPE, POSITION, OFFICE_ID));
        assertEquals("Nazwa miasta jesst za długa.", runtimeException.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenCityNameIsToShort() {
        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> employeeService.createEmployee(FIRSTNAME, LASTNAME,
                        new Address(STREET_ADDRESS,POSTAL_CODE,"n"), PESEL, ACCOUNT_NUMBER, SALARY,
                        CONTRACT_TYPE, POSITION, OFFICE_ID));
        assertEquals("Nazwa miasta jest za krótka.", runtimeException.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenPostalCodeIsInvalid() {
        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> employeeService.createEmployee(FIRSTNAME, LASTNAME,
                        new Address(STREET_ADDRESS,"666-666",CITY_NAME), PESEL, ACCOUNT_NUMBER, SALARY,
                        CONTRACT_TYPE, POSITION, OFFICE_ID));
        assertEquals("Kod pocztowy jest nieprawidłowy.", runtimeException.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenAddressIsInvalid() {
        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> employeeService.createEmployee(FIRSTNAME, LASTNAME,
                        new Address("!@#$ad",POSTAL_CODE,CITY_NAME), PESEL, ACCOUNT_NUMBER, SALARY,
                        CONTRACT_TYPE, POSITION, OFFICE_ID));
        assertEquals("Adres jest nieprawidłowy.", runtimeException.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenPeselIsNull() {
        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> employeeService.createEmployee(FIRSTNAME, LASTNAME,
                        ADDRESS, null, ACCOUNT_NUMBER, SALARY, CONTRACT_TYPE, POSITION, OFFICE_ID));
        assertEquals("Pole z peselem nie może być puste.", runtimeException.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenAccountNumberIsNull() {
        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> employeeService.createEmployee(FIRSTNAME, LASTNAME,
                        ADDRESS, PESEL, null, SALARY, CONTRACT_TYPE, POSITION, OFFICE_ID));
        assertEquals("Pole z numerem konta nie może być puste.", runtimeException.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSalaryAmountIsNull() {
        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> employeeService.createEmployee(FIRSTNAME, LASTNAME,
                        ADDRESS, PESEL, ACCOUNT_NUMBER, null, CONTRACT_TYPE, POSITION, OFFICE_ID));
        assertEquals("Pole z kwotą pensji nie może być puste.", runtimeException.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenContractTypeIsNull() {
        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> employeeService.createEmployee(FIRSTNAME, LASTNAME,
                        ADDRESS, PESEL, ACCOUNT_NUMBER, SALARY, null, POSITION, OFFICE_ID));
        assertEquals("Pole z typem umowy nie może być puste.", runtimeException.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenPositionIsNull() {
        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> employeeService.createEmployee(FIRSTNAME, LASTNAME,
                        ADDRESS, PESEL, ACCOUNT_NUMBER, SALARY, CONTRACT_TYPE, null, OFFICE_ID));
        assertEquals("Pole ze stanowiskiem nie może być puste.", runtimeException.getMessage());
    }
}
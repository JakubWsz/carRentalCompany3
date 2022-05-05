package com.kuba.carrentalcompany3.domain.office;

import com.kuba.carrentalcompany3.domain.Address;
import com.kuba.carrentalcompany3.domain.office.model.Office;
import com.kuba.config.junit.repository.OfficeRepositoryMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class OfficeServiceTest {
    private static final String OFFICE_STREET_ADDRESS = "Malinowa 19";
    private static final String OFFICE_POSTAL_CODE = "00-123";
    private static final String OFFICE_CITY_NAME = "Wodogrzmotów";
    private static final String OFFICE_CEO = "Jan Rodo";
    private static final String OFFICE_WEBSITE_URL = "https://www.fura.pl/";
    private static final Address OFFICE_ADDRESS = new Address(
            OFFICE_STREET_ADDRESS, OFFICE_POSTAL_CODE, OFFICE_CITY_NAME);
    private final OfficeRepositoryMock repo = new OfficeRepositoryMock();
    private final OfficeService officeService = new OfficeService(repo);

    @BeforeEach
    void setUp() {
        repo.clean();
    }

    @Test
    void shouldSetPassedOfficeData() {
        //when
        Office createdOffice = officeService.createOffice(OFFICE_ADDRESS, OFFICE_WEBSITE_URL, OFFICE_CEO);

        //then
        assertTrue(Objects.nonNull(createdOffice.getDomainId()));
        assertFalse(createdOffice.getDomainId().isBlank());
        assertEquals(createdOffice.getAddress().getStreetAddress(), OFFICE_STREET_ADDRESS);
        assertEquals(createdOffice.getAddress().getPostalCode(), OFFICE_POSTAL_CODE);
        assertEquals(createdOffice.getAddress().getCityName(), OFFICE_CITY_NAME);
        assertEquals(createdOffice.getWebsiteURL(), OFFICE_WEBSITE_URL);
        assertEquals(createdOffice.getOfficeCEO(), OFFICE_CEO);
    }

    @Test
    void deleteOffice_ShouldSetIsDeletedTrue() {
        //when
        Office createdOffice = officeService.createOffice(OFFICE_ADDRESS, OFFICE_WEBSITE_URL, OFFICE_CEO);
        Office deletedOffice = officeService.deleteOffice(createdOffice.getDomainId());
        //then
        assertTrue(Objects.nonNull(deletedOffice.getDomainId()));
        assertFalse(deletedOffice.getDomainId().isBlank());
        assertTrue(createdOffice.isDeleted());

    }

    @Test
    void shouldThrowExceptionWhenOfficeStreetAddressIsNull() {
        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> officeService.createOffice(new Address(null, OFFICE_POSTAL_CODE,
                        OFFICE_CITY_NAME), OFFICE_WEBSITE_URL, OFFICE_CEO));
        assertEquals("Adres nie może być pusty.", runtimeException.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenOfficePostalCodeIsNull() {
        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> officeService.createOffice(new Address(OFFICE_STREET_ADDRESS, null,
                        OFFICE_CITY_NAME), OFFICE_WEBSITE_URL, OFFICE_CEO));
        assertEquals("Kod pocztowy nie może być pusty.", runtimeException.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenOfficeCityNameIsNull() {
        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> officeService.createOffice(new Address(OFFICE_STREET_ADDRESS, OFFICE_POSTAL_CODE,
                        null), OFFICE_WEBSITE_URL, OFFICE_CEO));
        assertEquals("Nazwa miasta nie może być pusta.", runtimeException.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenOfficeCityNameIsToLong() {
        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> officeService.createOffice(new Address(OFFICE_STREET_ADDRESS, OFFICE_POSTAL_CODE,
                                "tooLoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooong"),
                        OFFICE_WEBSITE_URL, OFFICE_CEO));
        assertEquals("Nazwa miasta jesst za długa.", runtimeException.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenOfficeCityNameIsToShort() {
        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> officeService.createOffice(new Address(OFFICE_STREET_ADDRESS, OFFICE_POSTAL_CODE,
                                "s"),
                        OFFICE_WEBSITE_URL, OFFICE_CEO));
        assertEquals("Nazwa miasta jest za krótka.", runtimeException.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenOfficePostalCodeIsInvalid() {
        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> officeService.createOffice(new Address(OFFICE_STREET_ADDRESS, "asd-123",
                        OFFICE_CITY_NAME), OFFICE_WEBSITE_URL, OFFICE_CEO));
        assertEquals("Kod pocztowy jest nieprawidłowy.", runtimeException.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenOfficeAddressIsInvalid() {
        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> officeService.createOffice(new Address("!@#$ad", OFFICE_POSTAL_CODE,
                        OFFICE_CITY_NAME), OFFICE_WEBSITE_URL, OFFICE_CEO));
        assertEquals("Adres jest nieprawidłowy.", runtimeException.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenOfficeWebsiteURLIsNull() {
        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> officeService.createOffice(new Address(OFFICE_STREET_ADDRESS, OFFICE_POSTAL_CODE,
                        OFFICE_CITY_NAME), null, OFFICE_CEO));
        assertEquals("URL nie możę być pusty.", runtimeException.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenOfficeWebsiteURLIsInvalid() {
        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> officeService.createOffice(new Address(OFFICE_STREET_ADDRESS, OFFICE_POSTAL_CODE,
                        OFFICE_CITY_NAME), "!@#$%^", OFFICE_CEO));
        assertEquals("URL jest niepoprawny.", runtimeException.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenOfficeCEOIsNull() {
        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> officeService.createOffice(new Address(OFFICE_STREET_ADDRESS, OFFICE_POSTAL_CODE,
                        OFFICE_CITY_NAME), OFFICE_WEBSITE_URL, null));
        assertEquals("Imię i nazwisko dyrektora nie może być puste.", runtimeException.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenOfficeCEOIsToLong() {
        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> officeService.createOffice(new Address(OFFICE_STREET_ADDRESS, OFFICE_POSTAL_CODE,
                                OFFICE_CITY_NAME), OFFICE_WEBSITE_URL,
                        "Loooooooooooooooooooooooooooooooooooooooooooooooooooong Name"));
        assertEquals("Imię lub nazwisko dyrektora jest za długie.", runtimeException.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenOfficeCEOIsToInvalid() {
        //when
        //then
        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                () -> officeService.createOffice(new Address(OFFICE_STREET_ADDRESS, OFFICE_POSTAL_CODE,
                                OFFICE_CITY_NAME), OFFICE_WEBSITE_URL,
                        "sm"));
        assertEquals("Imię lub nazwisko dyrektora jest za nieprawidłowe.", runtimeException.getMessage());
    }
}

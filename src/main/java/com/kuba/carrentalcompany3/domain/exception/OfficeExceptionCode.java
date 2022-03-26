package com.kuba.carrentalcompany3.domain.exception;

public enum OfficeExceptionCode implements ExceptionCode {
    OFFICE_STREET_ADDRESS_CANT_BE_NULL("O_01", "Adres nie może być pusty.", 409),
    OFFICE_POSTAL_CODE_CANT_BE_NULL("O_02", "Kod pocztowy nie może być pusty.", 409),
    OFFICE_CITY_NAME_CANT_BE_NULL("O_03", "Nazwa miasta nie może być pusta.", 409),
    CITY_NAME_IS_TOO_LONG("O_04", "Nazwa miasta jesst za długa.", 409),
    CITY_NAME_IS_TOO_SHORT("O_05", "Nazwa miasta jest za krótka.", 409),
    INVALID_POSTAL_CODE("O_06", "Kod pocztowy jest nieprawidłowy.", 409),
    INVALID_STREET_ADDRESS("O_07", "Adres jest nieprawidłowy.", 409),
    OFFICE_WEBSITE_CANT_BE_NULL("O_08", "URL nie możę być pusty.", 409),
    OFFICE_WEBSITE_IS_INVALID("O_09", "URL jest niepoprawny.", 409),
    OFFICE_CEO_CANT_BE_NULL("O_10", "Imię i nazwisko dyrektora nie może być puste.", 408),
    CEO_NAME_IS_TOO_LONG("O_11", "Imię lub nazwisko dyrektora jest za długie.", 409),
    CEO_NAME_IS_INVALID("O_12", "Imię lub nazwisko dyrektora jest za nieprawidłowe.", 409);

    private final String code;
    private final String message;
    private final int status;

    OfficeExceptionCode(String code, String message, int status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public int getStatus() {
        return status;
    }
}

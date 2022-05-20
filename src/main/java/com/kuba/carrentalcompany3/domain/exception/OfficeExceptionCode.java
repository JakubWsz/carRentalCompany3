package com.kuba.carrentalcompany3.domain.exception;

public enum OfficeExceptionCode implements ExceptionCode {
    OFFICE_WEBSITE_CANT_BE_NULL("O_001", "URL nie możę być pusty.", 409),
    OFFICE_WEBSITE_IS_INVALID("O_002", "URL jest niepoprawny.", 409),
    OFFICE_CEO_CANT_BE_NULL("O_003", "Imię i nazwisko dyrektora nie może być puste.", 408),
    CEO_NAME_IS_TOO_LONG("O_004", "Imię lub nazwisko dyrektora jest za długie.", 409),
    CEO_NAME_IS_INVALID("O_005", "Imię lub nazwisko dyrektora jest za nieprawidłowe.", 409);

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

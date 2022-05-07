package com.kuba.carrentalcompany3.domain.exception;

public enum AddressExceptionCode implements ExceptionCode{

    OFFICE_STREET_ADDRESS_CANT_BE_NULL("A_001", "Adres nie może być pusty.", 409),
    OFFICE_POSTAL_CODE_CANT_BE_NULL("A_002", "Kod pocztowy nie może być pusty.", 409),
    OFFICE_CITY_NAME_CANT_BE_NULL("A_003", "Nazwa miasta nie może być pusta.", 409),
    CITY_NAME_IS_TOO_LONG("A_004", "Nazwa miasta jesst za długa.", 409),
    CITY_NAME_IS_TOO_SHORT("A_005", "Nazwa miasta jest za krótka.", 409),
    INVALID_POSTAL_CODE("A_006", "Kod pocztowy jest nieprawidłowy.", 409),
    INVALID_STREET_ADDRESS("A_007", "Adres jest nieprawidłowy.", 409);

    private final String code;
    private final String message;
    private final int status;

    AddressExceptionCode(String code, String message, int status) {
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

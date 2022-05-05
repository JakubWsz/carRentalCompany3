package com.kuba.carrentalcompany3.domain.exception;

public enum EmployeeExceptionCode implements ExceptionCode{
    EMPLOYEE_DOESNT_EXISTS("E_001", "Pracownik nie istnieje.", 404),
    EMPLOYEE_ALREADY_DELETED("E_002", "Wybrana osoba nie jest już pranownikiem firmy.", 409),
    EMPLOYEE_STREET_ADDRESS_CANT_BE_NULL("E_03", "Adres nie może być pusty.", 409),
    EMPLOYEE_POSTAL_CODE_CANT_BE_NULL("E_04", "Kod pocztowy nie może być pusty.", 409),
    EMPLOYEE_CITY_NAME_CANT_BE_NULL("E_05", "Nazwa miasta nie może być pusta.", 409),
    CITY_NAME_IS_TOO_LONG("E_06", "Nazwa miasta jesst za długa.", 409),
    CITY_NAME_IS_TOO_SHORT("E_07", "Nazwa miasta jest za krótka.", 409),
    INVALID_POSTAL_CODE("E_08", "Kod pocztowy jest nieprawidłowy.", 409),
    INVALID_STREET_ADDRESS("OE_09", "Adres jest nieprawidłowy.", 409);

    private final String code;
    private final String message;
    private final int status;

     EmployeeExceptionCode(String code, String message, int status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }


    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {return message; }

    @Override
    public int getStatus() {
        return status;
    }
}

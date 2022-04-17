package com.kuba.carrentalcompany3.domain.exception;

public enum EmployeeExceptionCode implements ExceptionCode{
    EMPLOYEE_DOESNT_EXISTS("E_001", "Pracownik nie istnieje.", 404),
    EMPLOYEE_ALREADY_DELETED("E_002", "Wybrana osoba nie jest już pranownikiem firmy.", 409);

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
        return null;
    }

    @Override
    public String getMessage() {
        return null;
    }

    @Override
    public int getStatus() {
        return 0;
    }
}

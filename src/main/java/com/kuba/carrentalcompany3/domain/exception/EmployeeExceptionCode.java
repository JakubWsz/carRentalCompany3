package com.kuba.carrentalcompany3.domain.exception;

public enum EmployeeExceptionCode implements ExceptionCode{
    EMPLOYEE_DOESNT_EXISTS("E_001", "Pracownik nie istnieje.", 404),
    EMPLOYEE_ALREADY_DELETED("E_002", "Wybrana osoba nie jest już pranownikiem firmy.", 409),
    EMPLOYEE_FIRSTNAME_CANT_BE_NULL("E_003", "Pole z imieniem nie może być puste.",409),
    EMPLOYEE_LASTNAME_CANT_BE_NULL("E_003", "Pole z nazwiskiem nie może być puste.",409),
    EMPLOYEE_PESEL_CANT_BE_NULL("E_003", "Pole z peselem nie może być puste.",409),
    EMPLOYEE_ACCOUNT_NUMBER_CANT_BE_NULL("E_003", "Pole z numerem konta nie może być puste.",409),
    EMPLOYEE_SALARY_AMOUNT_CANT_BE_NULL("E_003", "Pole z kwotą pensji nie może być puste.",409),
    EMPLOYEE_CONTRACT_TYPE_CANT_BE_NULL("E_003", "Pole z typem umowy nie może być puste.",409),
    EMPLOYEE_POSITION_CANT_BE_NULL("E_003", "Pole ze stanowiskiem nie może być puste.",409);
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

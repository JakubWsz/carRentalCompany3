package com.kuba.carrentalcompany3.domain.exception;

public enum ExceptionCode {
    FIRSTNAME_CANT_BE_NULL("C_001", "Pole z imieniem nie może być puste.", 409),
    FIRSTNAME_IS_TOO_LONG("C_002", "Podane imię jest za długie.", 409),
    LASTNAME_CANT_BE_NULL("C_003", "Pole z nazwiskiem nie może być puste.", 409),
    LASTNAME_IS_TOO_LONG("C_004", "Podane nazwisko jest za długie.", 409),
    BIRTHDATE_CANT_BE_NULL("C_005", "Pole z datą urodzenia nie może być puste.", 409),
    CLIENT_IS_UNDERAGE("C_006", "Klienet jest niepełnoletni.", 409),
    EMAIL_CANT_BE_NULL("C_007", "Pole z e-mailem nie może być puste.", 409),
    PASSWORD_CANT_BE_NULL("C_008", "Pole z hasłem nie może być puste.", 409),
    EMAIL_IS_INVALID("C_009", "Podany email jest nieprawidłowy.", 409),
    PASSWORD_IS_TOO_LONG("C_010", "Podane hasło jest za długie.", 409),
    PASSWORD_IS_TOO_SHORT("C_011", "Podane hasło jest za krótkie.", 409),
    PASSWORD_DONT_INCLUDE_CAPITALS("C_012", "Podane hasło nie zawierda minimum jednej dużej litery.",
            409),
    PASSWORD_DONT_INCLUDE_SMALL_LETTERS("C_013", "Podane hasło nie zawierda minimum jednej małej litery.",
            409),
    PASSWORD_DONT_INCLUDE_NUMBERS("C_014", "Podane hasło nie zawierda minimum jednej cyfry.", 409),
    PASSWORD_DONT_INCLUDE_SPECIALS("C_015", "Podane hasło nie zawierda minimum jednego znaku specjlanego."
            , 409),
    EMAIL_ALREADY_EXISTS("C_016", "Konto o podanym e-mailu '%s' już istnieje.", 409);

    private final String code;
    private final String message;
    private final int status;

    ExceptionCode(String code, String message, int status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }
}


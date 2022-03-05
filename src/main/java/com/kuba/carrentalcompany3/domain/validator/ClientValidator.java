package com.kuba.carrentalcompany3.domain.validator;

import com.kuba.carrentalcompany3.domain.client.model.Client;
import com.kuba.carrentalcompany3.domain.exception.DomainException;
import com.kuba.carrentalcompany3.domain.exception.ExceptionCode;
import com.kuba.carrentalcompany3.lib.Assertion;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientValidator {
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-" +
                    "\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c" +
                    "\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*" +
                    "[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]" +
                    "|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a" +
                    "\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)" +
                    "\\])", Pattern.CASE_INSENSITIVE);
    public static final String NAME = "name";
    public static final String MESSAGE = "message";
    public static final int MAX_SIZE = 30;
    public static final int MIN_SIZE = 8;

    public static void validateClient(Client client) {
        validateIsFirstnameNotNull(client.getFirstname());
        validateFirstnameSize(client.getFirstname());
        validateIsLastnameNotNull(client.getLastname());
        validateLastnameSize(client.getLastname());
        validateIsBirthdateNotNull(client.getBirthdate());
        validateClientMajority(client.getBirthdate());
        validateIsEmailValid(client.getEmail());
        validatePassword(client.getPassword());
    }

    private static void validateIsFirstnameNotNull(String firstname) {
        Assertion.notNull(firstname, () -> new DomainException(ExceptionCode.FIRSTNAME_CANT_BE_NULL));
    }

    private static void validateFirstnameSize(String firstname) {
        Assertion.isBiggerEqualsThan(MAX_SIZE, firstname,
                () -> new DomainException(ExceptionCode.FIRSTNAME_IS_TOO_LONG, NAME));
    }

    private static void validateIsLastnameNotNull(String lastname) {
        Assertion.notNull(lastname, () -> new DomainException(ExceptionCode.LASTNAME_CANT_BE_NULL));
    }

    private static void validateLastnameSize(String firstname) {
        Assertion.isBiggerEqualsThan(MAX_SIZE, firstname,
                () -> new DomainException(ExceptionCode.LASTNAME_IS_TOO_LONG, NAME));
    }

    private static void validateIsBirthdateNotNull(LocalDate birthdate) {
        Assertion.notNull(birthdate, () -> new DomainException(ExceptionCode.FIRSTNAME_CANT_BE_NULL));
    }

    private static void validateClientMajority(LocalDate birthdate) {
        Assertion.isTrue(ValidatorAlgorithms.isAdult(birthdate),
                () -> new DomainException(ExceptionCode.CLIENT_IS_UNDERAGE, MESSAGE));
    }

    private static void validateIsPasswordNotNull(String password) {
        Assertion.notNull(password, () -> new DomainException(ExceptionCode.PASSWORD_CANT_BE_NULL));
    }

    private static void validatePasswordSize(String password) {
        Assertion.isBiggerEqualsThan(MAX_SIZE, password, () -> new DomainException(ExceptionCode.PASSWORD_IS_TOO_LONG));
        Assertion.isSmallerEqualsThan(MIN_SIZE, password, () -> new DomainException(ExceptionCode.PASSWORD_IS_TOO_SHORT));
    }

    private static void validatePassword(String password) {
        validateIsPasswordNotNull(password);
        validatePasswordSize(password);
        Assertion.isTrue(ValidatorAlgorithms.isAtLeastOneCapitalCharacter(password),
                () -> new DomainException(ExceptionCode.PASSWORD_DONT_INCLUDE_CAPITALS));
        Assertion.isTrue(ValidatorAlgorithms.isAtLeastOneSmallCharacterCharacter(password),
                () -> new DomainException(ExceptionCode.PASSWORD_DONT_INCLUDE_SMALL_LETTERS));
        Assertion.isTrue(ValidatorAlgorithms.isAtLeastOneNumberSign(password),
                () -> new DomainException(ExceptionCode.PASSWORD_DONT_INCLUDE_NUMBERS));
        Assertion.isTrue(ValidatorAlgorithms.isAtLeastOneSpecialSign(password),
                () -> new DomainException(ExceptionCode.PASSWORD_DONT_INCLUDE_SPECIALS));
    }

    private static void validateIsEmailValid(String email) {
        validateIsEmailNotNull(email);
        Assertion.isTrue(matchEmailRegex(email),
                () -> new DomainException(ExceptionCode.EMAIL_IS_INVALID, MESSAGE));
    }

    private static void validateIsEmailNotNull(String email) {
        Assertion.notNull(email, () -> new DomainException(ExceptionCode.EMAIL_CANT_BE_NULL));
    }

    private static boolean matchEmailRegex(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }
}

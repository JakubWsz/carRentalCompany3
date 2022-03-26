package com.kuba.carrentalcompany3.domain.client.validator;

import com.kuba.carrentalcompany3.domain.client.model.Client;
import com.kuba.carrentalcompany3.domain.exception.DomainException;
import com.kuba.carrentalcompany3.domain.exception.ClientExceptionCode;
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

    private static final Pattern VALID_FULL_NAME_REGEX = Pattern.compile("^[\\p{Lu}\\p{M}][\\p{L}\\p{M},.'-]+(?:" +
                    " [\\p{L}\\p{M},.'-]+)*$",
            Pattern.CASE_INSENSITIVE);

    public static final String MESSAGE = "message";
    public static final int MAX_SIZE = 30;
    public static final int MIN_SIZE = 8;

    public static void validateClient(Client client) {
        validateIsFirstnameNotNull(client.getFirstname());
        validateFirstnameSize(client.getFirstname());
        validateIsLastnameNotNull(client.getLastname());
        validateLastnameSize(client.getLastname());
        validateFullName(client.getFirstname(),client.getLastname());
        validateIsBirthdateNotNull(client.getBirthdate());
        validateClientMajority(client.getBirthdate());
        validateIsEmailValid(client.getEmail());
        validatePassword(client.getPassword());
    }

    private static void validateIsFirstnameNotNull(String firstname) {
        Assertion.notNull(firstname, () -> new DomainException(ClientExceptionCode.FIRSTNAME_CANT_BE_NULL));
    }

    private static void validateFirstnameSize(String firstname) {
        Assertion.isBiggerEqualsThan(MAX_SIZE, firstname,
                () -> new DomainException(ClientExceptionCode.FIRSTNAME_IS_TOO_LONG));
    }

    private static void validateIsLastnameNotNull(String lastname) {
        Assertion.notNull(lastname, () -> new DomainException(ClientExceptionCode.LASTNAME_CANT_BE_NULL));
    }

    private static void validateLastnameSize(String firstname) {
        Assertion.isBiggerEqualsThan(MAX_SIZE, firstname,
                () -> new DomainException(ClientExceptionCode.LASTNAME_IS_TOO_LONG));
    }

    private static void validateFullName(String firstname, String lastname) {
        Assertion.isTrue(matchFullNameRegex(firstname,lastname),
                () -> new DomainException(ClientExceptionCode.NAME_OR_SURNAME_IS_INVALID, MESSAGE));
    }

    private static void validateIsBirthdateNotNull(LocalDate birthdate) {
        Assertion.notNull(birthdate, () -> new DomainException(ClientExceptionCode.FIRSTNAME_CANT_BE_NULL));
    }

    private static void validateClientMajority(LocalDate birthdate) {
        Assertion.isTrue(ClientValidatorAlgorithms.isAdult(birthdate),
                () -> new DomainException(ClientExceptionCode.CLIENT_IS_UNDERAGE, MESSAGE));
    }

    private static void validateIsPasswordNotNull(String password) {
        Assertion.notNull(password, () -> new DomainException(ClientExceptionCode.PASSWORD_CANT_BE_NULL));
    }

    private static void validatePasswordSize(String password) {
        Assertion.isBiggerEqualsThan(MAX_SIZE, password,
                () -> new DomainException(ClientExceptionCode.PASSWORD_IS_TOO_LONG));
        Assertion.isSmallerEqualsThan(MIN_SIZE, password,
                () -> new DomainException(ClientExceptionCode.PASSWORD_IS_TOO_SHORT));
    }

    private static void validatePassword(String password) {
        validateIsPasswordNotNull(password);
        validatePasswordSize(password);
        Assertion.isTrue(ClientValidatorAlgorithms.isAtLeastOneCapitalCharacter(password),
                () -> new DomainException(ClientExceptionCode.PASSWORD_DONT_INCLUDE_CAPITALS));
        Assertion.isTrue(ClientValidatorAlgorithms.isAtLeastOneSmallCharacterCharacter(password),
                () -> new DomainException(ClientExceptionCode.PASSWORD_DONT_INCLUDE_SMALL_LETTERS));
        Assertion.isTrue(ClientValidatorAlgorithms.isAtLeastOneNumberSign(password),
                () -> new DomainException(ClientExceptionCode.PASSWORD_DONT_INCLUDE_NUMBERS));
        Assertion.isTrue(ClientValidatorAlgorithms.isAtLeastOneSpecialSign(password),
                () -> new DomainException(ClientExceptionCode.PASSWORD_DONT_INCLUDE_SPECIALS));
    }

    private static void validateIsEmailValid(String email) {
        validateIsEmailNotNull(email);
        Assertion.isTrue(matchEmailRegex(email),
                () -> new DomainException(ClientExceptionCode.EMAIL_IS_INVALID, MESSAGE));
    }

    private static void validateIsEmailNotNull(String email) {
        Assertion.notNull(email, () -> new DomainException(ClientExceptionCode.EMAIL_CANT_BE_NULL));
    }

    private static boolean matchEmailRegex(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    private static boolean matchFullNameRegex(String firstname,String lastname) {
        String fullName = firstname + lastname;
        Matcher matcher = VALID_FULL_NAME_REGEX.matcher(fullName);
        return matcher.find();
    }
}

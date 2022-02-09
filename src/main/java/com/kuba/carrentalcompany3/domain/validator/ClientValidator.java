package com.kuba.carrentalcompany3.domain.validator;

import com.kuba.carrentalcompany3.domain.client.model.Client;

import java.time.LocalDate;
import java.time.Period;
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

    public static void validateClient(Client client) {
        if ((client.getFirstname() == null)) {
            throw new RuntimeException("Client firstname is null");
        } else if (client.getFirstname().length() > 30) {
            throw new RuntimeException("Client firstname is loner then 30 signs");
        } else if (client.getLastname() == null) {
            throw new RuntimeException("Client lastname is null");
        } else if (client.getLastname().length() > 30) {
            throw new RuntimeException("Client lastname is loner then 30 signs");
        } else if (client.getBirthdate() == null) {
            throw new RuntimeException("Client birthdate is null");
        } else if (!isAdult(client.getBirthdate())) {
            throw new RuntimeException("Client is underage");
        } else if (client.getEmail() == null) {
            throw new RuntimeException("Client email is null");
        } else if (client.getPassword() == null) {
            throw new RuntimeException("Client password is null");
        } else if (!validateEmail(client.getEmail())) {
            throw new RuntimeException("Client email is invalid");
        } else if (client.getPassword().length() > 30) {
            throw new RuntimeException("Client password is too long");
        } else if (client.getPassword().length() < 8) {
            throw new RuntimeException("Client password is too short");
        } else if (!isAtLeastOneCapitalCharacter(client.getPassword())) {
            throw new RuntimeException("Client password don't include any capital letter");
        } else if (!isAtLeastOneSmallCharacterCharacter(client.getPassword())) {
            throw new RuntimeException("Client password don't include any small letter");
        } else if (!isAtLeastOneNumberSign(client.getPassword())) {
            throw new RuntimeException("Client password don't include any numbers");
        } else if (!isAtLeastOneSpecialSign(client.getPassword())) {
            throw new RuntimeException("Client password don't include any special signs");
        }
    }

    private static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    private static boolean isAtLeastOneCapitalCharacter(String passwordStr) {
        char[] passwordCharArray = passwordStr.toCharArray();
        boolean include = false;
        for (int i = 0; i <= passwordStr.length() - 1; i++) {
            if (passwordCharArray[i] >= 65 && passwordCharArray[i] <= 90) {
                include = true;
                break;
            }
        }
        return include;
    }

    private static boolean isAtLeastOneSmallCharacterCharacter(String passwordStr) {
        char[] passwordCharArray = passwordStr.toCharArray();
        boolean include = false;
        for (int i = 0; i <= passwordStr.length() - 1; i++) {
            if (passwordCharArray[i] >= 97 && passwordCharArray[i] <= 122) {
                include = true;
                break;
            }
        }
        return include;
    }

    private static boolean isAtLeastOneNumberSign(String passwordStr) {
        char[] passwordCharArray = passwordStr.toCharArray();
        boolean include = false;
        for (int i = 0; i <= passwordStr.length() - 1; i++) {
            if (passwordCharArray[i] >= 48 && passwordCharArray[i] <= 57) {
                include = true;
                break;
            }
        }
        return include;
    }

    private static boolean isAtLeastOneSpecialSign(String passwordStr) {
        char[] passwordCharArray = passwordStr.toCharArray();
        boolean include = false;
        for (int i = 0; i <= passwordStr.length() - 1; i++) {
            if ((passwordCharArray[i] >= 33 && passwordCharArray[i] <= 47)
                    || (passwordCharArray[i] >= 58 && passwordCharArray[i] <= 64)
                    || (passwordCharArray[i] >= 91 && passwordCharArray[i] <= 96)
                    || (passwordCharArray[i] >= 123 && passwordCharArray[i] <= 126)) {
                include = true;
                break;
            }
        }
        return include;
    }

    private static boolean isAdult(LocalDate birthdate) {
        Period period;
        period = Period.between(birthdate, LocalDate.now());
        return period.getYears() > Period.of(18, 0, 0).getYears();
    }
}

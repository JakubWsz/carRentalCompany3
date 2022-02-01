package com.kuba.carrentalcompany3.infrastructure.validator;

import com.kuba.carrentalcompany3.domain.client.model.Client;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientValidator {
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

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
        } else if (!findAtLeastOneCapitalCharacter(client.getPassword())) {
            throw new RuntimeException("Client password don't include any capital letter");
        } else if (!findAtLeastOneSmallCharacterCharacter(client.getPassword())) {
            throw new RuntimeException("Client password don't include any small letter");
        } else if (!findAtLeastOneNumberSign(client.getPassword())) {
            throw new RuntimeException("Client password don't include any numbers");
        } else if (!findAtLeastOneSpecialSign(client.getPassword())) {
            throw new RuntimeException("Client password don't include any special signs");
        }
    }

    private static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    private static boolean findAtLeastOneCapitalCharacter(String passwordStr) {
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

    private static boolean findAtLeastOneSmallCharacterCharacter(String passwordStr) {
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

    private static boolean findAtLeastOneNumberSign(String passwordStr) {
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

    private static boolean findAtLeastOneSpecialSign(String passwordStr) {
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

    private static boolean isAdult (LocalDate birthdate) {
        Period period;
        period = Period.between(birthdate, LocalDate.now());
        return period.getYears() > Period.of(18,0,0).getYears();
    }
}

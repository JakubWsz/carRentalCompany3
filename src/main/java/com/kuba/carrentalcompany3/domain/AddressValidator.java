package com.kuba.carrentalcompany3.domain;

import com.kuba.carrentalcompany3.domain.exception.AddressExceptionCode;
import com.kuba.carrentalcompany3.domain.exception.DomainException;
import com.kuba.carrentalcompany3.domain.exception.EmployeeExceptionCode;
import com.kuba.carrentalcompany3.domain.exception.OfficeExceptionCode;
import com.kuba.carrentalcompany3.lib.Assertion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressValidator {
    private static final Pattern VALID_POSTAL_CODE_REGEX = Pattern.compile("^[0-9]{2}-[0-9]{3}",
            Pattern.CASE_INSENSITIVE);
    private static final Pattern VALID_STREET_ADDRESS_REGEX = Pattern.compile("^[A-Za-z-0-9]",
            Pattern.CASE_INSENSITIVE);
    public static final int CITY_NAME_MAX_SIZE = 50;
    public static final int CITY_NAME_MIN_SIZE = 3;

    public static void validateAddressNotNull(Address address) {
        Assertion.notNull(address, () -> new DomainException(AddressExceptionCode.OFFICE_CANT_BE_NULL));
        Assertion.notNull(address.getStreetAddress(), () -> new DomainException(
                AddressExceptionCode.OFFICE_STREET_ADDRESS_CANT_BE_NULL));
        Assertion.notNull(address.getPostalCode(), () -> new DomainException(
                AddressExceptionCode.OFFICE_POSTAL_CODE_CANT_BE_NULL));
        Assertion.notNull(address.getCityName(), () -> new DomainException(
                AddressExceptionCode.OFFICE_CITY_NAME_CANT_BE_NULL));
        Assertion.notEmpty(address.getStreetAddress(), () -> new DomainException(
                AddressExceptionCode.OFFICE_STREET_ADDRESS_CANT_BE_NULL));
        Assertion.notEmpty(address.getPostalCode(), () -> new DomainException(
                AddressExceptionCode.OFFICE_POSTAL_CODE_CANT_BE_NULL));
    }

    public static void validateAddressData(Address address) {
        Assertion.isBiggerEqualsThan(AddressValidator.CITY_NAME_MAX_SIZE, address.getCityName(),
                () -> new DomainException(AddressExceptionCode.CITY_NAME_IS_TOO_LONG));

        Assertion.isSmallerEqualsThan(AddressValidator.CITY_NAME_MIN_SIZE, address.getCityName(),
                () -> new DomainException(AddressExceptionCode.CITY_NAME_IS_TOO_SHORT));

        Assertion.isTrue(AddressValidator.matchPostalCodeRegex(address.getPostalCode()),
                () -> new DomainException(AddressExceptionCode.INVALID_POSTAL_CODE));

        Assertion.isTrue(AddressValidator.matchStreetAddressRegex(address.getStreetAddress()),
                () -> new DomainException(AddressExceptionCode.INVALID_STREET_ADDRESS));
    }

    private static boolean matchPostalCodeRegex(String postalCode) {
        Matcher matcher = VALID_POSTAL_CODE_REGEX.matcher(postalCode);
        return matcher.find();
    }

    public static boolean matchStreetAddressRegex(String streetAddress) {
        Matcher matcher = VALID_STREET_ADDRESS_REGEX.matcher(streetAddress);
        return matcher.find();
    }

}

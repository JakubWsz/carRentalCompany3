package com.kuba.carrentalcompany3.domain;

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

    public static void validateIsOfficeAddressNotNull(Address officeAddress) {
        Assertion.notNull(officeAddress.getStreetAddress(), () -> new DomainException(
                OfficeExceptionCode.OFFICE_STREET_ADDRESS_CANT_BE_NULL));
        Assertion.notNull(officeAddress.getPostalCode(), () -> new DomainException(
                OfficeExceptionCode.OFFICE_POSTAL_CODE_CANT_BE_NULL));
        Assertion.notNull(officeAddress.getCityName(), () -> new DomainException(
                OfficeExceptionCode.OFFICE_CITY_NAME_CANT_BE_NULL));
        Assertion.notEmpty(officeAddress.getStreetAddress(), () -> new DomainException(
                OfficeExceptionCode.OFFICE_STREET_ADDRESS_CANT_BE_NULL));
        Assertion.notEmpty(officeAddress.getPostalCode(), () -> new DomainException(
                OfficeExceptionCode.OFFICE_POSTAL_CODE_CANT_BE_NULL));
    }

    public static void validateIsEmployeeAddressNotNull(Address employeeAddress) {
        Assertion.notNull(employeeAddress.getStreetAddress(), () -> new DomainException(
                EmployeeExceptionCode.EMPLOYEE_STREET_ADDRESS_CANT_BE_NULL));
        Assertion.notNull(employeeAddress.getPostalCode(), () -> new DomainException(
                EmployeeExceptionCode.EMPLOYEE_POSTAL_CODE_CANT_BE_NULL));
        Assertion.notNull(employeeAddress.getCityName(), () -> new DomainException(
                EmployeeExceptionCode.EMPLOYEE_CITY_NAME_CANT_BE_NULL));
        Assertion.notEmpty(employeeAddress.getStreetAddress(), () -> new DomainException(
                EmployeeExceptionCode.EMPLOYEE_STREET_ADDRESS_CANT_BE_NULL));
        Assertion.notEmpty(employeeAddress.getPostalCode(), () -> new DomainException(
                EmployeeExceptionCode.EMPLOYEE_POSTAL_CODE_CANT_BE_NULL));
    }

    public static void validateAddressData(Address officeAddress) {
        Assertion.isBiggerEqualsThan(AddressValidator.CITY_NAME_MAX_SIZE, officeAddress.getCityName(),
                () -> new DomainException(OfficeExceptionCode.CITY_NAME_IS_TOO_LONG));

        Assertion.isSmallerEqualsThan(AddressValidator.CITY_NAME_MIN_SIZE, officeAddress.getCityName(),
                () -> new DomainException(OfficeExceptionCode.CITY_NAME_IS_TOO_SHORT));

        Assertion.isTrue(AddressValidator.matchPostalCodeRegex(officeAddress.getPostalCode()),
                () -> new DomainException(OfficeExceptionCode.INVALID_POSTAL_CODE));

        Assertion.isTrue(AddressValidator.matchStreetAddressRegex(officeAddress.getStreetAddress()),
                () -> new DomainException(OfficeExceptionCode.INVALID_STREET_ADDRESS));
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

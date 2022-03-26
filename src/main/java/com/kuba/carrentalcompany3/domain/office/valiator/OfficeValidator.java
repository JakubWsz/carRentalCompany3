package com.kuba.carrentalcompany3.domain.office.valiator;

import com.kuba.carrentalcompany3.domain.exception.DomainException;
import com.kuba.carrentalcompany3.domain.exception.OfficeExceptionCode;
import com.kuba.carrentalcompany3.domain.office.model.Office;
import com.kuba.carrentalcompany3.domain.office.model.OfficeAddress;
import com.kuba.carrentalcompany3.lib.Assertion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OfficeValidator {

    private static final Pattern VALID_POSTAL_CODE_REGEX = Pattern.compile("^[0-9]{2}-[0-9]{3}",
            Pattern.CASE_INSENSITIVE);

    private static final Pattern VALID_STREET_ADDRESS_REGEX = Pattern.compile("^[A-Za-z-0-9]",
            Pattern.CASE_INSENSITIVE);

    private static final Pattern VALID_WEBSITE_URL_REGEX = Pattern.compile("^(https?|ftp|file)://[-a-zA-Z0-9" +
                    "+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]",
            Pattern.CASE_INSENSITIVE);

    private static final Pattern VALID_FULL_NAME_REGEX = Pattern.compile("^[\\p{Lu}\\p{M}][\\p{L}\\p{M},.'-]" +
                    "+(?: [\\p{L}\\p{M},.'-]+)*$",
            Pattern.CASE_INSENSITIVE);
    private static final int CITY_NAME_MAX_SIZE = 50;
    private static final int CITY_NAME_MIN_SIZE = 3;
    private static final int NAME_MAX_SIZE = 30;
    private static final int NAME_MIN_SIZE = 2;

    public static void validateOffice(Office office) {
        validateIsOfficeAddressNotNull(office.getOfficeAddress());
        validateOfficeAddressData(office.getOfficeAddress());
        validateIsOfficeWebsiteURLNotNull(office.getWebsiteURL());
        validateOfficeWebsiteURL(office.getWebsiteURL());
        validateIsOfficeCEONotNull(office.getOfficeCEO());
        validateOfficeCEO(office.getOfficeCEO());
    }

    private static void validateIsOfficeAddressNotNull(OfficeAddress officeAddress) {
        Assertion.notNull(officeAddress.getOfficeStreetAddress(), () -> new DomainException(
                OfficeExceptionCode.OFFICE_STREET_ADDRESS_CANT_BE_NULL));
        Assertion.notNull(officeAddress.getOfficePostalCode(), () -> new DomainException(
                OfficeExceptionCode.OFFICE_POSTAL_CODE_CANT_BE_NULL));
        Assertion.notNull(officeAddress.getOfficeCityName(), () -> new DomainException(
                OfficeExceptionCode.OFFICE_CITY_NAME_CANT_BE_NULL));
        Assertion.notEmpty(officeAddress.getOfficeStreetAddress(), () -> new DomainException(
                OfficeExceptionCode.OFFICE_STREET_ADDRESS_CANT_BE_NULL));
        Assertion.notEmpty(officeAddress.getOfficePostalCode(), () -> new DomainException(
                OfficeExceptionCode.OFFICE_POSTAL_CODE_CANT_BE_NULL));
    }

    private static void validateOfficeAddressData(OfficeAddress officeAddress) {
        Assertion.isBiggerEqualsThan(CITY_NAME_MAX_SIZE, officeAddress.getOfficeCityName(),
                () -> new DomainException(OfficeExceptionCode.CITY_NAME_IS_TOO_LONG));

        Assertion.isSmallerEqualsThan(CITY_NAME_MIN_SIZE, officeAddress.getOfficeCityName(),
                () -> new DomainException(OfficeExceptionCode.CITY_NAME_IS_TOO_SHORT));

        Assertion.isTrue(matchPostalCodeRegex(officeAddress.getOfficePostalCode()),
                () -> new DomainException(OfficeExceptionCode.INVALID_POSTAL_CODE));

        Assertion.isTrue(matchStreetAddressRegex(officeAddress.getOfficeStreetAddress()),
                () -> new DomainException(OfficeExceptionCode.INVALID_STREET_ADDRESS));
    }

    private static void validateIsOfficeWebsiteURLNotNull(String website) {
        Assertion.notNull(website, () -> new DomainException(
                OfficeExceptionCode.OFFICE_WEBSITE_CANT_BE_NULL));
        Assertion.notEmpty(website, () -> new DomainException(
                OfficeExceptionCode.OFFICE_WEBSITE_CANT_BE_NULL));
    }

    private static void validateOfficeWebsiteURL(String websiteURL) {
        Assertion.isTrue(matchWEBSITE_URLRegex(websiteURL), () -> new DomainException(
                OfficeExceptionCode.OFFICE_WEBSITE_IS_INVALID));
    }

    private static void validateIsOfficeCEONotNull(String officeCEO) {
        Assertion.notNull(officeCEO, () -> new DomainException(
                OfficeExceptionCode.OFFICE_CEO_CANT_BE_NULL));
    }

    private static void validateOfficeCEO(String officeCEO) {
        Assertion.isBiggerEqualsThan(NAME_MAX_SIZE, officeCEO,
                () -> new DomainException(OfficeExceptionCode.CEO_NAME_IS_TOO_LONG));

        Assertion.isTrue(matchCEONameRegex(officeCEO), () -> new DomainException(
                OfficeExceptionCode.CEO_NAME_IS_INVALID));
    }

    private static boolean matchPostalCodeRegex(String postalCode) {
        Matcher matcher = VALID_POSTAL_CODE_REGEX.matcher(postalCode);
        return matcher.find();
    }

    private static boolean matchStreetAddressRegex(String streetAddress) {
        Matcher matcher = VALID_STREET_ADDRESS_REGEX.matcher(streetAddress);
        return matcher.find();
    }

    private static boolean matchWEBSITE_URLRegex(String websiteURL) {
        Matcher matcher = VALID_WEBSITE_URL_REGEX.matcher(websiteURL);
        return matcher.find();
    }

    private static boolean matchCEONameRegex(String cEOName) {
        Matcher matcher = VALID_FULL_NAME_REGEX.matcher(cEOName);
        return matcher.find();
    }
}

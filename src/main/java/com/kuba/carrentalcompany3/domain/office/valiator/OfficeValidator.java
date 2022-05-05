package com.kuba.carrentalcompany3.domain.office.valiator;

import com.kuba.carrentalcompany3.domain.AddressValidator;
import com.kuba.carrentalcompany3.domain.exception.DomainException;
import com.kuba.carrentalcompany3.domain.exception.OfficeExceptionCode;
import com.kuba.carrentalcompany3.domain.office.model.Office;
import com.kuba.carrentalcompany3.lib.Assertion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OfficeValidator {
    private static final Pattern VALID_WEBSITE_URL_REGEX = Pattern.compile("^(https?|ftp|file)://[-a-zA-Z0-9" +
                    "+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]",
            Pattern.CASE_INSENSITIVE);
    private static final Pattern VALID_FULL_NAME_REGEX = Pattern.compile("^[\\p{Lu}\\p{M}][\\p{L}\\p{M},.'-]" +
                    "+(?: [\\p{L}\\p{M},.'-]+)*$",
            Pattern.CASE_INSENSITIVE);
    private static final int NAME_MAX_SIZE = 30;

    public static void validateOffice(Office office) {
        AddressValidator.validateIsOfficeAddressNotNull(office.getAddress());
        AddressValidator.validateAddressData(office.getAddress());
        validateIsOfficeWebsiteURLNotNull(office.getWebsiteURL());
        validateOfficeWebsiteURL(office.getWebsiteURL());
        validateIsOfficeCEONotNull(office.getOfficeCEO());
        validateOfficeCEO(office.getOfficeCEO());
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

    private static boolean matchWEBSITE_URLRegex(String websiteURL) {
        Matcher matcher = VALID_WEBSITE_URL_REGEX.matcher(websiteURL);
        return matcher.find();
    }

    private static boolean matchCEONameRegex(String cEOName) {
        Matcher matcher = VALID_FULL_NAME_REGEX.matcher(cEOName);
        return matcher.find();
    }
}

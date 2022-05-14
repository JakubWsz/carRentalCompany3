package com.kuba.carrentalcompany3.domain.office;

import com.kuba.carrentalcompany3.domain.UpdateFieldProcess;
import com.kuba.carrentalcompany3.domain.office.model.Office;
import com.kuba.carrentalcompany3.domain.office.model.OfficeFieldType;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Stream;

public enum OfficeFieldsUpdater {
    DOMAIN_ID(OfficeFieldType.DOMAIN_ID, Office::setDomainId),
    ADDRESS_STREET(OfficeFieldType.ADDRESS_STREET, Office::updateStreetAddress),
    ADDRESS_POSTAL_CODE(OfficeFieldType.ADDRESS_POSTAL_CODE, Office::updatePostalCode),
    ADDRESS_CITY_NAME(OfficeFieldType.ADDRESS_CITY_NAME, Office::updateCityName),
    WEBSITE_URL(OfficeFieldType.WEBSITE_URL, Office::setWebsiteURL),
    OFFICE_CEO(OfficeFieldType.OFFICE_CEO, Office::setOfficeCEO);

    private final OfficeFieldType officeFieldType;
    private final UpdateFieldProcess<Office> updateFieldProcess;

    OfficeFieldsUpdater(OfficeFieldType officeFieldType, UpdateFieldProcess<Office> updateFieldProcess) {
        this.officeFieldType = officeFieldType;
        this.updateFieldProcess = updateFieldProcess;
    }

    public static void updateAll(Office office, Map<OfficeFieldType, String> fieldUpdates) {
        fieldUpdates.forEach((obj, val) -> getByFieldType(obj).update(office, val));
    }

    public static OfficeFieldsUpdater getByFieldType(OfficeFieldType officeFieldType) {
        return Stream.of(OfficeFieldsUpdater.values())
                .filter(officeFieldsUpdater -> officeFieldsUpdater.officeFieldType.equals(officeFieldType))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    private void update(Office office, String value) {
        if (Objects.nonNull(value)) {
            updateFieldProcess.update(office, value);
        }
    }
}

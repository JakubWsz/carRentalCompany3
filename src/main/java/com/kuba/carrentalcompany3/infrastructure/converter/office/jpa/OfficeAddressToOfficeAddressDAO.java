package com.kuba.carrentalcompany3.infrastructure.converter.office.jpa;

import com.kuba.carrentalcompany3.domain.office.model.OfficeAddress;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.office.entity.OfficeAddressDAO;
import org.springframework.core.convert.converter.Converter;

public class OfficeAddressToOfficeAddressDAO implements Converter<OfficeAddress, OfficeAddressDAO> {
    @Override
    public OfficeAddressDAO convert(OfficeAddress officeAddress) {
        return new OfficeAddressDAO(
                officeAddress.getOfficeStreetAddress(),
                officeAddress.getOfficePostalCode(),
                officeAddress.getOfficeCityName()
        );
    }
}

package com.kuba.carrentalcompany3.infrastructure.converter.office.api;

import com.kuba.carrentalcompany3.domain.office.model.OfficeAddress;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.office.entity.OfficeAddressDao;
import org.springframework.core.convert.converter.Converter;

public class OfficeAddressToOfficeAddressDao implements Converter<OfficeAddress, OfficeAddressDao> {
    @Override
    public OfficeAddressDao convert(OfficeAddress officeAddress) {
        return new OfficeAddressDao(
                officeAddress.getOfficeStreetAddress(),
                officeAddress.getOfficePostalCode(),
                officeAddress.getOfficeCityName()
        );
    }
}

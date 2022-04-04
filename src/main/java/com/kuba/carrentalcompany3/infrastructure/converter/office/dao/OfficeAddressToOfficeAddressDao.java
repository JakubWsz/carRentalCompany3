package com.kuba.carrentalcompany3.infrastructure.converter.office.dao;

import com.kuba.carrentalcompany3.domain.office.model.OfficeAddress;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.office.entity.OfficeAddressDao;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class OfficeAddressToOfficeAddressDao implements Converter< OfficeAddress,OfficeAddressDao> {

    @Override
    public OfficeAddressDao convert(OfficeAddress officeAddress) {
        return new OfficeAddressDao(
                officeAddress.getOfficeStreetAddress(),
                officeAddress.getOfficePostalCode(),
                officeAddress.getOfficeCityName()
        );
    }
}
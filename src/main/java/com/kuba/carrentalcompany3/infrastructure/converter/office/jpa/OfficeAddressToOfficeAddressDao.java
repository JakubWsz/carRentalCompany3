package com.kuba.carrentalcompany3.infrastructure.converter.office.jpa;

import com.kuba.carrentalcompany3.domain.office.model.OfficeAddress;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.office.entity.OfficeAddressDao;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class OfficeAddressToOfficeAddressDao implements Converter<OfficeAddressDao, OfficeAddress> {
    @Override
    public OfficeAddress convert(OfficeAddressDao officeAddressDao) {
        return new OfficeAddress(
                officeAddressDao.getOfficeStreetAddress(),
                officeAddressDao.getOfficePostalCode(),
                officeAddressDao.getOfficeCityName()
        );
    }
}

package com.kuba.carrentalcompany3.infrastructure.converter.office.api;

import com.kuba.carrentalcompany3.domain.office.model.OfficeAddress;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.office.entity.OfficeAddressDao;
import org.springframework.core.convert.converter.Converter;

public class OfficeAddressDaoToOfficeAddress implements Converter<OfficeAddressDao, OfficeAddress> {
    @Override
    public OfficeAddress convert(OfficeAddressDao officeAddressDTO) {
        return new OfficeAddress(
                officeAddressDTO.getOfficeStreetAddress(),
                officeAddressDTO.getOfficePostalCode(),
                officeAddressDTO.getOfficeCityName()
        );
    }
}

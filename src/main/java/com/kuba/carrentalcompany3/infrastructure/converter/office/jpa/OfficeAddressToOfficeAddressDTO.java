package com.kuba.carrentalcompany3.infrastructure.converter.office.jpa;

import com.kuba.carrentalcompany3.api.dto.OfficeAddressDTO;
import com.kuba.carrentalcompany3.domain.office.model.OfficeAddress;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.office.entity.OfficeAddressDao;
import org.springframework.core.convert.converter.Converter;

public class OfficeAddressToOfficeAddressDTO implements Converter<OfficeAddress, OfficeAddressDTO> {
    @Override
    public OfficeAddressDTO convert(OfficeAddress officeAddress) {
        return new OfficeAddressDTO(
                officeAddress.getOfficeStreetAddress(),
                officeAddress.getOfficePostalCode(),
                officeAddress.getOfficeCityName()
        );
    }
}

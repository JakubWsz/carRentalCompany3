package com.kuba.carrentalcompany3.infrastructure.converter.office.api;

import com.kuba.carrentalcompany3.api.dto.office.OfficeAddressDTO;
import com.kuba.carrentalcompany3.domain.office.model.OfficeAddress;
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

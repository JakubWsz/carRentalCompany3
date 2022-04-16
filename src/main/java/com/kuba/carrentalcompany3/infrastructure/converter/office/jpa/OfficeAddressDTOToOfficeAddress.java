package com.kuba.carrentalcompany3.infrastructure.converter.office.jpa;

import com.kuba.carrentalcompany3.api.dto.OfficeAddressDTO;
import com.kuba.carrentalcompany3.domain.office.model.OfficeAddress;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

public class OfficeAddressDTOToOfficeAddress  implements Converter<OfficeAddressDTO, OfficeAddress> {
    @Override
    public OfficeAddress convert(OfficeAddressDTO officeAddressDTO) {
        return new OfficeAddress(
                officeAddressDTO.getOfficeStreetAddress(),
                officeAddressDTO.getOfficePostalCode(),
                officeAddressDTO.getOfficeCityName()
        );
    }
}

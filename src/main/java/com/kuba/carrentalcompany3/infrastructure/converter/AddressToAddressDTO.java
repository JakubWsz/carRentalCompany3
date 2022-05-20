package com.kuba.carrentalcompany3.infrastructure.converter;

import com.kuba.carrentalcompany3.api.dto.AddressDTO;
import com.kuba.carrentalcompany3.domain.Address;
import org.springframework.core.convert.converter.Converter;

public class AddressToAddressDTO implements Converter<Address, AddressDTO> {
    @Override
    public AddressDTO convert(Address officeAddress) {
        return new AddressDTO(
                officeAddress.getStreetAddress(),
                officeAddress.getPostalCode(),
                officeAddress.getCityName()
        );
    }
}

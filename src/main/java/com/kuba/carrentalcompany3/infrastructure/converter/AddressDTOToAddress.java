package com.kuba.carrentalcompany3.infrastructure.converter;

import com.kuba.carrentalcompany3.api.dto.AddressDTO;
import com.kuba.carrentalcompany3.domain.Address;
import org.springframework.core.convert.converter.Converter;

public class AddressDTOToAddress implements Converter<AddressDTO, Address> {
    @Override
    public Address convert(AddressDTO addressDTO) {
        return new Address(
                addressDTO.getStreetAddress(),
                addressDTO.getPostalCode(),
                addressDTO.getCityName());
    }
}

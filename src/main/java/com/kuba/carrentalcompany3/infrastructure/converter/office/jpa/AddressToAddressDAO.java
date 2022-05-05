package com.kuba.carrentalcompany3.infrastructure.converter.office.jpa;

import com.kuba.carrentalcompany3.domain.Address;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.AddressDAO;
import org.springframework.core.convert.converter.Converter;

public class AddressToAddressDAO implements Converter<Address, AddressDAO> {
    @Override
    public AddressDAO convert(Address officeAddress) {
        return new AddressDAO(
                officeAddress.getStreetAddress(),
                officeAddress.getPostalCode(),
                officeAddress.getCityName()
        );
    }
}

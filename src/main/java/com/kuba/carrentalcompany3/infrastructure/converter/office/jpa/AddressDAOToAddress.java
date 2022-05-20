package com.kuba.carrentalcompany3.infrastructure.converter.office.jpa;

import com.kuba.carrentalcompany3.domain.Address;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.AddressDAO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AddressDAOToAddress implements Converter<AddressDAO, Address> {

    @Override
    public Address convert(AddressDAO officeAddressDao) {
        return new Address(
                officeAddressDao.getStreetAddress(),
                officeAddressDao.getPostalCode(),
                officeAddressDao.getCityName()
        );
    }
}

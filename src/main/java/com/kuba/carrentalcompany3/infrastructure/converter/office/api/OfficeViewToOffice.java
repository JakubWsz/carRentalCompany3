package com.kuba.carrentalcompany3.infrastructure.converter.office.api;

import com.kuba.carrentalcompany3.api.dto.AddressDTO;
import com.kuba.carrentalcompany3.api.dto.office.OfficeView;
import com.kuba.carrentalcompany3.domain.Address;
import com.kuba.carrentalcompany3.domain.office.model.Office;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class OfficeViewToOffice implements Converter<OfficeView, Office> {

    @Override
    public Office convert(OfficeView officeView) {
        AddressDTO addressDTO = officeView.getAddressDTO();
        return new Office.OfficeBuilder()
                .setId(officeView.getId())
                .setAddress(new Address(addressDTO.getStreetAddress(),
                        addressDTO.getPostalCode(),
                        addressDTO.getCityName()))
                .setWebsiteURL(officeView.getWebsiteURL())
                .setOfficeCEO(officeView.getOfficeCEO())
                .setDeleted(false)
                .build();
    }
}

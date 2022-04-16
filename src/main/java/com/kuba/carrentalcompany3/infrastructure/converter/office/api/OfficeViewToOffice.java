package com.kuba.carrentalcompany3.infrastructure.converter.office.api;

import com.kuba.carrentalcompany3.api.dto.OfficeAddressDTO;
import com.kuba.carrentalcompany3.api.dto.response.OfficeView;
import com.kuba.carrentalcompany3.domain.office.model.Office;
import com.kuba.carrentalcompany3.domain.office.model.OfficeAddress;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class OfficeViewToOffice implements Converter<OfficeView, Office> {

    @Override
    public Office convert(OfficeView officeView) {
        OfficeAddressDTO officeAddressDTO = officeView.getOfficeAddress();
        return new Office.OfficeBuilder()
                .setId(officeView.getId())
                .setOfficeAddress(new OfficeAddress(officeAddressDTO.getOfficeStreetAddress(),
                                officeAddressDTO.getOfficePostalCode(),
                                officeAddressDTO.getOfficeCityName()))
                .setWebsiteURL(officeView.getWebsiteURL())
                .setOfficeCEO(officeView.getOfficeCEO())
                .setDeleted(false)
                .build();
    }
}

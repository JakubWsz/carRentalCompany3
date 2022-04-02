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
//    @Lazy
//    private final ConversionService conversionService;
//
//    public OfficeViewToOffice(ConversionService conversionService) {
//        this.conversionService = conversionService;
//    }

    @Override
    public Office convert(OfficeView officeView) {
       OfficeAddressDTO officeAddressDTO = officeView.getOfficeAddress();
        return new Office(
                officeView.getId(),
               // conversionService.convert(officeView.getOfficeAddress(), OfficeAddress.class),
                new OfficeAddress(officeAddressDTO.getOfficeStreetAddress(),officeAddressDTO.getOfficePostalCode(),
                        officeAddressDTO.getOfficeCityName()),
                officeView.getWebsiteURL(),
                officeView.getOfficeCEO(),
                false
        );
    }
}

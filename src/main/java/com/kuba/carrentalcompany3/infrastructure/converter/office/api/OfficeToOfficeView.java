package com.kuba.carrentalcompany3.infrastructure.converter.office.api;

import com.kuba.carrentalcompany3.api.dto.AddressDTO;
import com.kuba.carrentalcompany3.api.dto.office.OfficeView;
import com.kuba.carrentalcompany3.domain.office.model.Office;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

public class OfficeToOfficeView implements Converter<Office, OfficeView> {
    private final ConversionService conversionService;

    public OfficeToOfficeView(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public OfficeView convert(Office office) {
        return new OfficeView(
                office.getId(),
                conversionService.convert(office.getAddress(), AddressDTO.class),
                office.getWebsiteURL(),
                office.getOfficeCEO()
        );
    }
}

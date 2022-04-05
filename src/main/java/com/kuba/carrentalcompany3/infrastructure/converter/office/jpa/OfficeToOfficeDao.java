package com.kuba.carrentalcompany3.infrastructure.converter.office.jpa;

import com.kuba.carrentalcompany3.domain.office.model.Office;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.office.entity.OfficeAddressDao;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.office.entity.OfficeDao;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

public class OfficeToOfficeDao implements Converter<Office, OfficeDao> {
    private final ConversionService conversionService;

    public OfficeToOfficeDao(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public OfficeDao convert(Office office) {
        return new OfficeDao(
                office.getId(),
                conversionService.convert(office.getOfficeAddress(), OfficeAddressDao.class),
                office.getWebsiteURL(),
                office.getOfficeCEO()
        );
    }
}

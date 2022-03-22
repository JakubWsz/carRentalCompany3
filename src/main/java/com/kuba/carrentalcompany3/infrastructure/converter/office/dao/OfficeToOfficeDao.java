package com.kuba.carrentalcompany3.infrastructure.converter.office.dao;

import com.kuba.carrentalcompany3.domain.office.model.Office;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.office.entity.OfficeAddressDao;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.office.entity.OfficeDao;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class OfficeToOfficeDao implements Converter<Office, OfficeDao> {
    @Lazy
    private final ConversionService converter;

    public OfficeToOfficeDao(ConversionService converter) {
        this.converter = converter;
    }

    @Override
    public OfficeDao convert(Office office) {
        return new OfficeDao(
                office.getId(),
                converter.convert(office.getOfficeAddress(), OfficeAddressDao.class),
                office.getWebsiteURL(),
                office.getOfficeCEO()
        );
    }
}

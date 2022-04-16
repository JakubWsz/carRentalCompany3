package com.kuba.carrentalcompany3.infrastructure.converter.office.jpa;

import com.kuba.carrentalcompany3.domain.office.model.Office;
import com.kuba.carrentalcompany3.domain.office.model.OfficeAddress;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.office.entity.OfficeDao;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

public class OfficeDaoOptionalToOffice implements Converter<OfficeDao, Office> {
    private final ConversionService conversionService;

    public OfficeDaoOptionalToOffice(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public Office convert(OfficeDao optionalOfficeDao) {
        return new Office(
                optionalOfficeDao.getDomainId(),
                conversionService.convert(optionalOfficeDao.getOfficeAddress(), OfficeAddress.class),
                optionalOfficeDao.getWebsiteURL(),
                optionalOfficeDao.getOfficeCEO(),
                optionalOfficeDao.isDeleted());
    }
}

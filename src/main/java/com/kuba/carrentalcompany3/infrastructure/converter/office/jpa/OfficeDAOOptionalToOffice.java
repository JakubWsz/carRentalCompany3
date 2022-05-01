package com.kuba.carrentalcompany3.infrastructure.converter.office.jpa;

import com.kuba.carrentalcompany3.domain.office.model.Office;
import com.kuba.carrentalcompany3.domain.office.model.OfficeAddress;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.office.entity.OfficeDAO;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

public class OfficeDAOOptionalToOffice implements Converter<OfficeDAO, Office> {
    private final ConversionService conversionService;

    public OfficeDAOOptionalToOffice(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public Office convert(OfficeDAO optionalOfficeDAO) {
        return new Office.OfficeBuilder()
                .setId(optionalOfficeDAO.getDomainId())
                .setOfficeAddress(conversionService.convert(optionalOfficeDAO.getOfficeAddress(), OfficeAddress.class))
                .setWebsiteURL(optionalOfficeDAO.getWebsiteURL())
                .setOfficeCEO(optionalOfficeDAO.getOfficeCEO())
                .setDeleted(optionalOfficeDAO.isDeleted())
                .build();
    }
}

package com.kuba.carrentalcompany3.infrastructure.converter.office.jpa;

import com.kuba.carrentalcompany3.domain.office.model.Office;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.AddressDAO;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.office.entity.OfficeDAO;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

public class OfficeToOfficeDAO implements Converter<Office, OfficeDAO> {
    private final ConversionService conversionService;

    public OfficeToOfficeDAO(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public OfficeDAO convert(Office office) {
        return new OfficeDAO(
                office.getDomainId(),
                conversionService.convert(office.getAddress(), AddressDAO.class),
                office.getWebsiteURL(),
                office.getOfficeCEO(),
                office.isDeleted()
        );
    }
}

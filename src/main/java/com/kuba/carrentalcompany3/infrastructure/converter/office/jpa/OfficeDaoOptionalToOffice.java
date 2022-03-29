package com.kuba.carrentalcompany3.infrastructure.converter.office.jpa;

import com.kuba.carrentalcompany3.domain.exception.DomainException;
import com.kuba.carrentalcompany3.domain.exception.ClientExceptionCode;
import com.kuba.carrentalcompany3.domain.office.model.Office;
import com.kuba.carrentalcompany3.domain.office.model.OfficeAddress;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.office.entity.OfficeDao;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OfficeDaoOptionalToOffice implements Converter<Optional<OfficeDao>, Office> {
    @Lazy
    private final ConversionService conversionService;

    public OfficeDaoOptionalToOffice(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public Office convert(Optional<OfficeDao> optionalOfficeDao) {
        if (optionalOfficeDao.isPresent()) {
            return new Office(
                    optionalOfficeDao.get().getDomainId(),
                    conversionService.convert(optionalOfficeDao.get().getOfficeAddress(),OfficeAddress.class),
                    optionalOfficeDao.get().getWebsiteURL(),
                    optionalOfficeDao.get().getOfficeCEO(),
                    optionalOfficeDao.get().isDeleted()
            );
        } else throw new DomainException(ClientExceptionCode.OFFICE_DOESNT_EXISTS);
    }
}

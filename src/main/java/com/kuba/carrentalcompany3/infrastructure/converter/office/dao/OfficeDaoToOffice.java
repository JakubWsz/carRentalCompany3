package com.kuba.carrentalcompany3.infrastructure.converter.office.dao;

import com.kuba.carrentalcompany3.domain.office.model.Office;
import com.kuba.carrentalcompany3.domain.office.model.OfficeAddress;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.office.entity.OfficeAddressDao;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.office.entity.OfficeDao;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class OfficeDaoToOffice implements Converter<OfficeDao, Office> {

    @Override
    public Office convert(OfficeDao officeDao) {
        OfficeAddressDao officeAddressDao = officeDao.getOfficeAddress();
        return new Office.OfficeBuilder()
                .setId(officeDao.getDomainId())
                .setOfficeAddress(new OfficeAddress(officeAddressDao.getOfficeStreetAddress(),
                        officeAddressDao.getOfficePostalCode(),
                        officeAddressDao.getOfficeCityName()))
                .setWebsiteURL(officeDao.getWebsiteURL())
                .setOfficeCEO(officeDao.getOfficeCEO())
                .setDeleted(officeDao.isDeleted())
                .build();
    }
}

package com.kuba.carrentalcompany3.infrastructure.converter.office.jpa;

import com.kuba.carrentalcompany3.domain.office.model.Office;
import com.kuba.carrentalcompany3.domain.office.model.OfficeAddress;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.office.entity.OfficeAddressDAO;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.office.entity.OfficeDAO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class OfficeDAOToOffice implements Converter<OfficeDAO, Office> {

    @Override
    public Office convert(OfficeDAO officeDao) {
        OfficeAddressDAO officeAddressDao = officeDao.getOfficeAddress();
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

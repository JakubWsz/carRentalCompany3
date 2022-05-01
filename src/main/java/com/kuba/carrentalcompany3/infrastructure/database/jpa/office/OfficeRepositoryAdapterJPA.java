package com.kuba.carrentalcompany3.infrastructure.database.jpa.office;

import com.kuba.carrentalcompany3.domain.office.OfficeRepository;
import com.kuba.carrentalcompany3.domain.office.model.Office;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.office.entity.OfficeDAO;
import org.springframework.core.convert.ConversionService;

import java.util.Optional;

public class OfficeRepositoryAdapterJPA implements OfficeRepository {
    private final OfficeRepositoryJPA officeRepositoryJPA;
    private final ConversionService conversionService;

    public OfficeRepositoryAdapterJPA(OfficeRepositoryJPA officeRepositoryJPA, ConversionService conversionService) {
        this.officeRepositoryJPA = officeRepositoryJPA;
        this.conversionService = conversionService;
    }

    public OfficeDAO getByDomainId(String domainId) {
        return officeRepositoryJPA.getByDomainId(domainId).get();
    }

    @Override
    public Office save(Office office) {
        OfficeDAO officeDao = officeRepositoryJPA.save(conversionService.convert(office, OfficeDAO.class));
        return conversionService.convert(officeDao, Office.class);
    }

    @Override
    public Optional<Office> getOffice(String id) {
        Optional<OfficeDAO> officeDaoOptional = officeRepositoryJPA.getByDomainId(id);
        return Optional.ofNullable(conversionService.convert(officeDaoOptional.get(), Office.class));
    }

    @Override
    public void update(Office office) {
        OfficeDAO officeDao = conversionService.convert(office, OfficeDAO.class);
        officeDao.setId(getByDomainId(office.getDomainId()).getId());
        officeRepositoryJPA.save(officeDao);
    }
}
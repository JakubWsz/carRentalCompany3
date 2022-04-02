package com.kuba.carrentalcompany3.infrastructure.database.jpa.office;

import com.kuba.carrentalcompany3.domain.office.OfficeRepository;
import com.kuba.carrentalcompany3.domain.office.model.Office;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.office.entity.OfficeDao;
import org.springframework.core.convert.ConversionService;

import java.util.Optional;

public class OfficeRepositoryAdapterJPA implements OfficeRepository {
    private final OfficeRepositoryJPA officeRepositoryJPA;
    private final ConversionService conversionService;

    public OfficeRepositoryAdapterJPA(OfficeRepositoryJPA officeRepositoryJPA, ConversionService conversionService) {
        this.officeRepositoryJPA = officeRepositoryJPA;
        this.conversionService = conversionService;
    }

    public OfficeDao getByDomainId(String domainId) {
        return officeRepositoryJPA.getByDomainId(domainId).get();
    }

    @Override
    public Office save(Office office) {
        OfficeDao officeDao = officeRepositoryJPA.save(conversionService.convert(office, OfficeDao.class));
        return conversionService.convert(officeDao, Office.class);
    }

    @Override
    public Optional<Office> getOffice(String id) {
        Optional<OfficeDao> officeDaoOptional = officeRepositoryJPA.getByDomainId(id);
        return Optional.ofNullable(conversionService.convert(officeDaoOptional.get(), Office.class));
    }

    @Override
    public void update(Office office) {
        save(office);
    }
}

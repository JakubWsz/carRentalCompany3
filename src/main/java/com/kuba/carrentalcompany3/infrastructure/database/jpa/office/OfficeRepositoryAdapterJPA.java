package com.kuba.carrentalcompany3.infrastructure.database.jpa.office;

import com.kuba.carrentalcompany3.domain.office.OfficeRepository;
import com.kuba.carrentalcompany3.infrastructure.database.jpa.office.entity.OfficeDao;

public class OfficeRepositoryAdapterJPA implements OfficeRepository {
    private final OfficeRepositoryJPA officeRepositoryJPA;

    public OfficeRepositoryAdapterJPA(OfficeRepositoryJPA officeRepositoryJPA) {
        this.officeRepositoryJPA = officeRepositoryJPA;
    }

    public OfficeDao getByDomainId(String domainId) {
        return officeRepositoryJPA.getByDomainId(domainId);
    }
}

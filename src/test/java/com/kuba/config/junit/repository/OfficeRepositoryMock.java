package com.kuba.config.junit.repository;

import com.kuba.carrentalcompany3.domain.office.OfficeRepository;
import com.kuba.carrentalcompany3.domain.office.model.Office;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OfficeRepositoryMock implements OfficeRepository {
    private final List<Office> offices = new ArrayList<>();

    @Override
    public Office save(Office office) {
        offices.add(office);
        return office;
    }

    @Override
    public Optional<Office> getOffice(String id) {
        return Optional.of(offices.get(0));
    }

    @Override
    public void update(Office office) {
        save(office);
    }

    public void clean() {
        Object[] clientsArray = offices.toArray();
        for (int i = 0; clientsArray.length - 1 >= i; i++) {
            offices.remove(clientsArray[i]);
        }
    }
}

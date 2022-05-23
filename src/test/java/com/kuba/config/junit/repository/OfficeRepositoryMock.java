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
        return offices.stream()
                .filter(office -> office.getId().equals(id))
                .findAny();
    }

    @Override
    public void update(Office office) {
        save(office);
    }

    public void clean() {
        offices.clear();
        }
    }

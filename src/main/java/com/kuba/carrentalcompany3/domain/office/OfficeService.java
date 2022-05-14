package com.kuba.carrentalcompany3.domain.office;

import com.kuba.carrentalcompany3.domain.Address;
import com.kuba.carrentalcompany3.domain.employee.EmployeeFieldsUpdater;
import com.kuba.carrentalcompany3.domain.employee.model.Employee;
import com.kuba.carrentalcompany3.domain.employee.model.EmployeeFieldType;
import com.kuba.carrentalcompany3.domain.exception.ClientExceptionCode;
import com.kuba.carrentalcompany3.domain.exception.DomainException;
import com.kuba.carrentalcompany3.domain.office.model.Office;
import com.kuba.carrentalcompany3.domain.office.model.OfficeFieldType;
import com.kuba.carrentalcompany3.domain.office.valiator.OfficeValidator;

import java.util.Map;
import java.util.UUID;

public class OfficeService {
    private final OfficeRepository officeRepository;

    public OfficeService(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    public Office createOffice(Address address, String websiteUrl, String officeCeo) {
        Office office = new Office.OfficeBuilder()
                .setId(UUID.randomUUID().toString())
                .setAddress(address)
                .setWebsiteURL(websiteUrl)
                .setOfficeCEO(officeCeo)
                .setDeleted(false)
                .build();
        OfficeValidator.validateOffice(office);
        return officeRepository.save(office);
    }

    public void deleteOffice(String id) {
        Office office = getOffice(id);
        isOfficeDeletedValidator(office.isDeleted());
        office.markAsDelete();
        officeRepository.update(office);
    }

    public void updateOffice(Map<OfficeFieldType, String> fieldUpdates, String id) {
        Office office = getOffice(id);
        OfficeFieldsUpdater.updateAll(office, fieldUpdates);
        officeRepository.save(office);
    }

    private Office getOffice(String id) {
        return officeRepository.getOffice(id).orElseThrow(() ->
                new DomainException(ClientExceptionCode.OFFICE_DOESNT_EXISTS));
    }

    private void isOfficeDeletedValidator(boolean deleted) {
        if (deleted) {
            throw new DomainException(ClientExceptionCode.OFFICE_ALREADY_DELETED);
        }
    }
}

package com.kuba.carrentalcompany3.domain.office;

import com.kuba.carrentalcompany3.domain.employee.model.Employee;
import com.kuba.carrentalcompany3.domain.exception.DomainException;
import com.kuba.carrentalcompany3.domain.exception.ClientExceptionCode;
import com.kuba.carrentalcompany3.domain.office.model.Office;
import com.kuba.carrentalcompany3.domain.office.model.OfficeAddress;
import com.kuba.carrentalcompany3.domain.office.valiator.OfficeValidator;

import java.util.List;
import java.util.UUID;

public class OfficeService {
    private final OfficeRepository officeRepository;

    public OfficeService(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    public Office createOffice(OfficeAddress officeAddress, String websiteUrl, String officeCeo) {
        Office office = new Office(
                UUID.randomUUID().toString(),
                officeAddress,
                websiteUrl,
                officeCeo,
                false);
        OfficeValidator.validateOffice(office);
        return officeRepository.save(office);
    }

    public void deleteOffice(String id) {
        Office office = getOffice(id);
        isOfficeDeletedValidator(office.isDeleted());
        office.markAsDelete();
        officeRepository.update(office);
    }

    public void relocateOffice(OfficeAddress officeAddress, String id) {
        Office exOffice = getOffice(id);
        Office newOffice;
        isOfficeDeletedValidator(exOffice.isDeleted());
        newOffice = new Office(exOffice.getId(), officeAddress, exOffice.getWebsiteURL(),
                exOffice.getOfficeCEO(), false);
        officeRepository.update(newOffice);
    }

    public void changeCEO(String newCEO, String id) {
        Office office = getOffice(id);
        Office officeWithNewCEO;
        isOfficeDeletedValidator(office.isDeleted());
        officeWithNewCEO = new Office(office.getId(), office.getOfficeAddress(), office.getWebsiteURL(),
                newCEO, false);
        officeRepository.update(officeWithNewCEO);
    }

    public void updateWebsite(String newWebsite, String id) {
        Office office = getOffice(id);
        Office officeWithNewWebsite;
        isOfficeDeletedValidator(office.isDeleted());
        officeWithNewWebsite = new Office(office.getId(), office.getOfficeAddress(),
                newWebsite, office.getOfficeCEO(), office.isDeleted());
        officeRepository.update(officeWithNewWebsite);
    }

    public List<Employee> getEmployees(String officeId) {
        return officeRepository.getEmployeeList(officeId);
    }

    private Office getOffice(String id) {
        return officeRepository.getOffice(id).orElseThrow(() -> new DomainException(ClientExceptionCode.OFFICE_DOESNT_EXISTS));
    }

    private void isOfficeDeletedValidator(boolean deleted) {
        if (deleted) {
            throw new DomainException(ClientExceptionCode.OFFICE_ALREADY_DELETED);
        }
    }
}

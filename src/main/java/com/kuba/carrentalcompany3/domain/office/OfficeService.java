package com.kuba.carrentalcompany3.domain.office;

import com.kuba.carrentalcompany3.domain.Address;
import com.kuba.carrentalcompany3.domain.exception.ClientExceptionCode;
import com.kuba.carrentalcompany3.domain.exception.DomainException;
import com.kuba.carrentalcompany3.domain.office.model.Office;
import com.kuba.carrentalcompany3.domain.office.valiator.OfficeValidator;

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

    public void relocateOffice(Address address, String id) {
        Office exOffice = getOffice(id);
        Office newOffice;
        isOfficeDeletedValidator(exOffice.isDeleted());
        newOffice = new Office.OfficeBuilder()
                .setId(exOffice.getDomainId())
                .setAddress(address)
                .setWebsiteURL(exOffice.getWebsiteURL())
                .setOfficeCEO(exOffice.getOfficeCEO())
                .setDeleted(exOffice.isDeleted())
                .build();
        officeRepository.update(newOffice);
    }

    public void changeCEO(String newCEO, String id) {
        Office office = getOffice(id);
        Office officeWithNewCEO;
        isOfficeDeletedValidator(office.isDeleted());
        officeWithNewCEO = new Office.OfficeBuilder()
                .setId(office.getDomainId())
                .setAddress(office.getAddress())
                .setWebsiteURL(office.getWebsiteURL())
                .setOfficeCEO(newCEO)
                .setDeleted(office.isDeleted())
                .build();
        officeRepository.update(officeWithNewCEO);
    }

    public void updateWebsite(String newWebsite, String id) {
        Office office = getOffice(id);
        Office officeWithNewWebsite;
        isOfficeDeletedValidator(office.isDeleted());
        officeWithNewWebsite = new Office.OfficeBuilder()
                .setId(office.getDomainId())
                .setAddress(office.getAddress())
                .setWebsiteURL(newWebsite)
                .setOfficeCEO(office.getOfficeCEO())
                .setDeleted(office.isDeleted())
                .build();
        officeRepository.update(officeWithNewWebsite);
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

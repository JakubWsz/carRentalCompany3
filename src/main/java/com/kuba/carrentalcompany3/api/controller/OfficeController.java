package com.kuba.carrentalcompany3.api.controller;

import com.kuba.carrentalcompany3.api.dto.AddressDTO;
import com.kuba.carrentalcompany3.api.dto.office.CreateOfficeRequest;
import com.kuba.carrentalcompany3.api.dto.office.OfficeView;
import com.kuba.carrentalcompany3.domain.Address;
import com.kuba.carrentalcompany3.domain.office.OfficeService;
import com.kuba.carrentalcompany3.domain.office.model.Office;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/office")
public class OfficeController {
    private final ConversionService conversionService;
    private final OfficeService officeService;

    public OfficeController(ConversionService conversionService, OfficeService officeService) {
        this.conversionService = conversionService;
        this.officeService = officeService;
    }

    @PostMapping("/create")
    public ResponseEntity<OfficeView> createOffice(@RequestBody CreateOfficeRequest createOfficeRequest) {
        Office office = officeService.createOffice(
                conversionService.convert(createOfficeRequest.getAddressDTO(), Address.class),
                createOfficeRequest.getWebsiteUrl(),
                createOfficeRequest.getOfficeCeo());
        return new ResponseEntity<>(conversionService.convert(office, OfficeView.class), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}/delete")
    public void deleteOffice(@PathVariable String id) {
        officeService.deleteOffice(id);
    }

    @PutMapping("/{id}/relocate")
    public void relocateOffice(@RequestBody AddressDTO addressDTO, @PathVariable String id) {
        officeService.relocateOffice(conversionService.convert(addressDTO, Address.class), id);
    }

    @PutMapping("/{id}/changeCEO")
    public void changeCEO(@RequestBody String newCEO, @PathVariable String id) {
        officeService.changeCEO(newCEO, id);
    }

    @PutMapping("/{id}/updateWebsite")
    public void updateWebsite(@RequestBody String newWebsite,@PathVariable String id) {
        officeService.updateWebsite(newWebsite, id);
    }
}

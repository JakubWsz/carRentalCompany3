package com.kuba.carrentalcompany3.api.controller;

import com.kuba.carrentalcompany3.api.dto.OfficeAddressDTO;
import com.kuba.carrentalcompany3.api.dto.request.CreateOfficeRequest;
import com.kuba.carrentalcompany3.api.dto.response.OfficeView;
import com.kuba.carrentalcompany3.domain.office.OfficeService;
import com.kuba.carrentalcompany3.domain.office.model.Office;
import com.kuba.carrentalcompany3.domain.office.model.OfficeAddress;
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
                conversionService.convert(createOfficeRequest.getOfficeAddressDTO(), OfficeAddress.class),
                createOfficeRequest.getWebsiteUrl(),
                createOfficeRequest.getOfficeCeo());
        return new ResponseEntity<>(conversionService.convert(office, OfficeView.class), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public void deleteOffice(String id){
        officeService.deleteOffice(id);
    }

    @PutMapping("/relocate")
    public void relocateOffice(@RequestBody OfficeAddressDTO officeAddressDTO,String id){
        officeService.relocateOffice(conversionService.convert(officeAddressDTO,OfficeAddress.class),id);
    }

    @PutMapping("/changeCEO")
    public void changeCEO(String newCEO, String id){
        officeService.changeCEO(newCEO, id);
    }

    @PutMapping("/updateWebsite")
    public void updateWebsite(String newWebsite, String id){
        officeService.updateWebsite(newWebsite,id);
    }

}

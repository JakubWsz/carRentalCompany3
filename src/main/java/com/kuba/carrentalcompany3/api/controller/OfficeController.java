package com.kuba.carrentalcompany3.api.controller;

import com.kuba.carrentalcompany3.api.dto.FieldUpdateDTO;
import com.kuba.carrentalcompany3.api.dto.office.request.CreateOfficeRequest;
import com.kuba.carrentalcompany3.api.dto.office.OfficeView;
import com.kuba.carrentalcompany3.api.dto.office.request.UpdateOfficeRequest;
import com.kuba.carrentalcompany3.domain.Address;
import com.kuba.carrentalcompany3.domain.office.OfficeService;
import com.kuba.carrentalcompany3.domain.office.model.Office;
import com.kuba.carrentalcompany3.domain.office.model.OfficeFieldType;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.stream.Collectors;

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

    @PatchMapping("/{id}/update-data")
    public void updateOffice(@RequestBody UpdateOfficeRequest updateOfficeRequest, @PathVariable String id) {
        Map<OfficeFieldType, String> fieldUpdates = updateOfficeRequest.getUpdateOffice().stream()
                .collect(Collectors.toMap(FieldUpdateDTO::getFieldType, FieldUpdateDTO::getNewValue));
        officeService.updateOffice(fieldUpdates, id);
    }
}

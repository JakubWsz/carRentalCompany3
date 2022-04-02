package com.kuba.carrentalcompany3.infrastructure.converter.office.api;

import com.kuba.carrentalcompany3.api.dto.OfficeAddressDTO;
import com.kuba.carrentalcompany3.api.dto.response.OfficeView;
import com.kuba.carrentalcompany3.domain.office.model.Office;
import com.kuba.carrentalcompany3.domain.office.model.OfficeAddress;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class OfficeToOfficeView implements Converter<Office, OfficeView> {
    @Override
    public OfficeView convert(Office office) {
        OfficeAddress officeAddress = office.getOfficeAddress();
        return new OfficeView(
                office.getId(),
                new OfficeAddressDTO(officeAddress.getOfficeStreetAddress(),
                        officeAddress.getOfficePostalCode(), officeAddress.getOfficeCityName()),
                office.getWebsiteURL(),
                office.getOfficeCEO()
        );
    }
}

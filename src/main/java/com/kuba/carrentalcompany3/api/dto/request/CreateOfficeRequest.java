package com.kuba.carrentalcompany3.api.dto.request;

import com.kuba.carrentalcompany3.api.dto.OfficeAddressDTO;

public class CreateOfficeRequest {
    private final OfficeAddressDTO officeAddressDTO;
    private final String websiteUrl;
    private final String officeCeo;

    public CreateOfficeRequest(OfficeAddressDTO officeAddressDTO, String websiteUrl, String officeCeo) {
        this.officeAddressDTO = officeAddressDTO;
        this.websiteUrl = websiteUrl;
        this.officeCeo = officeCeo;
    }

    public OfficeAddressDTO getOfficeAddressDTO() {
        return officeAddressDTO;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public String getOfficeCeo() {
        return officeCeo;
    }
}

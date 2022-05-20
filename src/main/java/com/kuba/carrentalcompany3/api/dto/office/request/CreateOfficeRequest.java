package com.kuba.carrentalcompany3.api.dto.office.request;

import com.kuba.carrentalcompany3.api.dto.AddressDTO;

public class CreateOfficeRequest {
    private final AddressDTO addressDTO;
    private final String websiteUrl;
    private final String officeCeo;

    public CreateOfficeRequest(AddressDTO addressDTO, String websiteUrl, String officeCeo) {
        this.addressDTO = addressDTO;
        this.websiteUrl = websiteUrl;
        this.officeCeo = officeCeo;
    }

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public String getOfficeCeo() {
        return officeCeo;
    }
}

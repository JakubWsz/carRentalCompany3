package com.kuba.carrentalcompany3.api.dto.office;

import com.kuba.carrentalcompany3.api.dto.AddressDTO;

public class OfficeView {
    private final String id;
    private final AddressDTO addressDTO;
    private final String websiteURL;
    private final String officeCEO;

    public OfficeView(String id, AddressDTO addressDTO, String websiteURL, String officeCEO) {
        this.id = id;
        this.addressDTO = addressDTO;
        this.websiteURL = websiteURL;
        this.officeCEO = officeCEO;
    }

    public String getId() {
        return id;
    }

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public String getWebsiteURL() {
        return websiteURL;
    }

    public String getOfficeCEO() {
        return officeCEO;
    }
}

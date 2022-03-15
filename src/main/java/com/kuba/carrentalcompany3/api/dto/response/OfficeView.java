package com.kuba.carrentalcompany3.api.dto.response;

import com.kuba.carrentalcompany3.api.dto.OfficeAddressDTO;

public class OfficeView {
    private final String id;
    private final OfficeAddressDTO officeAddress;
    private final String websiteURL;
    private final String officeCEO;

    public OfficeView(String id, OfficeAddressDTO officeAddress, String websiteURL, String officeCEO) {
        this.id = id;
        this.officeAddress = officeAddress;
        this.websiteURL = websiteURL;
        this.officeCEO = officeCEO;
    }

    public String getId() {
        return id;
    }

    public OfficeAddressDTO getOfficeAddress() {
        return officeAddress;
    }

    public String getWebsiteURL() {
        return websiteURL;
    }

    public String getOfficeCEO() {
        return officeCEO;
    }
}

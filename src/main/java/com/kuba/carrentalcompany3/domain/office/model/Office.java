package com.kuba.carrentalcompany3.domain.office.model;

import com.kuba.carrentalcompany3.domain.Address;

public class Office {
    private String domainId;
    private Address address;
    private String websiteURL;
    private String officeCEO;
    private boolean deleted;

    private Office(String id, Address address, String websiteURL, String officeCEO, boolean deleted) {
        this.domainId = id;
        this.address = address;
        this.websiteURL = websiteURL;
        this.officeCEO = officeCEO;
        this.deleted = deleted;
    }

    public static class OfficeBuilder {
        private String id;
        private Address address;
        private String websiteURL;
        private String officeCEO;
        private boolean deleted;

        public OfficeBuilder setId(String id) {
            this.id = id;
            return this;
        }

        public OfficeBuilder setAddress(Address address) {
            this.address = address;
            return this;
        }

        public OfficeBuilder setWebsiteURL(String websiteURL) {
            this.websiteURL = websiteURL;
            return this;
        }

        public OfficeBuilder setOfficeCEO(String officeCEO) {
            this.officeCEO = officeCEO;
            return this;
        }

        public OfficeBuilder setDeleted(boolean deleted) {
            this.deleted = deleted;
            return this;
        }

        public Office build() {
            return new Office(id, address, websiteURL, officeCEO, deleted);
        }
    }

    public Address getAddress() {
        return address;
    }

    public String getWebsiteURL() {
        return websiteURL;
    }

    public String getOfficeCEO() {
        return officeCEO;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void markAsDelete() {
        deleted = true;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }

    public void setWebsiteURL(String websiteURL) {
        this.websiteURL = websiteURL;
    }

    public void setOfficeCEO(String officeCEO) {
        this.officeCEO = officeCEO;
    }

    public void updateStreetAddress(String streetAddress) {
        address = new Address(streetAddress, address.getPostalCode(), address.getCityName());
    }

    public void updatePostalCode(String postalCode) {
        address = new Address(address.getStreetAddress(), postalCode, address.getCityName());
    }

    public void updateCityName(String cityName) {
        address = new Address(address.getStreetAddress(), address.getPostalCode(), cityName);
    }

    public String getId() {
        return domainId;
    }

    @Override
    public String toString() {
        return "Office{" +
                "id='" + domainId + '\'' +
                ", officeAddress=" + address +
                ", websiteURL='" + websiteURL + '\'' +
                ", officeCEO='" + officeCEO + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}

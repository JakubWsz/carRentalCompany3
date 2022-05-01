package com.kuba.carrentalcompany3.domain.office.model;

public class Office {
    private final String domainId;
    private final OfficeAddress officeAddress;
    private final String websiteURL;
    private final String officeCEO;
    private boolean deleted;

   private Office(String id, OfficeAddress officeAddress, String websiteURL, String officeCEO, boolean deleted) {
        this.domainId = id;
        this.officeAddress = officeAddress;
        this.websiteURL = websiteURL;
        this.officeCEO = officeCEO;
        this.deleted = deleted;
    }

    public static class OfficeBuilder {
        private String id;
        private OfficeAddress officeAddress;
        private String websiteURL;
        private String officeCEO;
        private boolean deleted;

        public OfficeBuilder setId(String id) {
            this.id = id;
            return this;
        }

        public OfficeBuilder setOfficeAddress(OfficeAddress officeAddress) {
            this.officeAddress = officeAddress;
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
            return new Office(id, officeAddress, websiteURL, officeCEO, deleted);
        }
    }

    public OfficeAddress getOfficeAddress() {
        return officeAddress;
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

    public String getDomainId() {return domainId;}
    @Override
    public String toString() {
        return "Office{" +
                "id='" + domainId + '\'' +
                ", officeAddress=" + officeAddress +
                ", websiteURL='" + websiteURL + '\'' +
                ", officeCEO='" + officeCEO + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}

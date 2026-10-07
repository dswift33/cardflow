package com.davidswift.cardflow.application;

final class ApplicantRequestBuilder {
    private String firstName = "First";
    private String lastName = "Last";
    private String ssn = "111223333";
    private String addressLine1 = "1 Main St";
    private String addressLine2 = null;
    private String city = "Tampa";
    private String state = "FL";
    private String postalCode = "33601";
    private String phone = "813-555-0100";

    static ApplicantRequestBuilder builder() {
        return new ApplicantRequestBuilder();
    }

    ApplicantRequestBuilder firstName(String v) { this.firstName = v; return this; }
    ApplicantRequestBuilder lastName(String v)  { this.lastName = v;  return this; }
    ApplicantRequestBuilder ssn(String v)       { this.ssn = v;       return this; }
    ApplicantRequestBuilder addressLine1(String v)       { this.addressLine1 = v;       return this; }
    ApplicantRequestBuilder city(String v)       { this.city = v;       return this; }
    ApplicantRequestBuilder state(String v)       { this.state = v;       return this; }
    ApplicantRequestBuilder postalCode(String v)       { this.postalCode = v;       return this; }
    ApplicantRequestBuilder phone(String v)       { this.phone = v;       return this; }

    ApplicantRequest build() {
        return new ApplicantRequest(firstName, lastName, ssn, addressLine1,
                addressLine2, city, state, postalCode, phone);
    }
}
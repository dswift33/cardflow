package com.davidswift.cardflow.application;

class ApplicantTestHelper {

    static Applicant createApplicant() {
        Applicant applicant = new Applicant();

        applicant.setFirstName("firstName");
        applicant.setLastName("lastName");
        applicant.setSsn("111111111");
        applicant.setAddressLine1("addressLine1");
        applicant.setAddressLine2("addressLine2");
        applicant.setCity("city");
        applicant.setState("state");
        applicant.setPostalCode("postalCode");
        applicant.setPhone("1234567890");

        return applicant;
    }
}

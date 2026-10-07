package com.davidswift.cardflow.application;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Set;

public class ApplicantRequestTest {

    private static final Validator validator =
            Validation.buildDefaultValidatorFactory().getValidator();

    @ParameterizedTest
    @ValueSource(strings = {"123456789", "987654321"})   // adjust to your rules
    void validSsn_hasNoViolations(String ssn) {
        ApplicantRequest request = ApplicantRequestBuilder.builder().ssn(ssn).build();
        Set<ConstraintViolation<ApplicantRequest>> violations = validator.validate(request);
        assertThat(violations).isEmpty();
    }

    @ParameterizedTest
    @ValueSource(strings = {"12345678", "ABCDEFGHI", ""})   // adjust to your rules
    void givenInvalidApplicantRequest_whenValidated_ssnIsInvalid(String ssn) {
        ApplicantRequest request = ApplicantRequestBuilder.builder().ssn(ssn).build();

        Set<ConstraintViolation<ApplicantRequest>> violations = validator.validate(request);
        assertThat(violations)
                .extracting(v -> v.getPropertyPath().toString())
                .containsOnly("ssn");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "ABCDEFGHIAASDFASDFASDFASDASDFASDFASDFASDFASDFASDFASDFASDFASDFASDFASDFABCDEFGHIAASDFASDFASDFASDASDFASDFASDFASDFASDFASDFASDFASDFASDFASDFASDFASDFSDFSDF"})   // adjust to your rules
    void givenInvalidApplicantRequest_whenValidated_firstNameIsInvalid(String firstName) {
        ApplicantRequest request = ApplicantRequestBuilder.builder().firstName(firstName).build();

        Set<ConstraintViolation<ApplicantRequest>> violations = validator.validate(request);
        assertThat(violations)
            .extracting(v -> v.getPropertyPath().toString())
            .containsOnly("firstName");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "ABCDEFGHIAASDFASDFASDFASDASDFASDFASDFASDFASDFASDFASDFASDFASDFASDFASDFABCDEFGHIAASDFASDFASDFASDASDFASDFASDFASDFASDFASDFASDFASDFASDFASDFASDFASDFSDFSDF"})   // adjust to your rules
    void givenInvalidApplicantRequest_whenValidated_lastNameIsInvalid(String lastName) {
        ApplicantRequest request = ApplicantRequestBuilder.builder().lastName(lastName).build();

        Set<ConstraintViolation<ApplicantRequest>> violations = validator.validate(request);
        assertThat(violations)
                .extracting(v -> v.getPropertyPath().toString())
                .containsOnly("lastName");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "ABCDEFGHIAASDFASDFASDFASDASDFASDFASDFASDFASDFASDFASDFASDFASDFASDFASDFABCDEFGHIAASDFASDFASDFASDASDFASDFASDFASDFASDFASDFASDFASDFASDFASDFASDFASDFSDFSDF"})   // adjust to your rules
    void givenInvalidApplicantRequest_whenValidated_addressLine1IsInvalid(String addressLine1) {
        ApplicantRequest request = ApplicantRequestBuilder.builder().addressLine1(addressLine1).build();

        Set<ConstraintViolation<ApplicantRequest>> violations = validator.validate(request);
        assertThat(violations)
                .extracting(v -> v.getPropertyPath().toString())
                .containsOnly("addressLine1");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "ABCDEFGHIAASDFASDFASDFASDASDFASDFASDFASDFASDFASDFASDFASDFASDFASDFASDFABCDEFGHIAASDFASDFASDFASDASDFASDFASDFASDFASDFASDFASDFASDFASDFASDFASDFASDFSDFSDF"})   // adjust to your rules
    void givenInvalidApplicantRequest_whenValidated_cityIsInvalid(String city) {
        ApplicantRequest request = ApplicantRequestBuilder.builder().city(city).build();

        Set<ConstraintViolation<ApplicantRequest>> violations = validator.validate(request);
        assertThat(violations)
                .extracting(v -> v.getPropertyPath().toString())
                .containsOnly("city");
    }


    @ParameterizedTest
    @ValueSource(strings = {"", "ABCDEFGHIAASDFASDFASDFASDASDFASDFASDFASDFASDFASDFASDFASDFASDFASDFASDFABCDEFGHIAASDFASDFASDFASDASDFASDFASDFASDFASDFASDFASDFASDFASDFASDFASDFASDFSDFSDF"})   // adjust to your rules
    void givenInvalidApplicantRequest_whenValidated_stateIsInvalid(String state) {
        ApplicantRequest request = ApplicantRequestBuilder.builder().state(state).build();

        Set<ConstraintViolation<ApplicantRequest>> violations = validator.validate(request);
        assertThat(violations)
                .extracting(v -> v.getPropertyPath().toString())
                .containsOnly("state");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "ABCDEFGHIAASDFASDFASDFASDASDFASDFASDFASDFASDFASDFASDFASDFASDFASDFASDFABCDEFGHIAASDFASDFASDFASDASDFASDFASDFASDFASDFASDFASDFASDFASDFASDFASDFASDFSDFSDF"})   // adjust to your rules
    void givenInvalidApplicantRequest_whenValidated_postalCodeIsInvalid(String postalCode) {
        ApplicantRequest request = ApplicantRequestBuilder.builder().postalCode(postalCode).build();

        Set<ConstraintViolation<ApplicantRequest>> violations = validator.validate(request);
        assertThat(violations)
                .extracting(v -> v.getPropertyPath().toString())
                .containsOnly("postalCode");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "ABCDEFGHIAASDFASDFASDFASDASDFASDFASDFASDFASDFASDFASDFASDFASDFASDFASDFABCDEFGHIAASDFASDFASDFASDASDFASDFASDFASDFASDFASDFASDFASDFASDFASDFASDFASDFSDFSDF"})   // adjust to your rules
    void givenInvalidApplicantRequest_whenValidated_phoneIsInvalid(String phone) {
        ApplicantRequest request = ApplicantRequestBuilder.builder().phone(phone).build();

        Set<ConstraintViolation<ApplicantRequest>> violations = validator.validate(request);
        assertThat(violations)
                .extracting(v -> v.getPropertyPath().toString())
                .containsOnly("phone");
    }
}

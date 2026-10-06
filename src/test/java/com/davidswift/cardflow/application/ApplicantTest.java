package com.davidswift.cardflow.application;

import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicantTest {
    @Test
    void givenApplicant_whenEqualsCalledWithSame_thenSuccess() {
        Applicant a = ApplicantTestHelper.createApplicant();
        Applicant b = ApplicantTestHelper.createApplicant();
        ReflectionTestUtils.setField(b, "uuid", a.getUuid());
        assertThat(a.equals(a)).isTrue();
        assertThat(a.equals(b)).isTrue();
        assertThat(b.equals(a)).isTrue();
        assertThat(a.equals(null)).isFalse();
        assertThat(a.equals("string")).isFalse();
        assertThat(a.hashCode()).isEqualTo(b.hashCode());

        Applicant c = ApplicantTestHelper.createApplicant();
        assertThat(a.getUuid()).isNotEqualTo(c.getUuid());
        assertThat(a.equals(c)).isFalse();
    }

    @Test
    void givenApplicant_whenFieldsChange_hashcodeSame() {
        Applicant a = ApplicantTestHelper.createApplicant();
        Applicant b = ApplicantTestHelper.createApplicant();
        ReflectionTestUtils.setField(b, "uuid", a.getUuid());

        int hash = a.hashCode();
        a.setFirstName("John");
        a.setAddressLine1("1 Oak Stree");
        assertThat(a.hashCode()).isEqualTo(hash);
    }
}

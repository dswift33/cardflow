package com.davidswift.cardflow.application;

import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationTest {

    @Test
    void givenApplication_whenEqualssCalledWithSame_thenSuccess() {
        Application a = new Application();
        Application b = new Application();
        ReflectionTestUtils.setField(b, "uuid", a.getUuid());
        //set different applicants
        Applicant a1 = ApplicantTestHelper.createApplicant();
        a.setApplicant(a1);
        Applicant b1 = ApplicantTestHelper.createApplicant();
        b.setApplicant(b1);

        assertThat(a.equals(a)).isTrue();
        assertThat(a.equals(b)).isTrue();
        assertThat(b.equals(a)).isTrue();
        assertThat(a.equals(null)).isFalse();
        assertThat(a.equals("string")).isFalse();
        assertThat(a.hashCode()).isEqualTo(b.hashCode());
    }
}

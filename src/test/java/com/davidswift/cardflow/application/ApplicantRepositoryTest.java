package com.davidswift.cardflow.application;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.jpa.test.autoconfigure.TestEntityManager;
import org.springframework.context.annotation.Import;
import com.davidswift.cardflow.TestcontainersConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) //DO NOT USE H2
@Import(TestcontainersConfiguration.class) //USE TESTCONTAINERS
public class ApplicantRepositoryTest {

    @Autowired
    private ApplicantRepository applicantRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void givenUser_whenSaved_thenCanBeFoundById() {
        Applicant applicant = ApplicantRepositoryTest.createApplicant();

        assertThat(applicant.getUuid()).isNotNull();

        Applicant saved = applicantRepository.save(applicant);
        assertThat(saved.getId()).isNotNull();
    }

    @Test
    void givenUser_whenUpdated_thenUpdatesArePersisted() {
        Applicant applicant = ApplicantRepositoryTest.createApplicant();
        assertThat(applicant.getFirstName()).isEqualTo("firstName");
        Long id = applicantRepository.save(applicant).getId();

        applicant.setFirstName("FIRSTNAME");
        applicantRepository.save(applicant);

        entityManager.flush();
        entityManager.clear();

        Applicant found = applicantRepository.findById(id).orElseThrow();
        assertThat(found.getFirstName()).isEqualTo("FIRSTNAME");
    }

    private static Applicant createApplicant() {
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

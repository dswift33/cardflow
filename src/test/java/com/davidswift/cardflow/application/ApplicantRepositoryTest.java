package com.davidswift.cardflow.application;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.jpa.test.autoconfigure.TestEntityManager;
import org.springframework.context.annotation.Import;
import com.davidswift.cardflow.TestcontainersConfiguration;
import org.springframework.dao.DataIntegrityViolationException;

import static com.davidswift.cardflow.application.ApplicantTestHelper.createApplicant;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) //DO NOT USE H2
@Import(TestcontainersConfiguration.class) //USE TESTCONTAINERS
public class ApplicantRepositoryTest {

    @Autowired
    private ApplicantRepository applicantRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void givenApplicant_whenSaved_thenCanBeFoundById() {
        Applicant applicant = createApplicant();

        assertThat(applicant.getUuid()).isNotNull();

        Applicant saved = applicantRepository.save(applicant);
        assertThat(saved.getId()).isNotNull();
        assertThat(saved).usingRecursiveComparison().isEqualTo(applicant);
    }

    @Test
    void givenApplicant_whenUpdated_thenUpdatesArePersisted() {
        Applicant applicant = createApplicant();
        assertThat(applicant.getFirstName()).isEqualTo("firstName");
        Long id = applicantRepository.save(applicant).getId();

        applicant.setFirstName("FIRSTNAME");
        applicantRepository.save(applicant);

        entityManager.flush();
        entityManager.clear();

        Applicant found = applicantRepository.findById(id).orElseThrow();
        assertThat(found.getFirstName()).isEqualTo("FIRSTNAME");
    }

    @Test
    void givenApplicantWithExitingSsn_whenSaved_dataIntegrityExceptionThrown() {
        Applicant applicant = createApplicant();
        applicantRepository.save(applicant);
        Applicant applicant2 = createApplicant();
        assertThat(applicant).extracting(Applicant::getSsn).isEqualTo(applicant2.getSsn());
        assertThatThrownBy(() -> applicantRepository.saveAndFlush(applicant2))
                .isInstanceOf(DataIntegrityViolationException.class);
    }
}

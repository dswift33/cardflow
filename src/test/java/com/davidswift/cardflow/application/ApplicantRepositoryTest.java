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
        Applicant applicant = new Applicant();
        assertThat(applicant.getUuid()).isNotNull();

    }
}

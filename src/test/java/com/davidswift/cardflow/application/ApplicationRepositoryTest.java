package com.davidswift.cardflow.application;

import com.davidswift.cardflow.TestcontainersConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.jpa.test.autoconfigure.TestEntityManager;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.UUID;

@DataJpaTest()
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) //DO NOT USE H2
@Import(TestcontainersConfiguration.class)
public class ApplicationRepositoryTest {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private ApplicantRepository applicantRepository;

    @Autowired
    private TestEntityManager entityManager;


    @Test
    void testApplication_whenSaved_canBeRead() {
        Applicant applicant = applicantRepository.save(createApplicant());

        Application application = new Application();
        application.setApplicant(applicant);
        applicationRepository.save(application);

        Long applicationId = application.getId();
        UUID applicationUuid = application.getUuid();

        entityManager.flush();
        entityManager.clear();

        Application loadedApplication = applicationRepository.getReferenceById(applicationId);//get a proxy
        System.out.println("loadedApplication class = " + loadedApplication.getClass());
        assertThat(application).isEqualTo(loadedApplication);
        assertThat(loadedApplication).isEqualTo(application);
        assertThat(loadedApplication.getUuid()).isEqualTo(applicationUuid);

        Applicant loadedApplicant = loadedApplication.getApplicant();
        //equality
        assertThat(applicant).isEqualTo(loadedApplicant);
        assertThat(loadedApplicant).isEqualTo(applicant);
        //hashcode
        assertThat(loadedApplicant.hashCode()).isEqualTo(applicant.hashCode());
        assertThat(applicant.hashCode()).isEqualTo(loadedApplicant.hashCode());

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

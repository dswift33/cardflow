package com.davidswift.cardflow.application.repository;

import com.davidswift.cardflow.application.domain.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
}

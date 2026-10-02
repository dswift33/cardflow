package com.davidswift.cardflow.application;

import org.springframework.data.jpa.repository.JpaRepository;

interface ApplicantRepository extends JpaRepository<Applicant, Long> {
}

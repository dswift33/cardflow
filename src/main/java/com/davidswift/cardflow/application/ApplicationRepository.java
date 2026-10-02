package com.davidswift.cardflow.application;

import org.springframework.data.jpa.repository.JpaRepository;

interface ApplicationRepository extends JpaRepository<Application, Long> {
}

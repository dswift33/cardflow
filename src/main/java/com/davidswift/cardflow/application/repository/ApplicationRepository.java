package com.davidswift.cardflow.application.repository;

import com.davidswift.cardflow.application.domain.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
}

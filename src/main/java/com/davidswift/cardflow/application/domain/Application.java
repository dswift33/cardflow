package com.davidswift.cardflow.application.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Application {
    @Id
    private Long id;

    @ManyToOne
    private Applicant applicant;
}

package com.davidswift.cardflow.application;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ApplicationRequest(
    @NotNull
    UUID uuid,

    @NotNull
    ApplicantRequest applicant,

    @NotNull
    ApplicationStatus status
) {}

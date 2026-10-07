package com.davidswift.cardflow.application;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ApplicationRequest(

    @NotNull
    @Valid
    ApplicantRequest applicant
) {}

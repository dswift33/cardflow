package com.davidswift.cardflow.application;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record ApplicantRequest(

    @NotBlank
    @Size(max = 128)
    String firstName,

    @NotBlank
    @Size(max = 128)
    String lastName,

    @NotBlank
    @Pattern(regexp = "^\\d{9}$",
             message = "Invalid SSN format. Must be AAGGSSSS with valid digits.")
    String ssn,

    @NotBlank
    @Size(max = 128)
    String addressLine1,

    @Size(max = 128)
    String addressLine2,

    @NotBlank
    @Size(max = 128)
    String city,

    @NotBlank
    @Size(max = 128)
    String state,

    @NotBlank
    @Pattern(
            regexp = "^\\d{5}(?:-\\d{4})?$",
            message = "Invalid US ZIP code. Must be 5 digits (e.g., 12345) or 9 digits (e.g., 12345-6789)."
    )    String postalCode,

    @NotBlank
    @Size(max = 64)
    @Pattern(
            regexp = "^(?:\\+1[-.\\s]?)?(\\(?\\d{3}\\)?[-.\\s]?)?\\d{3}[-.\\s]?\\d{4}$",
            message = "Invalid US phone number format."
    )
    String phone
) {}

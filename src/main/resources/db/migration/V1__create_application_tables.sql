CREATE TABLE applicant (
    id BIGINT PRIMARY KEY,
    uuid UUID NOT NULL UNIQUE,
    first_name VARCHAR(128) NOT NULL,
    last_name VARCHAR(128) NOT NULL,
    ssn VARCHAR(9) NOT NULL UNIQUE,
    address_line1 VARCHAR(128) NOT NULL,
    address_line2 VARCHAR(128),
    city VARCHAR(128) NOT NULL,
    state VARCHAR(128) NOT NULL,
    postal_code VARCHAR(128) NOT NULL,
    phone VARCHAR(64) NOT NULL
);

CREATE TABLE application (
    id BIGINT PRIMARY KEY,
    uuid UUID NOT NULL UNIQUE,
    applicant_id BIGINT NOT NULL,
    status VARCHAR(64) NOT NULL CHECK (status = 'PENDING' OR status = 'APPROVED' OR status = 'DENIED'),
    FOREIGN KEY (applicant_id) REFERENCES applicant(id)
);

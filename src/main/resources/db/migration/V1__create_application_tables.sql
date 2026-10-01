CREATE TABLE applicant (
    id INTEGER PRIMARY KEY,
    first_name VARCHAR(128) NOT NULL,
    last_name VARCHAR(128) NOT NULL,
    ssn VARCHAR(9) NOT NULL UNIQUE,
    address_line_1 VARCHAR(128) NOT NULL,
    address_line_2 VARCHAR(128) NOT NULL,
    city VARCHAR(128) NOT NULL,
    state VARCHAR(128) NOT NULL,
    postal_code VARCHAR(128) NOT NULL,
    phone VARCHAR(64) NOT NULL
);

CREATE TABLE application (
    id INTEGER PRIMARY KEY,
    applicant_id INTEGER,
    status VARCHAR(64) NOT NULL,
    FOREIGN KEY (applicant_id) REFERENCES applicant(id)
);

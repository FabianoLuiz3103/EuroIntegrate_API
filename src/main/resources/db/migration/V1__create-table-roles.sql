CREATE TABLE roles (
    id BIGINT AUTO_INCREMENT,
    name ENUM('ROLE_ADMINISTRATOR', 'ROLE_CUSTOMER'),
    PRIMARY KEY (id)
);

CREATE TABLE usuarios (
    id BIGINT AUTO_INCREMENT,
    email VARCHAR(255) UNIQUE,
    senha VARCHAR(255),
    PRIMARY KEY (id)
);
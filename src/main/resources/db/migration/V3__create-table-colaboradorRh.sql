CREATE TABLE tbl_colaborador_rh (
    id BIGINT AUTO_INCREMENT,
    id_colaborador BIGINT NOT NULL UNIQUE,
    email_rh VARCHAR(255),
    PRIMARY KEY (id)
);
CREATE TABLE tbl_perguntas (
    id BIGINT AUTO_INCREMENT,
    id_norma BIGINT,
    id_video BIGINT,
    enunciado VARCHAR(255),
    resposta_correta VARCHAR(255),
    tipo VARCHAR(255),
    PRIMARY KEY (id)
);
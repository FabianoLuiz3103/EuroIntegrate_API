CREATE TABLE tbl_integracao (
    data_fim DATE NOT NULL,
    data_inicio DATE NOT NULL,
    hora_fim TIME(6) NOT NULL,
    hora_inicio TIME(6) NOT NULL,
    media_acertos FLOAT(53),
    media_progresso FLOAT(53),
    qtd_colaboradores INTEGER,
    id BIGINT AUTO_INCREMENT,
    id_departamento BIGINT NOT NULL,
    id_rh BIGINT NOT NULL,
    status ENUM ('ANDAMENTO', 'FINALIZADO', 'NAO_FEZ', 'NAO_INICIADO') NOT NULL,
    PRIMARY KEY (id)
);
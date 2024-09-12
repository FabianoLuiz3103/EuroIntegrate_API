CREATE TABLE tbl_respostas (
    data_resposta DATE,
    foi_respondida BOOLEAN,
    colaborador_id BIGINT NOT NULL,
    pergunta_id BIGINT NOT NULL,
    resposta VARCHAR(255),
    PRIMARY KEY (colaborador_id, pergunta_id)
);
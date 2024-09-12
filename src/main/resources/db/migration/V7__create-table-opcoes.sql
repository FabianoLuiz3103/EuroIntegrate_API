CREATE TABLE tbl_opcoes (
    id BIGINT AUTO_INCREMENT,
    id_pergunta BIGINT,
    opcao VARCHAR(255),
    texto VARCHAR(255),
    PRIMARY KEY (id)
);
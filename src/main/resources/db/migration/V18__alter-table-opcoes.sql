ALTER TABLE tbl_opcoes
    ADD CONSTRAINT FK_tbl_opcoes_perguntas
    FOREIGN KEY (id_pergunta)
    REFERENCES tbl_perguntas(id);
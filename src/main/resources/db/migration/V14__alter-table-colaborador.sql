ALTER TABLE tbl_colaborador
    ADD CONSTRAINT FK_tbl_colaborador_departamento
    FOREIGN KEY (id_departamento)
    REFERENCES tbl_departamento(id);

ALTER TABLE tbl_colaborador
    ADD CONSTRAINT FK_tbl_colaborador_integracao
    FOREIGN KEY (id_integracao)
    REFERENCES tbl_integracao(id);
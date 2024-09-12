ALTER TABLE tbl_integracao
    ADD CONSTRAINT FK_tbl_integracao_colaborador_rh
    FOREIGN KEY (id_rh)
    REFERENCES tbl_colaborador_rh(id);

ALTER TABLE tbl_integracao
    ADD CONSTRAINT FK_tbl_integracao_departamento
    FOREIGN KEY (id_departamento)
    REFERENCES tbl_departamento(id);
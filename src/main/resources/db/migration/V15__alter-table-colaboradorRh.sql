ALTER TABLE tbl_colaborador_rh
    ADD CONSTRAINT FK_tbl_colaborador_rh_colaborador
    FOREIGN KEY (id_colaborador)
    REFERENCES tbl_colaborador(id);
ALTER TABLE tbl_normas
    ADD CONSTRAINT FK_tbl_normas_departamento
    FOREIGN KEY (id_departamento)
    REFERENCES tbl_departamento(id);
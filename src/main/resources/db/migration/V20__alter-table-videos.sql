ALTER TABLE tbl_videos
    ADD CONSTRAINT FK_tbl_videos_departamento
    FOREIGN KEY (id_departamento)
    REFERENCES tbl_departamento(id);

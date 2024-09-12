ALTER TABLE tbl_perguntas
    ADD CONSTRAINT FK_tbl_perguntas_normas
    FOREIGN KEY (id_norma)
    REFERENCES tbl_normas(id);

ALTER TABLE tbl_perguntas
    ADD CONSTRAINT FK_tbl_perguntas_videos
    FOREIGN KEY (id_video)
    REFERENCES tbl_videos(id);
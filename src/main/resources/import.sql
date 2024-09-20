-- 12345678
INSERT INTO usuarios (cpf, senha) VALUES ('12345671900', '$2a$12$.bPF9WkGJjzfKsxe10UhFeu5wyPj8LYVKVKm7ZRv6jjC.zkkAHg5W');
-- 310331
INSERT INTO usuarios (cpf, senha) VALUES ('12243378911', '$2a$12$K8vGtJq3q4fz7BRRXSOg/u.txCUIv3pXE1LBsJZPWoeFLhXs9mUDS');
-- 121212
INSERT INTO usuarios (cpf, senha) VALUES ('78909234566', '$2a$12$svsF9WZ5UKHoRTKb69FbnOpKntgOni41W6F2C.1acvJ9ur3HYJR66');

INSERT INTO roles (name) VALUES ('ROLE_ADMINISTRATOR');
INSERT INTO roles (name) VALUES ('ROLE_CUSTOMER');


INSERT INTO users_roles (role_id, user_id) VALUES (2,1);
INSERT INTO users_roles (role_id, user_id) VALUES (1,2);
INSERT INTO users_roles (role_id, user_id) VALUES (2,3);


INSERT INTO tbl_departamento (nome) VALUES ('Tecnologia da Informação (TI)');
INSERT INTO tbl_departamento (nome) VALUES ('Financeiro');
INSERT INTO tbl_departamento (nome) VALUES ('Marketing');
INSERT INTO tbl_departamento (nome) VALUES ('Jurídico');
INSERT INTO tbl_departamento (nome) VALUES ('Recursos Humanos (RH)');
INSERT INTO tbl_departamento (nome) VALUES ('Riscos');


INSERT INTO tbl_colaborador (primeiro_nome, sobrenome, cpf, email, telefone, data_admissao, avatar, sts_integracao, qtd_respondidas, pontuacao, qtd_certas, porc_progresso, porc_acertos, numero_matricula, data_nascimento, id_departamento) VALUES ('João', 'Silva', '12345671900', 'fabianojesus1991@gmail.com', '123456789', '2024-06-18', 'avatar1.png', 'NAO_FEZ', 0, 0, 0, 0.0, 0.0, '96044', '2000-03-12', 3);
INSERT INTO tbl_colaborador (primeiro_nome, sobrenome, cpf, email, telefone, data_admissao, avatar, sts_integracao, qtd_respondidas, pontuacao, qtd_certas, porc_progresso, porc_acertos, numero_matricula, data_nascimento, id_departamento) VALUES ('Maria', 'Santos', '99765432100', 'maria.santos@example.com', '987654321', '2024-06-19', 'avatar2.png', 'NAO_FEZ', 0, 0, 0, 0.0, 0.0, '96055', '1990-05-12', 3);
INSERT INTO tbl_colaborador (primeiro_nome, sobrenome, cpf, email, telefone, data_admissao, avatar, sts_integracao, qtd_respondidas, pontuacao, qtd_certas, porc_progresso, porc_acertos, numero_matricula, data_nascimento, id_departamento) VALUES ('Carlos', 'Oliveira', '234.567.890-11', 'carlos.oliveira@example.com', '234567890', '2024-06-20', 'avatar3.png', 'NAO_FEZ', 0, 0, 0, 0.0, 0.0, '97044', '2003-03-31',3);
INSERT INTO tbl_colaborador (primeiro_nome, sobrenome, cpf, email, telefone, data_admissao, avatar, sts_integracao, qtd_respondidas, pontuacao, qtd_certas, porc_progresso, porc_acertos, numero_matricula, data_nascimento, id_departamento) VALUES ('Ana', 'Pereira', '345.678.901-22', 'ana.pereira@example.com', '345678901', '2024-06-21', 'avatar4.png', 'NAO_FEZ', 0, 0, 0, 0.0, 0.0, '98844', '2000-03-03',3);
INSERT INTO tbl_colaborador (primeiro_nome, sobrenome, cpf, email, telefone, data_admissao, avatar, sts_integracao, qtd_respondidas, pontuacao, qtd_certas, porc_progresso, porc_acertos, numero_matricula, data_nascimento, id_departamento) VALUES ('Pedro', 'Rodrigues', '456.789.012-33', 'pedro.rodrigues@example.com', '456789012', '2024-06-22', 'avatar5.png', 'NAO_FEZ', 0, 0, 0, 0.0, 0.0, '96994', '1988-12-19',3);
INSERT INTO tbl_colaborador (primeiro_nome, sobrenome, cpf, email, telefone, data_admissao, avatar, sts_integracao, qtd_respondidas, pontuacao, qtd_certas, porc_progresso, porc_acertos, numero_matricula, data_nascimento, id_departamento) VALUES ('Juliana', 'Ferreira', '567.890.123-44', 'juliana.ferreira@example.com', '567890123', '2024-06-23', 'avatar6.png', 'NAO_FEZ', 0, 0, 0, 0.0, 0.0, '99944', '1975-03-20',3);
INSERT INTO tbl_colaborador (primeiro_nome, sobrenome, cpf, email, telefone, data_admissao, avatar, sts_integracao, qtd_respondidas, pontuacao, qtd_certas, porc_progresso, porc_acertos, numero_matricula, data_nascimento, id_departamento) VALUES ('Fernando', 'Gomes', '678.901.234-55', 'fernando.gomes@example.com', '678901234', '2024-06-24', 'avatar7.png', 'NAO_FEZ', 0, 0, 0, 0.0, 0.0, '96119', '1950-03-09',3);



INSERT INTO tbl_colaborador (primeiro_nome, sobrenome, cpf, email, telefone, data_admissao, avatar, sts_integracao, qtd_respondidas, pontuacao, qtd_certas, porc_progresso, porc_acertos, numero_matricula, data_nascimento, id_departamento) VALUES ('Fabiano', 'L.S.S', '12243378911', 'faah772@gmail.com', '123456889', '2024-06-18', 'avatar200.png', 'FINALIZADO', 50, 80, 40, 75.0, 50.0, '77044', '2003-03-31', 2);

INSERT INTO tbl_colaborador_rh (cpf, id_colaborador) VALUES ('12243378911', 8);
INSERT INTO tbl_colaborador_rh (cpf, id_colaborador) VALUES ('99765432100', 2);

INSERT INTO tbl_videos(link_video, id_departamento) VALUES ('https://video1.marketing', 3);
INSERT INTO tbl_videos(link_video, id_departamento) VALUES ('https://video2.marketing', 3);
INSERT INTO tbl_videos(link_video, id_departamento) VALUES ('https://video3.marketing', 3);
INSERT INTO tbl_videos(link_video, id_departamento) VALUES ('https://video4.marketing', 3);
INSERT INTO tbl_videos(link_video, id_departamento) VALUES ('https://video1.ti', 1);

INSERT INTO tbl_videos(link_video, id_departamento) VALUES ('https://cs210032001e507a429.blob.core.windows.net/videos/videoUm_financas.mp4', 2);
INSERT INTO tbl_videos(link_video, id_departamento) VALUES ('https://cs210032001e507a429.blob.core.windows.net/videos/videoDois_financas.mp4', 2);
INSERT INTO tbl_videos(link_video, id_departamento) VALUES ('https://cs210032001e507a429.blob.core.windows.net/videos/videoTres_financas.mp4', 2);


INSERT INTO tbl_perguntas (enunciado, resposta_correta, tipo, id_video) VALUES ('Pergunta 1 do vídeo 1 de financas', 'A', 'V', 6);
INSERT INTO tbl_perguntas (enunciado, resposta_correta, tipo, id_video) VALUES ('Pergunta 2 do vídeo 1 de financas', 'B', 'V', 6);
INSERT INTO tbl_perguntas (enunciado, resposta_correta, tipo, id_video) VALUES ('Pergunta 3 do vídeo 1 de financas', 'C', 'V', 6);
INSERT INTO tbl_perguntas (enunciado, resposta_correta, tipo, id_video) VALUES ('Pergunta 4 do vídeo 1 de financas', 'D', 'V', 6);
INSERT INTO tbl_perguntas (enunciado, resposta_correta, tipo, id_video) VALUES ('Pergunta 5 do vídeo 1 de financas', 'A', 'V', 6);

INSERT INTO tbl_perguntas (enunciado, resposta_correta, tipo, id_video) VALUES ('Pergunta 1 do vídeo 2 de financas', 'D', 'V', 7);
INSERT INTO tbl_perguntas (enunciado, resposta_correta, tipo, id_video) VALUES ('Pergunta 2 do vídeo 2 de financas', 'C', 'V', 7);
INSERT INTO tbl_perguntas (enunciado, resposta_correta, tipo, id_video) VALUES ('Pergunta 3 do vídeo 2 de financas', 'B', 'V', 7);

INSERT INTO tbl_perguntas (enunciado, resposta_correta, tipo, id_video) VALUES ('Pergunta 1 do vídeo 3 de financas', 'A', 'V', 8);
INSERT INTO tbl_perguntas (enunciado, resposta_correta, tipo, id_video) VALUES ('Pergunta 2 do vídeo 3 de financas', 'B', 'V', 8);
INSERT INTO tbl_perguntas (enunciado, resposta_correta, tipo, id_video) VALUES ('Pergunta 3 do vídeo 3 de financas', 'C', 'V', 8);


INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('A', 'Texto da opcao A', 1);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('B', 'Texto da opcao B', 1);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('C', 'Texto da opcao C', 1);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('D', 'Texto da opcao D', 1);

INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('A', 'Texto da opcao A', 2);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('B', 'Texto da opcao B', 2);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('C', 'Texto da opcao C', 2);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('D', 'Texto da opcao D', 2);

INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('A', 'Texto da opcao A', 3);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('B', 'Texto da opcao B', 3);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('C', 'Texto da opcao C', 3);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('D', 'Texto da opcao D', 3);

INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('A', 'Texto da opcao A', 4);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('B', 'Texto da opcao B', 4);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('C', 'Texto da opcao C', 4);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('D', 'Texto da opcao D', 4);

INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('A', 'Texto da opcao A', 5);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('B', 'Texto da opcao B', 5);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('C', 'Texto da opcao C', 5);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('D', 'Texto da opcao D', 5);

INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('A', 'Texto da opcao A', 6);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('B', 'Texto da opcao B', 6);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('C', 'Texto da opcao C', 6);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('D', 'Texto da opcao D', 6);

INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('A', 'Texto da opcao A', 7);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('B', 'Texto da opcao B', 7);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('C', 'Texto da opcao C', 7);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('D', 'Texto da opcao D', 7);

INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('A', 'Texto da opcao A', 8);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('B', 'Texto da opcao B', 8);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('C', 'Texto da opcao C', 8);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('D', 'Texto da opcao D', 8);

INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('A', 'Texto da opcao A', 9);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('B', 'Texto da opcao B', 9);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('C', 'Texto da opcao C', 9);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('D', 'Texto da opcao D', 9);

INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('A', 'Texto da opcao A', 10);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('B', 'Texto da opcao B', 10);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('C', 'Texto da opcao C', 10);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('D', 'Texto da opcao D', 10);

INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('A', 'Texto da opcao A', 11);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('B', 'Texto da opcao B', 11);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('C', 'Texto da opcao C', 11);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('D', 'Texto da opcao D', 11);


INSERT INTO tbl_respostas(colaborador_id, pergunta_id, resposta, foi_respondida, data_resposta) VALUES (9, 1, 'A', true, CURRENT_TIMESTAMP);
INSERT INTO tbl_respostas(colaborador_id, pergunta_id, resposta, foi_respondida, data_resposta) VALUES (9, 2, 'C', true, CURRENT_TIMESTAMP);
INSERT INTO tbl_respostas(colaborador_id, pergunta_id, resposta, foi_respondida, data_resposta) VALUES (9, 3, 'C', true, CURRENT_TIMESTAMP);


INSERT INTO tbl_normas (nome, descricao, id_departamento) VALUES ('Norma-1-Marketing', 'Essa é descrição da Norma-1-Marketing', 3);
INSERT INTO tbl_normas (nome, descricao, id_departamento) VALUES ('Norma-2-Marketing', 'Essa é descrição da Norma-2-Marketing', 3);
INSERT INTO tbl_normas (nome, descricao, id_departamento) VALUES ('Norma-3-Marketing', 'Essa é descrição da Norma-3-Marketing', 3);
INSERT INTO tbl_normas (nome, descricao, id_departamento) VALUES ('Norma-4-Marketing', 'Essa é descrição da Norma-4-Marketing', 3);
INSERT INTO tbl_normas (nome, descricao, id_departamento) VALUES ('Norma-5-Marketing', 'Essa é descrição da Norma-5-Marketing', 3);
INSERT INTO tbl_normas (nome, descricao, id_departamento) VALUES ('Norma-1-Financeiro', 'Essa é descrição da Norma-1-Financeiro', 2);
INSERT INTO tbl_normas (nome, descricao, id_departamento) VALUES ('Norma-2-Financeiro', 'Essa é descrição da Norma-2-Financeiro', 2);
INSERT INTO tbl_normas (nome, descricao, id_departamento) VALUES ('Norma-3-Financeiro', 'Essa é descrição da Norma-3-Financeiro', 2);
INSERT INTO tbl_normas (nome, descricao, id_departamento) VALUES ('Norma-4-Financeiro', 'Essa é descrição da Norma-4-Financeiro', 2);
INSERT INTO tbl_normas (nome, descricao, id_departamento) VALUES ('Norma-5-Financeiro', 'Essa é descrição da Norma-5-Financeiro', 2);
INSERT INTO tbl_normas (nome, descricao) VALUES ('Norma-1-Geral', 'Essa é descrição da Norma-1-Geral');
INSERT INTO tbl_normas (nome, descricao) VALUES ('Norma-2-Geral', 'Essa é descrição da Norma-2-Geral');
INSERT INTO tbl_normas (nome, descricao) VALUES ('Norma-3-Geral', 'Essa é descrição da Norma-3-Geral');
INSERT INTO tbl_normas (nome, descricao) VALUES ('Norma-4-Geral', 'Essa é descrição da Norma-4-Geral');
INSERT INTO tbl_normas (nome, descricao) VALUES ('Norma-5-Geral', 'Essa é descrição da Norma-5-Geral');

--12
INSERT INTO tbl_perguntas (enunciado, resposta_correta, tipo, id_norma) VALUES ('Pergunta 1 da norma FINANCEIRO 1', 'A', 'N', 6);
INSERT INTO tbl_perguntas (enunciado, resposta_correta, tipo, id_norma) VALUES ('Pergunta 2 da norma FINANCEIRO 1', 'B', 'N', 6);
INSERT INTO tbl_perguntas (enunciado, resposta_correta, tipo, id_norma) VALUES ('Pergunta 3 do norma FINANCEIRO 1', 'C', 'N', 6);

INSERT INTO tbl_respostas(colaborador_id, pergunta_id, resposta, foi_respondida, data_resposta) VALUES (9, 12, 'A', true, CURRENT_TIMESTAMP);
INSERT INTO tbl_respostas(colaborador_id, pergunta_id, resposta, foi_respondida, data_resposta) VALUES (9, 13, 'C', true, CURRENT_TIMESTAMP);
INSERT INTO tbl_respostas(colaborador_id, pergunta_id, resposta, foi_respondida, data_resposta) VALUES (9, 14, 'C', true, CURRENT_TIMESTAMP);

INSERT INTO tbl_perguntas (enunciado, resposta_correta, tipo, id_norma) VALUES ('Pergunta 1 da norma FINANCEIRO 5', 'A', 'N', 7);
INSERT INTO tbl_perguntas (enunciado, resposta_correta, tipo, id_norma) VALUES ('Pergunta 2 da norma FINANCEIRO 5', 'A', 'N', 7);
INSERT INTO tbl_perguntas (enunciado, resposta_correta, tipo, id_norma) VALUES ('Pergunta 3 do norma FINANCEIRO 5', 'D', 'N', 7);

INSERT INTO tbl_perguntas (enunciado, resposta_correta, tipo, id_norma) VALUES ('Pergunta 1 da norma FINANCEIRO 5', 'D', 'N', 8);
INSERT INTO tbl_perguntas (enunciado, resposta_correta, tipo, id_norma) VALUES ('Pergunta 2 da norma FINANCEIRO 5', 'A', 'N', 8);
INSERT INTO tbl_perguntas (enunciado, resposta_correta, tipo, id_norma) VALUES ('Pergunta 3 do norma FINANCEIRO 5', 'B', 'N', 8);

INSERT INTO tbl_perguntas (enunciado, resposta_correta, tipo, id_norma) VALUES ('Pergunta 1 da norma FINANCEIRO 5', 'B', 'N', 9);
INSERT INTO tbl_perguntas (enunciado, resposta_correta, tipo, id_norma) VALUES ('Pergunta 2 da norma FINANCEIRO 5', 'B', 'N', 9);
INSERT INTO tbl_perguntas (enunciado, resposta_correta, tipo, id_norma) VALUES ('Pergunta 3 do norma FINANCEIRO 5', 'C', 'N', 9);

INSERT INTO tbl_perguntas (enunciado, resposta_correta, tipo, id_norma) VALUES ('Pergunta 1 da norma FINANCEIRO 5', 'C', 'N', 10);
INSERT INTO tbl_perguntas (enunciado, resposta_correta, tipo, id_norma) VALUES ('Pergunta 2 da norma FINANCEIRO 5', 'A', 'N', 10);
INSERT INTO tbl_perguntas (enunciado, resposta_correta, tipo, id_norma) VALUES ('Pergunta 3 do norma FINANCEIRO 5', 'D', 'N', 10);

INSERT INTO tbl_perguntas (enunciado, resposta_correta, tipo, id_norma) VALUES ('Pergunta 1 da norma GERAL 1', 'A', 'N', 11);
INSERT INTO tbl_perguntas (enunciado, resposta_correta, tipo, id_norma) VALUES ('Pergunta 2 da norma GERAL 1', 'B', 'N', 11);
INSERT INTO tbl_perguntas (enunciado, resposta_correta, tipo, id_norma) VALUES ('Pergunta 3 do norma GERAL 1', 'A', 'N', 11);

INSERT INTO tbl_perguntas (enunciado, resposta_correta, tipo, id_norma) VALUES ('Pergunta 1 da norma GERAL 5', 'A', 'N', 12);
INSERT INTO tbl_perguntas (enunciado, resposta_correta, tipo, id_norma) VALUES ('Pergunta 2 da norma GERAL 5', 'D', 'N', 12);
INSERT INTO tbl_perguntas (enunciado, resposta_correta, tipo, id_norma) VALUES ('Pergunta 3 do norma GERAL 5', 'D', 'N', 12);

INSERT INTO tbl_perguntas (enunciado, resposta_correta, tipo, id_norma) VALUES ('Pergunta 1 da norma GERAL 5', 'C', 'N', 13);
INSERT INTO tbl_perguntas (enunciado, resposta_correta, tipo, id_norma) VALUES ('Pergunta 2 da norma GERAL 5', 'C', 'N', 13);
INSERT INTO tbl_perguntas (enunciado, resposta_correta, tipo, id_norma) VALUES ('Pergunta 3 do norma GERAL 5', 'A', 'N', 13);

INSERT INTO tbl_perguntas (enunciado, resposta_correta, tipo, id_norma) VALUES ('Pergunta 1 da norma GERAL 5', 'A', 'N', 14);
INSERT INTO tbl_perguntas (enunciado, resposta_correta, tipo, id_norma) VALUES ('Pergunta 2 da norma GERAL 5', 'A', 'N', 14);
INSERT INTO tbl_perguntas (enunciado, resposta_correta, tipo, id_norma) VALUES ('Pergunta 3 do norma GERAL 5', 'A', 'N', 14);

INSERT INTO tbl_perguntas (enunciado, resposta_correta, tipo, id_norma) VALUES ('Pergunta 1 da norma GERAL 5', 'C', 'N', 15);
INSERT INTO tbl_perguntas (enunciado, resposta_correta, tipo, id_norma) VALUES ('Pergunta 2 da norma GERAL 5', 'C', 'N', 15);
INSERT INTO tbl_perguntas (enunciado, resposta_correta, tipo, id_norma) VALUES ('Pergunta 3 do norma GERAL 5', 'D', 'N', 15);

INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('A', 'Texto da opcao A', 12);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('B', 'Texto da opcao B', 12);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('C', 'Texto da opcao C', 12);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('D', 'Texto da opcao D', 12);

INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('A', 'Texto da opcao A', 13);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('B', 'Texto da opcao B', 13);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('C', 'Texto da opcao C', 13);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('D', 'Texto da opcao D', 13);

INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('A', 'Texto da opcao A', 14);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('B', 'Texto da opcao B', 14);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('C', 'Texto da opcao C', 14);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('D', 'Texto da opcao D', 14);

INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('A', 'Texto da opcao A', 15);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('B', 'Texto da opcao B', 15);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('C', 'Texto da opcao C', 15);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('D', 'Texto da opcao D', 15);

INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('A', 'Texto da opcao A', 16);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('B', 'Texto da opcao B', 16);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('C', 'Texto da opcao C', 16);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('D', 'Texto da opcao D', 16);

INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('A', 'Texto da opcao A', 17);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('B', 'Texto da opcao B', 17);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('C', 'Texto da opcao C', 17);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('D', 'Texto da opcao D', 17);

INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('A', 'Texto da opcao A', 18);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('B', 'Texto da opcao B', 18);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('C', 'Texto da opcao C', 18);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('D', 'Texto da opcao D', 18);

INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('A', 'Texto da opcao A', 19);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('B', 'Texto da opcao B', 19);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('C', 'Texto da opcao C', 19);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('D', 'Texto da opcao D', 19);

INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('A', 'Texto da opcao A', 20);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('B', 'Texto da opcao B', 20);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('C', 'Texto da opcao C', 20);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('D', 'Texto da opcao D', 20);

INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('A', 'Texto da opcao A', 21);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('B', 'Texto da opcao B', 21);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('C', 'Texto da opcao C', 21);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('D', 'Texto da opcao D', 21);

INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('A', 'Texto da opcao A', 22);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('B', 'Texto da opcao B', 22);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('C', 'Texto da opcao C', 22);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('D', 'Texto da opcao D', 22);

INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('A', 'Texto da opcao A', 23);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('B', 'Texto da opcao B', 23);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('C', 'Texto da opcao C', 23);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('D', 'Texto da opcao D', 23);

INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('A', 'Texto da opcao A', 24);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('B', 'Texto da opcao B', 24);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('C', 'Texto da opcao C', 24);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('D', 'Texto da opcao D', 24);

INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('A', 'Texto da opcao A', 25);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('B', 'Texto da opcao B', 25);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('C', 'Texto da opcao C', 25);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('D', 'Texto da opcao D', 25);

INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('A', 'Texto da opcao A', 26);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('B', 'Texto da opcao B', 26);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('C', 'Texto da opcao C', 26);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('D', 'Texto da opcao D', 26);

INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('A', 'Texto da opcao A', 27);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('B', 'Texto da opcao B', 27);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('C', 'Texto da opcao C', 27);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('D', 'Texto da opcao D', 27);

INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('A', 'Texto da opcao A', 28);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('B', 'Texto da opcao B', 28);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('C', 'Texto da opcao C', 28);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('D', 'Texto da opcao D', 28);

INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('A', 'Texto da opcao A', 29);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('B', 'Texto da opcao B', 29);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('C', 'Texto da opcao C', 29);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('D', 'Texto da opcao D', 29);

INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('A', 'Texto da opcao A', 30);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('B', 'Texto da opcao B', 30);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('C', 'Texto da opcao C', 30);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('D', 'Texto da opcao D', 30);

INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('A', 'Texto da opcao A', 31);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('B', 'Texto da opcao B', 31);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('C', 'Texto da opcao C', 31);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('D', 'Texto da opcao D', 31);

INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('A', 'Texto da opcao A', 32);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('B', 'Texto da opcao B', 32);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('C', 'Texto da opcao C', 32);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('D', 'Texto da opcao D', 32);

INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('A', 'Texto da opcao A', 33);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('B', 'Texto da opcao B', 33);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('C', 'Texto da opcao C', 33);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('D', 'Texto da opcao D', 33);

INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('A', 'Texto da opcao A', 34);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('B', 'Texto da opcao B', 34);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('C', 'Texto da opcao C', 34);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('D', 'Texto da opcao D', 34);

INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('A', 'Texto da opcao A', 35);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('B', 'Texto da opcao B', 35);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('C', 'Texto da opcao C', 35);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('D', 'Texto da opcao D', 35);

INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('A', 'Texto da opcao A', 36);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('B', 'Texto da opcao B', 36);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('C', 'Texto da opcao C', 36);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('D', 'Texto da opcao D', 36);

INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('A', 'Texto da opcao A', 37);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('B', 'Texto da opcao B', 37);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('C', 'Texto da opcao C', 37);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('D', 'Texto da opcao D', 37);

INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('A', 'Texto da opcao A', 38);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('B', 'Texto da opcao B', 38);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('C', 'Texto da opcao C', 38);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('D', 'Texto da opcao D', 38);

INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('A', 'Texto da opcao A', 39);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('B', 'Texto da opcao B', 39);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('C', 'Texto da opcao C', 39);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('D', 'Texto da opcao D', 39);

INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('A', 'Texto da opcao A', 40);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('B', 'Texto da opcao B', 40);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('C', 'Texto da opcao C', 40);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('D', 'Texto da opcao D', 40);

INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('A', 'Texto da opcao A', 41);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('B', 'Texto da opcao B', 41);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('C', 'Texto da opcao C', 41);
INSERT INTO tbl_opcoes (opcao, texto, id_pergunta) VALUES ('D', 'Texto da opcao D', 41);

INSERT INTO tbl_integracao (data_inicio, hora_inicio, data_fim, hora_fim, status, qtd_colaboradores, media_progresso, media_acertos, id_rh, id_departamento) VALUES ('2024-09-10', '08:30', '2024-09-30', '17:30', 'NAO_INICIADO', 8, 40.0, 65.0, 1, 2);


INSERT INTO tbl_integracao (data_inicio, hora_inicio, data_fim, hora_fim, status, qtd_colaboradores, media_progresso, media_acertos, id_rh, id_departamento) VALUES ('2024-06-21', '19:18', '2024-06-30', '18:00', 'NAO_INICIADO', 8, 60.0, 95.0, 1, 2);
INSERT INTO tbl_integracao (data_inicio, hora_inicio, data_fim, hora_fim, status, qtd_colaboradores, media_progresso, media_acertos, id_rh, id_departamento) VALUES ('2024-06-21', '19:18', '2024-06-30', '18:00', 'FINALIZADO', 8, 60.0, 95.0, 2, 2);
INSERT INTO tbl_integracao (data_inicio, hora_inicio, data_fim, hora_fim, status, qtd_colaboradores, media_progresso, media_acertos, id_rh, id_departamento) VALUES ('2024-06-21', '19:18', '2024-06-30', '18:00', 'ANDAMENTO', 8, 60.0, 95.0, 2, 3);

INSERT INTO tbl_integracao (data_inicio, hora_inicio, data_fim, hora_fim, status, qtd_colaboradores, media_progresso, media_acertos, id_rh, id_departamento) VALUES ('2024-09-21', '19:18', '2024-09-30', '18:00', 'NAO_INICIADO', 8, 60.0, 95.0, 1, 3);
INSERT INTO tbl_integracao (data_inicio, hora_inicio, data_fim, hora_fim, status, qtd_colaboradores, media_progresso, media_acertos, id_rh, id_departamento) VALUES ('2024-09-09', '19:18', '2024-09-30', '18:00', 'NAO_INICIADO', 8, 60.0, 95.0, 1, 3);


INSERT INTO tbl_colaborador (primeiro_nome, sobrenome, cpf, email, telefone, data_admissao, avatar, sts_integracao, qtd_respondidas, pontuacao, qtd_certas, porc_progresso, numero_matricula, data_nascimento, porc_acertos, id_departamento, id_integracao) VALUES ('Larissa', 'Almeida', '289.092.345-62', 'larissa2.almeida@example.com', '289012341', '2024-06-25', 'avatar1.png', 'NAO_FEZ', 0, 0, 0, 0.0, '73998', '1950-08-29', 0.0, 1, 2);
INSERT INTO tbl_colaborador (primeiro_nome, sobrenome, cpf, email, telefone, data_admissao, avatar, sts_integracao, qtd_respondidas, pontuacao, qtd_certas, porc_progresso, numero_matricula, data_nascimento, porc_acertos, id_departamento, id_integracao) VALUES ('João', 'Silva', '223.496.789-02', 'joao2.silva@example.com', '287654321', '2024-06-25', 'avatar2.png', 'NAO_FEZ', 0, 0, 0, 0.0, '73228', '1970-08-29', 0.0, 1, 2);
INSERT INTO tbl_colaborador (primeiro_nome, sobrenome, cpf, email, telefone, data_admissao, avatar, sts_integracao, qtd_respondidas, pontuacao, qtd_certas, porc_progresso, numero_matricula, data_nascimento, porc_acertos, id_departamento, id_integracao) VALUES ('Maria', 'Santos', '287.694.321-02', 'maria2.santos@example.com', '254987321', '2024-06-25', 'avatar3.png', 'NAO_FEZ', 0, 0, 0, 0.0, '74448', '1950-08-29', 0.0, 1, 2);
INSERT INTO tbl_colaborador (primeiro_nome, sobrenome, cpf, email, telefone, data_admissao, avatar, sts_integracao, qtd_respondidas, pontuacao, qtd_certas, porc_progresso, numero_matricula, data_nascimento, porc_acertos, id_departamento, id_integracao) VALUES ('Pedro', 'Oliveira', '256.799.123-02', 'pedro2.oliveira@example.com', '221654981', '2024-06-25', 'avatar4.png', 'NAO_FEZ', 0, 0, 0, 0.0, '73678', '1950-08-29', 0.0, 1, 2);
INSERT INTO tbl_colaborador (primeiro_nome, sobrenome, cpf, email, telefone, data_admissao, avatar, sts_integracao, qtd_respondidas, pontuacao, qtd_certas, porc_progresso, numero_matricula, data_nascimento, porc_acertos, id_departamento, id_integracao) VALUES ('Ana', 'Rodrigues', '254.391.987-02', 'ana2.rodrigues@example.com', '256123791', '2024-06-25', 'avatar5.png', 'NAO_FEZ', 0, 0, 0, 0.0, '73000', '1950-08-29', 0.0, 1, 2);
INSERT INTO tbl_colaborador (primeiro_nome, sobrenome, cpf, email, telefone, data_admissao, avatar, sts_integracao, qtd_respondidas, pontuacao, qtd_certas, porc_progresso, numero_matricula, data_nascimento, porc_acertos, id_departamento, id_integracao) VALUES ('Carlos', 'Ferreira', '289.193.456-02', 'carlos2.ferreira@example.com', '287456121', '2024-06-25', 'avatar6.png', 'NAO_FEZ', 0, 0, 0, 0.0, '70008', '1955-03-15', 0.0, 1, 2);
INSERT INTO tbl_colaborador (primeiro_nome, sobrenome, cpf, email, telefone, data_admissao, avatar, sts_integracao, qtd_respondidas, pontuacao, qtd_certas, porc_progresso, numero_matricula, data_nascimento, porc_acertos, id_departamento, id_integracao) VALUES ('Juliana', 'Martins', '221.694.987-02', 'juliana2.martins@example.com', '289654321', '2024-06-25', 'avatar7.png', 'NAO_FEZ', 0, 0, 0, 0.0, '71118', '1989-09-03', 0.0, 1, 2);
INSERT INTO tbl_colaborador (primeiro_nome, sobrenome, cpf, email, telefone, data_admissao, avatar, sts_integracao, qtd_respondidas, pontuacao, qtd_certas, porc_progresso, numero_matricula, data_nascimento, porc_acertos, id_departamento, id_integracao) VALUES ('Felipe', 'Gomes', '287.391.654-02', 'felipe2.gomes@example.com', '256789121', '2024-06-25', 'avatar8.png', 'NAO_FEZ', 0, 0, 0, 0.0, '73898', '1975-08-29', 0.0, 1, 2);









INSERT INTO tbl_colaborador (primeiro_nome, sobrenome, cpf, email, telefone, data_admissao, avatar, sts_integracao, qtd_respondidas, pontuacao, qtd_certas, porc_progresso, numero_matricula, data_nascimento, porc_acertos, id_departamento) VALUES ('Larissa', 'Almeida', '239.092.345-62', 'larissa3.almeida@example.com', '119012341', '2024-06-25', 'avatar1.png', 'NAO_FEZ', 0, 0, 0, 0.0, '73998', '1950-08-29', 0.0, 1);
INSERT INTO tbl_colaborador (primeiro_nome, sobrenome, cpf, email, telefone, data_admissao, avatar, sts_integracao, qtd_respondidas, pontuacao, qtd_certas, porc_progresso, numero_matricula, data_nascimento, porc_acertos, id_departamento) VALUES ('João', 'Silva', '255.496.789-02', 'joao3.silva@example.com', '337654321', '2024-06-25', 'avatar2.png', 'NAO_FEZ', 0, 0, 0, 0.0, '73228', '1970-08-29', 0.0, 1);
INSERT INTO tbl_colaborador (primeiro_nome, sobrenome, cpf, email, telefone, data_admissao, avatar, sts_integracao, qtd_respondidas, pontuacao, qtd_certas, porc_progresso, numero_matricula, data_nascimento, porc_acertos, id_departamento) VALUES ('Maria', 'Santos', '200.694.321-02', 'maria3.santos@example.com', '224987321', '2024-06-25', 'avatar3.png', 'NAO_FEZ', 0, 0, 0, 0.0, '74448', '1950-08-29', 0.0, 1);
INSERT INTO tbl_colaborador (primeiro_nome, sobrenome, cpf, email, telefone, data_admissao, avatar, sts_integracao, qtd_respondidas, pontuacao, qtd_certas, porc_progresso, numero_matricula, data_nascimento, porc_acertos, id_departamento) VALUES ('Pedro', 'Oliveira', '211.799.123-02', 'pedro3.oliveira@example.com', '441654981', '2024-06-25', 'avatar4.png', 'NAO_FEZ', 0, 0, 0, 0.0, '73678', '1950-08-29', 0.0, 1);
INSERT INTO tbl_colaborador (primeiro_nome, sobrenome, cpf, email, telefone, data_admissao, avatar, sts_integracao, qtd_respondidas, pontuacao, qtd_certas, porc_progresso, numero_matricula, data_nascimento, porc_acertos, id_departamento) VALUES ('Ana', 'Rodrigues', '254.333.987-02', 'ana3.rodrigues@example.com', '776123791', '2024-06-25', 'avatar5.png', 'NAO_FEZ', 0, 0, 0, 0.0, '73000', '1950-08-29', 0.0, 1);
INSERT INTO tbl_colaborador (primeiro_nome, sobrenome, cpf, email, telefone, data_admissao, avatar, sts_integracao, qtd_respondidas, pontuacao, qtd_certas, porc_progresso, numero_matricula, data_nascimento, porc_acertos, id_departamento) VALUES ('Carlos', 'Ferreira', '289.193.890-02', 'carlos3.ferreira@example.com', '997456121', '2024-06-25', 'avatar6.png', 'NAO_FEZ', 0, 0, 0, 0.0, '70008', '1955-03-15', 0.0, 1);
INSERT INTO tbl_colaborador (primeiro_nome, sobrenome, cpf, email, telefone, data_admissao, avatar, sts_integracao, qtd_respondidas, pontuacao, qtd_certas, porc_progresso, numero_matricula, data_nascimento, porc_acertos, id_departamento) VALUES ('Juliana', 'Martins', '221.111.987-02', 'juliana3.martins@example.com', '119654321', '2024-06-25', 'avatar7.png', 'NAO_FEZ', 0, 0, 0, 0.0, '71118', '1989-09-03', 0.0, 1);
INSERT INTO tbl_colaborador (primeiro_nome, sobrenome, cpf, email, telefone, data_admissao, avatar, sts_integracao, qtd_respondidas, pontuacao, qtd_certas, porc_progresso, numero_matricula, data_nascimento, porc_acertos, id_departamento) VALUES ('Felipe', 'Gomes', '287.567.654-02', 'felipe3.gomes@example.com', '656789121', '2024-06-25', 'avatar8.png', 'NAO_FEZ', 0, 0, 0, 0.0, '73898', '1975-08-29', 0.0, 1);








-- novos
INSERT INTO tbl_integracao (data_inicio, hora_inicio, data_fim, hora_fim, status, qtd_colaboradores, media_progresso, media_acertos, id_rh, id_departamento) VALUES ('2023-09-21', '19:18', '2023-09-30', '18:00', 'FINALIZADO', 8, 60.0, 95.0, 1, 4);
INSERT INTO tbl_colaborador (primeiro_nome, sobrenome, cpf, email, telefone, data_admissao, avatar, sts_integracao, qtd_respondidas, pontuacao, qtd_certas, porc_progresso, numero_matricula, data_nascimento, porc_acertos, id_departamento, id_integracao) VALUES ('Larissa', 'Almeida', '189.000.345-62', 'lalarissa2.almeida@example.com', '1190100041', '2024-06-25', 'avatar1.png', 'FINALIZADO', 0, 0, 0, 0.0, '73998', '1950-08-29', 0.0, 4, 7);
INSERT INTO tbl_colaborador (primeiro_nome, sobrenome, cpf, email, telefone, data_admissao, avatar, sts_integracao, qtd_respondidas, pontuacao, qtd_certas, porc_progresso, numero_matricula, data_nascimento, porc_acertos, id_departamento, id_integracao) VALUES ('João', 'Silva', '223.111.789-02', 'jojoao2.silva@example.com', '227654321', '2024-06-25', 'avatar2.png', 'FINALIZADO', 0, 0, 0, 0.0, '73228', '1970-08-29', 0.0, 4, 7);
INSERT INTO tbl_colaborador (primeiro_nome, sobrenome, cpf, email, telefone, data_admissao, avatar, sts_integracao, qtd_respondidas, pontuacao, qtd_certas, porc_progresso, numero_matricula, data_nascimento, porc_acertos, id_departamento, id_integracao) VALUES ('Maria', 'Santos', '387.222.321-02', 'mamaria2.santos@example.com', '334987321', '2024-06-25', 'avatar3.png', 'FINALIZADO', 0, 0, 0, 0.0, '74448', '1950-08-29', 0.0, 4, 7);
INSERT INTO tbl_colaborador (primeiro_nome, sobrenome, cpf, email, telefone, data_admissao, avatar, sts_integracao, qtd_respondidas, pontuacao, qtd_certas, porc_progresso, numero_matricula, data_nascimento, porc_acertos, id_departamento, id_integracao) VALUES ('Pedro', 'Oliveira', '456.333.123-02', 'pepedro2.oliveira@example.com', '4416234981', '2024-06-25', 'avatar4.png', 'FINALIZADO', 0, 0, 0, 0.0, '73678', '1950-08-29', 0.0, 4, 7);
INSERT INTO tbl_colaborador (primeiro_nome, sobrenome, cpf, email, telefone, data_admissao, avatar, sts_integracao, qtd_respondidas, pontuacao, qtd_certas, porc_progresso, numero_matricula, data_nascimento, porc_acertos, id_departamento, id_integracao) VALUES ('Ana', 'Rodrigues', '554.444.987-02', 'anaana2.rodrigues@example.com', '556123791', '2024-06-25', 'avatar5.png', 'FINALIZADO', 0, 0, 0, 0.0, '73000', '1950-08-29', 0.0, 4, 7);
INSERT INTO tbl_colaborador (primeiro_nome, sobrenome, cpf, email, telefone, data_admissao, avatar, sts_integracao, qtd_respondidas, pontuacao, qtd_certas, porc_progresso, numero_matricula, data_nascimento, porc_acertos, id_departamento, id_integracao) VALUES ('Carlos', 'Ferreira', '689.555.456-02', 'cacarlos2.ferreira@example.com', '667456121', '2024-06-25', 'avatar6.png', 'FINALIZADO', 0, 0, 0, 0.0, '70008', '1955-03-15', 0.0, 4, 7);
INSERT INTO tbl_colaborador (primeiro_nome, sobrenome, cpf, email, telefone, data_admissao, avatar, sts_integracao, qtd_respondidas, pontuacao, qtd_certas, porc_progresso, numero_matricula, data_nascimento, porc_acertos, id_departamento, id_integracao) VALUES ('Juliana', 'Martins', '721.666.987-02', 'jujuliana2.martins@example.com', '779654321', '2024-06-25', 'avatar7.png', 'FINALIZADO', 0, 0, 0, 0.0, '71118', '1989-09-03', 0.0, 4, 7);
INSERT INTO tbl_colaborador (primeiro_nome, sobrenome, cpf, email, telefone, data_admissao, avatar, sts_integracao, qtd_respondidas, pontuacao, qtd_certas, porc_progresso, numero_matricula, data_nascimento, porc_acertos, id_departamento, id_integracao) VALUES ('Felipe', 'Gomes', '887.777.654-02', 'fefelipe2.gomes@example.com', '886789121', '2024-06-25', 'avatar8.png', 'FINALIZADO', 0, 0, 0, 0.0, '73898', '1975-08-29', 0.0, 4, 7);

INSERT INTO tbl_integracao (data_inicio, hora_inicio, data_fim, hora_fim, status, qtd_colaboradores, media_progresso, media_acertos, id_rh, id_departamento) VALUES ('2022-09-21', '19:18', '2022-09-30', '18:00', 'FINALIZADO', 8, 60.0, 95.0, 1, 5);

INSERT INTO tbl_colaborador (primeiro_nome, sobrenome, cpf, email, telefone, data_admissao, avatar, sts_integracao, qtd_respondidas, pontuacao, qtd_certas, porc_progresso, numero_matricula, data_nascimento, porc_acertos, id_departamento, id_integracao) VALUES ('Ana', 'Oliveira', '434.456.789-01', 'a1na.oliveira@example.com', '100023456', '2024-06-01', 'avatar20.png', 'FINALIZADO', 12, 85, 10, 90.0, '80001', '1985-07-15', 83.3, 5, 8);

INSERT INTO tbl_colaborador (primeiro_nome, sobrenome, cpf, email, telefone, data_admissao, avatar, sts_integracao, qtd_respondidas, pontuacao, qtd_certas, porc_progresso, numero_matricula, data_nascimento, porc_acertos, id_departamento, id_integracao) VALUES ('Carlos', 'Martins', '232.567.890-12', 'ca2rlos.martins@example.com', '122234567', '2024-06-05', 'avatar21.png', 'FINALIZADO', 10, 75, 8, 80.0, '80002', '1990-09-20', 80.0, 5, 8);

INSERT INTO tbl_colaborador (primeiro_nome, sobrenome, cpf, email, telefone, data_admissao, avatar, sts_integracao, qtd_respondidas, pontuacao, qtd_certas, porc_progresso, numero_matricula, data_nascimento, porc_acertos, id_departamento, id_integracao) VALUES ('Fernanda', 'Costa', '334.678.901-23', 'fer3nanda.costa@example.com', '133345678', '2024-06-10', 'avatar22.png', 'FINALIZADO', 8, 60, 7, 70.0, '80003', '1988-12-30', 87.5, 5, 8);

INSERT INTO tbl_colaborador (primeiro_nome, sobrenome, cpf, email, telefone, data_admissao, avatar, sts_integracao, qtd_respondidas, pontuacao, qtd_certas, porc_progresso, numero_matricula, data_nascimento, porc_acertos, id_departamento, id_integracao) VALUES ('Ricardo', 'Lima', '113.789.012-34', 'rica4rdo.lima@example.com', '114556789', '2024-06-15', 'avatar23.png', 'FINALIZADO', 14, 95, 12, 85.0, '80004', '1982-03-25', 85.7, 5, 8);

INSERT INTO tbl_colaborador (primeiro_nome, sobrenome, cpf, email, telefone, data_admissao, avatar, sts_integracao, qtd_respondidas, pontuacao, qtd_certas, porc_progresso, numero_matricula, data_nascimento, porc_acertos, id_departamento, id_integracao) VALUES ('Juliana', 'Santos', '221.890.123-45', 'juli1ana.santos@example.com', '188867890', '2024-06-20', 'avatar24.png', 'FINALIZADO', 9, 80, 6, 75.0, '80005', '1991-05-12', 66.7, 5, 8);

INSERT INTO tbl_colaborador (primeiro_nome, sobrenome, cpf, email, telefone, data_admissao, avatar, sts_integracao, qtd_respondidas, pontuacao, qtd_certas, porc_progresso, numero_matricula, data_nascimento, porc_acertos, id_departamento, id_integracao) VALUES ('Roberta', 'Silva', '112.901.234-56', 'rober4ta.silva@example.com', '199978901', '2024-06-25', 'avatar25.png', 'FINALIZADO', 11, 90, 9, 82.0, '80006', '1989-11-18', 81.8, 5, 8);

INSERT INTO tbl_colaborador (primeiro_nome, sobrenome, cpf, email, telefone, data_admissao, avatar, sts_integracao, qtd_respondidas, pontuacao, qtd_certas, porc_progresso, numero_matricula, data_nascimento, porc_acertos, id_departamento, id_integracao) VALUES ('Paula', 'Melo', '555.012.345-67', 'paul3a.melo@example.com', '1765489012', '2024-07-01', 'avatar26.png', 'FINALIZADO', 7, 55, 5, 60.0, '80007', '1986-04-25', 71.4, 5, 8);

INSERT INTO tbl_colaborador (primeiro_nome, sobrenome, cpf, email, telefone, data_admissao, avatar, sts_integracao, qtd_respondidas, pontuacao, qtd_certas, porc_progresso, numero_matricula, data_nascimento, porc_acertos, id_departamento, id_integracao) VALUES ('Leonardo', 'Almeida', '444.123.456-78', 'leo2nardo.almeida@example.com', '121390123', '2024-07-05', 'avatar27.png', 'FINALIZADO', 6, 50, 4, 55.0, '80008', '1987-02-14', 66.7, 5, 8);

INSERT INTO tbl_colaborador (primeiro_nome, sobrenome, cpf, email, telefone, data_admissao, avatar, sts_integracao, qtd_respondidas, pontuacao, qtd_certas, porc_progresso, numero_matricula, data_nascimento, porc_acertos, id_departamento, id_integracao) VALUES ('Mateus', 'Barros', '333.234.567-89', 'mateu3s.barros@example.com', '119232234', '2024-07-10', 'avatar28.png', 'FINALIZADO', 5, 40, 3, 45.0, '80009', '1993-08-19', 60.0, 5, 8);

INSERT INTO tbl_colaborador (primeiro_nome, sobrenome, cpf, email, telefone, data_admissao, avatar, sts_integracao, qtd_respondidas, pontuacao, qtd_certas, porc_progresso, numero_matricula, data_nascimento, porc_acertos, id_departamento, id_integracao) VALUES ('Isabela', 'Gonçalves', '222.345.678-90', 'isa3bela.goncalves@example.com', '119345345', '2024-07-15', 'avatar29.png', 'FINALIZADO', 13, 85, 11, 90.0, '80010', '1992-10-30', 84.6, 5, 8);

INSERT INTO tbl_colaborador (primeiro_nome, sobrenome, cpf, email, telefone, data_admissao, avatar, sts_integracao, qtd_respondidas, pontuacao, qtd_certas, porc_progresso, numero_matricula, data_nascimento, porc_acertos, id_departamento, id_integracao) VALUES ('Gabriel', 'Ferreira', '111.456.789-01', 'gab3riel.ferreira@example.com', '119178956', '2024-07-20', 'avatar30.png', 'FINALIZADO', 15, 100, 13, 95.0, '80011', '1984-06-12', 86.7, 5, 8);




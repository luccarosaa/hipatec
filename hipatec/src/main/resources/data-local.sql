MERGE INTO estudante (id, nome, email, senha, data_nascimento)
KEY(email)
VALUES (1, 'Estudante Local', 'estudante@local.com', '123456', DATE '2000-01-01');

MERGE INTO mentora (id, nome, email, senha, data_nascimento)
KEY(email)
VALUES (1, 'Mentora Local', 'mentora@local.com', '123456', DATE '1995-01-01');

MERGE INTO mentoria (id, titulo, descricao, progresso, id_mentora)
KEY(id)
VALUES (1, 'Primeira mentoria', 'Mentoria criada para testar o ambiente local.', 0, 1);

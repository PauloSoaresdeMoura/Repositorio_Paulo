USE db_prova;

DELETE FROM pergunta
WHERE id > 0;

SELECT id, nome, celular, email, github_usuario
FROM aluno;

SELECT id, disciplina
FROM prova;

SELECT pergunta 
FROM pergunta
WHERE pergunta LIKE 'O que%';

SELECT p.pergunta
FROM pergunta AS p
WHERE LOCATE('O que', pergunta) = 1;

SELECT nome, celular 
FROM aluno
WHERE nome REGEXP '[ulo-son]';

SELECT nome, celular
FROM aluno
WHERE nome LIKE '%ulo' OR nome LIKE '%son';

SELECT pergunta
FROM pergunta
WHERE id LIKE 2 OR id LIKE 5 or id LIKE 7;

USE sakila;

SELECT title AS filmes_cadastrados
FROM film 
WHERE  title REGEXP '[B,H,Z]'
ORDER BY title ASC;

SELECT CONCAT(title, 'duração de', (length DIV 60)
, ';', ROUND( (length / 60) - (length DIV 60)) * 100,0), 'min' AS 'Filme e duração'
, length AS 'tempo em minutos'
FROM film;

SELECT COUNT(*) AS filmes_cadastrados
FROM film;

SELECT title AS filme,
length AS duração
FROM film
WHERE length = 90
ORDER BY length ASC;
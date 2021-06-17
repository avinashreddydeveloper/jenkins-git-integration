DROP TABLE IF EXISTS student;

CREATE TABLE student
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(250) NOT NULL,
    last_name  VARCHAR(250) NOT NULL,
    career     VARCHAR(250) DEFAULT NULL
);

INSERT INTO student (first_name, last_name, career)
VALUES ('Avinash', 'Challa', 'Full stack engineer'),
       ('Venkata', 'Sai', 'Side System');
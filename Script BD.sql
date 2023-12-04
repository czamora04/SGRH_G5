CREATE DATABASE SGRHDB;

USE SGRHDB;

CREATE TABLE empleados (
    id_empleado INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    apellido1 VARCHAR(255) NOT NULL,
    apellido2 VARCHAR(100),
    cedula INT NOT NULL,
    edad INT NOT NULL
);

CREATE TABLE autenticacion (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    usuario VARCHAR(255) NOT NULL,
    pass VARCHAR(16) NOT NULL,
    nombre VARCHAR(255) NOT NULL,
    apellido1 VARCHAR(255) NOT NULL,
    apellido2 VARCHAR(100)
);

INSERT INTO empleados (nombre, apellido1, apellido2, cedula, edad) VALUES
('Carlos', 'Zamora', 'Cespedes', 114240482, 33),
('Vanessa', 'Orias', 'Sanchez', 116080658, 28),
('Maria Elena', 'Cespedes', 'Montero', 135953654, 50),
('Oscar', 'Urena', 'Brenes', 456573498, 42),
('Roberto', 'Castillo', 'Ramirez', 654345494, 25);

INSERT INTO autenticacion (usuario, pass, nombre, apellido1, apellido2) VALUES
('czamora', 'tmp123.', 'Carlos', 'Zamora', 'Cespedes'),
('admin', 'admin', 'admin', 'admin', 'admin');

SELECT * FROM empleados;

SELECT * FROM autenticacion WHERE usuario = 'czamora';
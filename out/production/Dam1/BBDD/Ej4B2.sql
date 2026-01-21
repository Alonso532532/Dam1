DROP DATABASE IF EXISTS CLINICA;

CREATE DATABASE CLINICA;

USE CLINICA;

CREATE TABLE DOCTOR(
	codigo INT PRIMARY KEY,
	nombre VARCHAR(20) NOT NULL,
	especialidad VARCHAR(20),
	CONSTRAINT ck_nombre CHECK (nombre = UPPER(nombre))
);

CREATE TABLE UNIDAD(
	id INT AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(20) NOT NULL UNIQUE,
	planta INT,
	codigo INT,
	CONSTRAINT fk_codigo FOREIGN KEY (codigo) REFERENCES DOCTOR (codigo) ON DELETE CASCADE,
	CONSTRAINT ck_nombre_unidad CHECK (nombre IN ('trauma', 'quemados', 'interna', 'corazón'))
);

CREATE TABLE PACIENTE(
	nuss VARCHAR(9) PRIMARY KEY,
	nombre VARCHAR(20),
	edad INT(2), 
	id_unidad INT DEFAULT 1002,
	fecha_ingreso DATE,
	CONSTRAINT fk_idUnidad FOREIGN KEY (id_unidad) REFERENCES UNIDAD (id) ON DELETE SET DEFAULT,
	CONSTRAINT ck_edad CHECK (edad BETWEEN 5 AND 80),
	CONSTRAINT ck_fechaIngreso CHECK (fecha_ingreso>'2010-01-01')
);

CREATE TABLE ATIENDE(
	nuss_paciente VARCHAR(9),
	codigo_doctor INT,
	fecha DATETIME DEFAULT NOW(),
	sintoma TEXT,
	tratamiento TEXT,
	CONSTRAINT fk_nussPaciente FOREIGN KEY (nuss_paciente) REFERENCES PACIENTE (nuss) ON DELETE CASCADE,
	CONSTRAINT fk_codigoDoctor FOREIGN KEY (codigo_doctor) REFERENCES DOCTOR (codigo) ON DELETE CASCADE,
	CONSTRAINT pk_atiende PRIMARY KEY (nuss_paciente, codigo_doctor, fecha)
);

CREATE TABLE ENFERMERIA(
	codigo INT PRIMARY KEY,
	nombre VARCHAR(20),
	fecha_contrato DATE
);

ALTER TABLE UNIDAD ADD encagrado INT, ADD CONSTRAINT fk_encargado FOREIGN KEY (encagrado) REFERENCES ENFERMERIA (codigo);

ALTER TABLE ATIENDE ADD precio INT DEFAULT 10;

ALTER TABLE PACIENTE ADD sexo CHAR(2), ADD CONSTRAINT ck_sexo CHECK (sexo IN ('M', 'F', 'SD'));

ALTER TABLE DOCTOR DROP nombre, ADD nombre VARCHAR(50);

ALTER TABLE ATIENDE DROP precio;


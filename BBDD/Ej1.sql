-- Si existe borro la BBDD
DROP DATABASE IF EXISTS CLINICA_SALUD;

-- Creo la BBDD
CREATE DATABASE CLINICA_SALUD;

-- Selecciono
USE CLINICA_SALUD;

-- Creo la tabla ESPECIALIDADES
CREATE TABLE ESPECIALIDADES(
	cod_especialidad NUMERIC(3) PRIMARY KEY,
	nombre_especialidad VARCHAR(50) NOT NULL,
	area_medica VARCHAR(30) NOT NULL,
	disponible CHAR(1) DEFAULT 'S',
	CONSTRAINT ck_disponible_especialidades CHECK (disponible IN ('S', 'N')),
	CONSTRAINT ck_areaMedica_especialidades CHECK (area_medica IN ('MEDICINA', 'GENERAL', 'CIRUGIA', 'PEDIATRA', 'CARDIOLOGIA'))
);

-- Creo la tabla MEDICOS
CREATE TABLE MEDICOS(
	num_colegio VARCHAR(15) PRIMARY KEY,
	nombre VARCHAR(40) NOT NULL,
	apellidos VARCHAR(60) NOT NULL,
	telefono VARCHAR(12),
	email VARCHAR(80) NOT NULL,
	fecha_y_hora_alta DATETIME DEFAULT NOW(),
	anos_experiencia INTEGER,
	cod_especialidad NUMERIC(3),
	CONSTRAINT ck_anosExperiencia_medicos CHECK (anos_experiencia>=0 AND anos_experiencia<50),
	CONSTRAINT fk_codEpecialidad_medicos FOREIGN KEY (cod_especialidad) REFERENCES ESPECIALIDADES (cod_especialidad) ON DELETE RESTRICT
);

-- Creo la tabla PACIENTES
CREATE TABLE PACIENTES(
	num_historial INTEGER AUTO_INCREMENT PRIMARY KEY,
	dni VARCHAR(10) NOT NULL UNIQUE,
	nombre VARCHAR(40) NOT NULL,
	apellidos VARCHAR(60) NOT NULL,
	fecha_nacimiento DATETIME NOT NULL,
	grupo_sanguineo VARCHAR(3) NOT NULL,
	alergias TEXT,
	telefono_contacto VARCHAR(12) NOT NULL,
	CONSTRAINT ck_grupoSanguineo_pacientes CHECK (grupo_sanguineo IN ('A+', 'A-', 'B+', 'B-', 'AB+', 'AB-', 'O+', 'O-'))
);

-- Creo la tabla CONSULTAS
CREATE TABLE CONSULTAS(
	cod_consulta INTEGER AUTO_INCREMENT PRIMARY KEY,
	num_historial_paciente INTEGER,
	num_colegiado_medico VARCHAR(15),
	fecha_consulta DATETIME DEFAULT NOW(),
	diagnostico VARCHAR(200),
	precio DECIMAL(6,2),
	pagado CHAR DEFAULT 'S',
	CONSTRAINT ck_pagado_consultas CHECK (pagado IN ('S', 'N')),
	CONSTRAINT ck_precio_consultas CHECK (precio>0 AND precio<5000),
	CONSTRAINT fk_numHistorialPaciente_consultas FOREIGN KEY (num_historial_paciente) REFERENCES PACIENTES (num_historial) ON DELETE CASCADE,
	CONSTRAINT fk_numColegiadoMedico_consultas FOREIGN KEY (num_colegiado_medico) REFERENCES MEDICOS (num_colegio) ON DELETE RESTRICT
);

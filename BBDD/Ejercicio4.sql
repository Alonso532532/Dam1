-- Ejercicio 3
-- Pedidos
-- Nombre: Alonso
-- Fecha: 28/11/2025

DROP DATABASE IF EXISTS hospital;

-- Creo la base de datos
CREATE DATABASE hospital;

USE hospital;

CREATE TABLE enfermedad(
	id_enfermedad NUMERIC PRIMARY KEY,
	nombre VARCHAR(20) UNIQUE NOT NULL,
	descripción VARCHAR(30),
	t_recuperación INTEGER
);

CREATE TABLE paciente(
	id_paciente NUMERIC PRIMARY KEY,
	nombre VARCHAR(20),
	apellidos VARCHAR(30),
	f_nacimiento DATE,
	población INTEGER,
	id_medico NUMERIC,
	CONSTRAINT fk_idMedico_paciente FOREIGN KEY (id_medico) REFERENCES paciente (id_paciente)
);

CREATE TABLE historial(
	id_historial NUMERIC PRIMARY KEY,
	grupo_sanguineo VARCHAR(20),
	id_paciente NUMERIC,
	CONSTRAINT fk_idMedico_historial FOREIGN KEY (id_paciente) REFERENCES paciente (id_paciente)
);

CREATE TABLE liena_historial(
	num_linea NUMERIC PRIMARY KEY,
	id_historial NUMERIC,
	id_enfermedad NUMERIC NOT NULL,
	f_inicio DATE,
	f_fin DATE,
	síntomas VARCHAR(20),
	observaciones VARCHAR(20),
	CONSTRAINT fk_idHistorial_lh FOREIGN KEY (id_historial) REFERENCES historial (id_historial),
	CONSTRAINT fk_idEnfermedad_lh FOREIGN KEY (id_enfermedad) REFERENCES enfermedad (id_enfermedad),
	CONSTRAINT ck_date_lh CHECK (f_inicio < f_fin)
);

CREATE TABLE localizacion(
	id_localizacion NUMERIC PRIMARY KEY,
	cp VARCHAR(5),
	ciudad VARCHAR(50),
	riesgo VARCHAR(1) DEFAULT '1'
);

CREATE TABLE estancias_pacientes(
	id_paciente NUMERIC,
	id_localizacion NUMERIC,
	f_entrada DATE,
	f_salida DATE,
	CONSTRAINT fk_idPacientes_ep FOREIGN KEY (id_paciente) REFERENCES paciente (id_paciente),
	CONSTRAINT fk_idLocalizacion_ep FOREIGN KEY (id_localizacion) REFERENCES localizacion (id_localizacion),
	CONSTRAINT pk_pacientesLocalizacion_ep PRIMARY KEY (id_paciente, id_localizacion)
);

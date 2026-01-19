DROP DATABASE IF EXISTS BIBLIOTECA_DIGITAL;

CREATE DATABASE BIBLIOTECA_DIGITAL;

USE BIBLIOTECA_DIGITAL;

CREATE TABLE EDITORIALES(
	cif VARCHAR(12) PRIMARY KEY,
	nombre VARCHAR(80) NOT NULL UNIQUE,
	pais_origen VARCHAR(50),
	anio_fundacion INT(4),
	web VARCHAR(150),
	activa CHAR(1) DEFAULT 'S',
	CONSTRAINT ck_cif CHECK (cif = UPPER(cif)), -- No hace falta aprenderlo
	CONSTRAINT ck_anioFundacion CHECK (anio_fundacion BETWEEN 1800 AND 2026),
	CONSTRAINT ck_activa CHECK (activa IN ('S', 'N'))
);

CREATE TABLE AUTORES(
	id_autor INT AUTO_INCREMENT PRIMARY KEY,
	nombre_completo VARCHAR(100) NOT NULL,
	nacionalidad VARCHAR(50),
	fecha_nacimiento DATE,
	fecha_fallecimiento DATE,
	biografia TEXT,
	permisos VARCHAR(200),
	CONSTRAINT ck_fechaFallecimientoFechaNacimiento CHECK (fecha_fallecimiento>fecha_nacimiento)
);
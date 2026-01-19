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
	CONSTRAINT ck_fechaFallecimientoFechaNacimiento CHECK (fecha_fallecimiento IS NULL AND (fecha_fallecimiento>fecha_nacimiento))
);

CREATE TABLE LIBROS(
	isbn VARCHAR(17) PRIMARY KEY,
	titulo VARCHAR(150) NOT NULL,
	anio_publicacion INT(4),
	num_paginas INT,
	idioma VARCHAR(20),
	genero VARCHAR(30) NOT NULL,
	formato VARCHAR(15) DEFAULT 'DIGITAL',
	precio_compra DECIMAL(6,2),
	dispone CHAR(1) DEFAULT 'S', --
	cif_editorial VARCHAR(12), --
	CONSTRAINT ck_anioPublicacion CHECK (anio_publicacion BETWEEN 1000 AND 2027);
	CONSTRAINT ck_numPaginas CHECK (num_paginas>0);
	CONSTRAINT ck_idioma CHECK (idioma IN ('ESPAÑOL', 'INGLES', 'FRANCES', 'ALEMAN', 'ITALIANO', 'PORTUGUES'));
	CONSTRAINT ck_formato CHECK (formato IN ('DIGITAL', 'FISICO', 'AMBOS'));
	CONSTRAINT ck_precioCompra CHECK (precio_compra>0);
	CONSTRAINT ck_dispone CHECK (dispone IN ('N', 'S'));
	CONSTRAINT fk_cifEditorial FOREIGN KEY cif_editorial REFERENCES EDITORIALES(cif) ON DELETE RESTRICT;
);
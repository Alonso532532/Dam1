-- Creación de una base de datos

DROP DATABASE pascual;

CREATE DATABASE pascual;

-- Nos posicionamos

USE pascual;

-- Creación de una tabla

CREATE TABLE camisetas (
	cantidad int,
	color VARCHAR(20) DEFAULT 'Rojo',
	tamano int,
	posicion_armario int PRIMARY KEY
);

CREATE TABLE profesor (
	cant_vale int,
	clase int,
	dia int,
	camiseta int,
	CONSTRAINT pk_dos_dia_clase PRIMARY KEY (dia,clase),
	CONSTRAINT fk_dos_pos FOREIGN KEY (camiseta) REFERENCES camisetas (posicion_armario) ON DELETE CASCADE
);
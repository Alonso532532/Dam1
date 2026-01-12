DROP DATABASE IF EXISTS deportes;

CREATE DATABASE deportes;

USE deportes

CREATE TABLE equipo(
	codigo INTEGER AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(20),
	fecha_creacion DATETIME
);

CREATE TABLE jugador(
	codigo CHAR(6) PRIMARY KEY,
	nombre VARCHAR(20),
	apellidos VARCHAR(20),
	posicion INTEGER
);

CREATE TABLE juega(
	codigoJugador CHAR(6),
	codigoEquipo INTEGER,
	fecha_contreto DATETIME,
	CONSTRAINT fk_codigoJugador_juega FOREIGN KEY (codigoJugador) REFERENCES jugador (codigo),
	CONSTRAINT fk_codigoEquipo_juega FOREIGN KEY (codigoEquipo) REFERENCES equipo (codigo)
);

-- Ejercicio 2 DDL

DROP DATABASE restricciones;

-- Creamos la base de datos
CREATE DATABASE restricciones;

USE restricciones;

-- Crear tablas

CREATE TABLE provincias (
	cod_provincia NUMERIC(2) PRIMARY KEY,
	nombre_provincia	VARCHAR(25) NOT NULL,
	pais VARCHAR(25), 
	CONSTRAINT ck_provincias_pais CHECK (pais IN ('España', 'Italia', 'Portugal'))
);

-- Inserto un registro
INSERT INTO provincias VALUES (1, 'Ávila', 'España');

CREATE TABLE empresas (
	cod_empresa NUMERIC(2) PRIMARY KEY,
	nombre VARCHAR(25) NOT NULL DEFAULT 'empresa1',
	fecha_creacion DATETIME DEFAULT NOW()
);

-- Inserto un registro
INSERT INTO empresas (cod_empresa, nombre) VALUES ('20', 'Alfa21 S.A');

CREATE TABLE continentes (
	cod_continente NUMERIC(2) PRIMARY KEY,
	nombre VARCHAR(20) NOT NULL DEFAULT 'Europa'
);

CREATE TABLE alumnos (
	cod_continente NUMERIC(3) PRIMARY KEY,
	nombre VARCHAR(21) NOT NULL,
	apellido VARCHAR(30) NOT NULL,
	curso NUMERIC(1),
	fecha_matricula DATETIME DEFAULT NOW(),
	CONSTRAINT ck_alumnos_curso CHECK (curso>=1 AND curso<=3)
	-- También se puede hacer así
	-- 	CONSTRAINT ck_alumnos_curso CHECK (curso BETWEEN 1 AND 3)
);

CREATE TABLE empleados (
	cod_empleado NUMERIC(2) PRIMARY KEY,
	nombre VARCHAR(20) NOT NULL,
	apellido VARCHAR(25),
	salario DECIMAL(7,2), -- Determina que habrán 7 carácteres enteros y 2 decimales
	provincias NUMERIC(2),
	empresas NUMERIC(2),
	CONSTRAINT ck_emp_salario CHECK (salario>0),
	CONSTRAINT fk_emp_provincia FOREIGN KEY (provincias) REFERENCES provincias (cod_provincia) ON DELETE CASCADE,
	CONSTRAINT fk_emp_empresa FOREIGN KEY (empresas) REFERENCES empresas (cod_empresa)
	-- Primero se pone el atributo, luego la tabla y luego el campo de la tabla
);

CREATE TABLE personas (
	dni CHAR(9) PRIMARY KEY,
	nombre VARCHAR(20),
	direccion VARCHAR(100),
	codprovin NUMERIC(4),
	CONSTRAINT fk_personas_codprovin FOREIGN KEY (codprovin) REFERENCES provincias (cod_provincia) ON DELETE CASCADE
);

CREATE TABLE ejemplo1 (
	dni VARCHAR(10) PRIMARY KEY,
	nombre VARCHAR(30),
	edad NUMERIC(2),
	fecha DATE
);

CREATE TABLE ejemplo3 (
	dni VARCHAR(10) PRIMARY KEY NOT NULL,
	nombre VARCHAR(30),
	edad NUMERIC(2),
	curso NUMERIC,
	CONSTRAINT ck_ej3_edad CHECK (edad>=5 AND edad<=20),
	CONSTRAINT ck_ej3_curso CHECK (edad>=1 AND edad<=3)
);

CREATE TABLE  alumnos2 (
	codigo NUMERIC(2) PRIMARY KEY,
	nombre VARCHAR(25) NOT NULL
);

CREATE TABLE modulos (
	codigo INTEGER PRIMARY KEY,
	nombre VARCHAR(25)
);

CREATE TABLE notas (
	cod_alumno NUMERIC(2),
	cod_modulo INTEGER,
	nota NUMERIC(2),
	CONSTRAINT pk_cod_al_mod PRIMARY KEY (cod_alumno, cod_modulo),
	CONSTRAINT fk_cod_alumno_notas FOREIGN KEY (cod_alumno) REFERENCES alumnos2 (codigo),
	CONSTRAINT fk_cod_modulo_notas FOREIGN KEY (cod_modulo) REFERENCES modulos (codigo)
);
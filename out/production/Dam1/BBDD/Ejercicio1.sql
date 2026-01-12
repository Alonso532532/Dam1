-- EJ 1
-- Creación BBDD
DROP DATABASE terfrutos;
CREATE DATABASE terfrutos;
USE terfrutos;

-- TABLAS

CREATE TABLE tiendas (
	numero_tienda NUMERIC(2), -- Campo numerico de 2 cifras
	direccion VARCHAR(100),
	cp_tienda char(5),
	telefono char(9),
	CONSTRAINT pk_tiendas_numero PRIMARY KEY (numero_tienda)
);

CREATE TABLE vendedores (
	nombre VARCHAR(90),
	nif char(12),
	domicilio VARCHAR(100),
	cp_vendedor CHAR(5),
	ciudad VARCHAR(20),
	telefono CHAR(9),
	fecha_nacimiento DATE,
	estado_civil VARCHAR(20),
	numero_hijos SMALLINT,
	numero_tienda NUMERIC(2),
	CONSTRAINT pk_vendedores_nif PRIMARY KEY (nif),
	CONSTRAINT fk_vendedores_tienda FOREIGN KEY (numero_tienda) REFERENCES tiendas (numero_tienda) ON DELETE SET NULL
);

--  Modificaciónes
-- Inserto vatios campo a vendedores
-- "Enum" solo tiene el valor de 's' o 'n'

ALTER TABLE vendedores ADD minusvalia ENUM('s', 'n') AFTER numero_hijos;
ALTER TABLE vendedores ADD sueldo FLOAT;

-- Modifico el estado_civil de la tabla vendedores

ALTER TABLE vendedores MODIFY estado_civil CHAR(1);
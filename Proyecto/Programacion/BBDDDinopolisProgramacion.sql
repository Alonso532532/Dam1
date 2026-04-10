DROP DATABASE IF EXISTS Dinopolis;

CREATE DATABASE Dinopolis;

USE Dinopolis;

-- TABLAS DE DINOPOLIS

CREATE TABLE Clientes(
	DNI VARCHAR(9) PRIMARY KEY,
	edad INTEGER,
	nombre VARCHAR(50)
);

CREATE TABLE Entrada(
	numeroDeEntrada INTEGER AUTO_INCREMENT PRIMARY KEY,
	tipo VARCHAR(20),
	precio DOUBLE DEFAULT 0,
	DNI VARCHAR(9) NOT NULL,
	CONSTRAINT fk_DNI_Entrada FOREIGN KEY (DNI) REFERENCES Clientes (DNI),
	CONSTRAINT ck_tipo_Entrada CHECK (tipo IN ('Oferta', 'Normal', 'Familia numerosa')),
	CONSTRAINT ck_precio_Entrada CHECK (precio >= 0)
);

CREATE TABLE Zonas(
	numeroDeZona INTEGER AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(50) NOT NULL
);

CREATE TABLE Visita(
	DNI VARCHAR(9),
	numeroDeZona INTEGER,
	CONSTRAINT pk_visita PRIMARY KEY (DNI, numeroDeZona),
	CONSTRAINT fk_numeroDeZona_Visita FOREIGN KEY (numeroDeZona) REFERENCES Zonas (numeroDeZona),
	CONSTRAINT fk_DNI_Visita FOREIGN KEY (DNI) REFERENCES Clientes (DNI)
);

CREATE TABLE Atracciones(
	numeroDeAtraccion INTEGER AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(50) NOT NULL,
	numeroDeZona INTEGER,
	CONSTRAINT fk_numeroDeZona_Atracciones FOREIGN KEY (numeroDeZona) REFERENCES Zonas (numeroDeZona)
);

insert into Clientes () 
	values 
	("19232120D", 23, "Juan Carlos"),
	("29232320G", 54, "Hugo Lozano"),
	("17352120H", 11, "Pedro");

insert into Entrada (tipo, precio, DNI) 
	values 
	('Normal', 21.30, "19232120D"),
	('Familia numerosa', 16.80, "29232320G"),
	('Familia numerosa', 16.80, "29232320G");

insert into Zonas (nombre) 
	values
	("Paleosenda"),
	("Patio exterior"),
	("Recepción");

insert into Visita () 
	values
	('17352120H', 3),
	('29232320G', 3),
	('17352120H', 2),
	('29232320G', 2),
	('17352120H', 1);

insert into Atracciones (nombre, numeroDeZona) 
	values
	('Laberinto', 2),
	('Museo', 2),
	('Trenecito', 1),
	('Teatro', 1);

-- USUARIOS DEL PROGRAMA

create table Usuarios(
	nombre VARCHAR(20) primary key,
	contrasena VARCHAR(50) not null
);
	

insert into Usuarios () 
	values
	('Admin', 'Sor2425$');


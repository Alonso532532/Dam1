DROP DATABASE IF EXISTS DinopolisBBDD;

CREATE DATABASE DinopolisBBDD;

USE DinopolisBBDD;

-- TABLAS DE DINOPOLIS

create table Persona(
	DNI VARCHAR(9) PRIMARY KEY,
	edad INTEGER,
	nombre VARCHAR(50) not null,
	constraint ck_edad_Persona check (edad >= 0)
);

create table Clientes(
	DNI VARCHAR(9) PRIMARY key,
	constraint fk_DNI_Clientes foreign key (DNI) references Persona (DNI)
);

create table Entrada(
	numeroDeEntrada INTEGER AUTO_INCREMENT PRIMARY KEY,
	tipo VARCHAR(20),
	precio DOUBLE DEFAULT 0,
	DNI VARCHAR(9) NOT NULL,
	CONSTRAINT fk_DNI_Entrada FOREIGN KEY (DNI) REFERENCES Clientes (DNI),
	CONSTRAINT ck_tipo_Entrada CHECK (tipo IN ('Oferta', 'Normal', 'Familia numerosa')),
	CONSTRAINT ck_precio_Entrada CHECK (precio >= 0)
);

create table Trabajadores(
	DNI VARCHAR(9) primary key,	
	NUSS VARCHAR(14) not null,
	DNI_Jefe VARCHAR(9) not null,
	constraint fk_DNI_Trabajadores foreign key (DNI) references Persona (DNI),
	constraint fk_DNI_TrabajadoresJefe foreign key (DNI_Jefe) references Trabajadores (DNI)
);

create table Vigilantes(
	DNI VARCHAR(9) primary key,
	constraint fk_DNI_Vigilantes foreign key (DNI) references Trabajadores (DNI)
);

create table Limpiadores(
	DNI VARCHAR(9) primary key,
	constraint fk_DNI_Limpiadores foreign key (DNI) references Trabajadores (DNI)
);

create table Cajeros(
	DNI VARCHAR(9) primary key,
	constraint fk_DNI_Cajeros foreign key (DNI) references Trabajadores (DNI)
);

create table Actores(
	DNI VARCHAR(9) primary key,
	constraint fk_DNI_Actores foreign key (DNI) references Trabajadores (DNI)
);

create table Zonas(
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


create table ZonasEntretenimiento(
	numeroDeZona INTEGER PRIMARY KEY,
	constraint fk_numeroDeZona_ZonasEntretenimiento foreign key (numeroDeZona) references Zonas (numeroDeZona)
);

create table ZonasRecepcion(
	numeroDeZona INTEGER PRIMARY KEY,
	constraint fk_numeroDeZona_ZonasRecepcion foreign key (numeroDeZona) references Zonas (numeroDeZona)
);

create table Vigila(
	numeroDeZona INTEGER,
	DNI VARCHAR(9),
	constraint fk_numeroDeZona_Vigila foreign key (numeroDeZona) references Zonas (numeroDeZona),
	constraint fk_DNI_Vigila foreign key (DNI) references Vigilantes (DNI)
);

create table Limpia(
	numeroDeZona INTEGER,
	DNI VARCHAR(9),
	constraint fk_numeroDeZona_Limpia foreign key (numeroDeZona) references Zonas (numeroDeZona),
	constraint fk_DNI_Limpia foreign key (DNI) references Limpiadores (DNI)
);

create table Trabaja(
	numeroDeZona INTEGER,
	DNI VARCHAR(9),
	constraint fk_numeroDeZona_Trabaja foreign key (numeroDeZona) references ZonasRecepcion (numeroDeZona),
	constraint fk_DNI_Trabaja foreign key (DNI) references Cajeros (DNI)
);

create table Atracciones(
	numeroDeAtraccion INTEGER auto_increment primary key,
	nombre VARCHAR(30) not NULL
);

create table AtraccionesZona(
	numeroDeAtraccion INTEGER,
	numeroDeZona INTEGER,
	constraint pk_AtraccionesZona primary key (numeroDeAtraccion, numeroDeZona),
	constraint fk_numeroDeZona_AtraccionesZona foreign key (numeroDeZona) references Zonas (numeroDeZona),
	constraint fk_numeroDeAtraccion_AtraccionesZona foreign key (numeroDeAtraccion) references Atracciones (numeroDeAtraccion)
);

create table Actua(
	numeroDeAtraccion INTEGER,
	DNI VARCHAR(9),
	constraint pk_AtraccionesZona primary key (numeroDeAtraccion, DNI),
	constraint fk_numeroDeAtraccion_Trabaja foreign key (numeroDeAtraccion) references Atracciones (numeroDeAtraccion),
	constraint fk_DNI_Actua foreign key (DNI) references Actores (DNI)
);

create table Categoria(
	nombre VARCHAR(30) primary key,
	descripcion VARCHAR(100)
);

create table Pertenece(
	numeroDeAtraccion INTEGER,
	nombre VARCHAR(30),
	constraint pk_AtraccionesZona primary key (numeroDeAtraccion, nombre),
	constraint fk_numeroDeAtraccion_Pertenece foreign key (numeroDeAtraccion) references Atracciones (numeroDeAtraccion),
	constraint fk_nombre_Pertenece foreign key (nombre) references Categoria (nombre)
);
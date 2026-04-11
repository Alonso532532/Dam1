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

insert into Persona ()
	values
	('11111111A', 23, 'Juan Carlos'),
	('22222222A', 73, 'Maria'),
	('33333333A', 34, 'Carlos Casado'),
	
	('44444444A', 12, 'Marcos Inojosa'),
	('55555555A', 43, 'Emanuel Ciro'),
	('66666666A', 82, 'Pablo Miguel'),
	('77777777A', 45, 'Carla Romero'),
	('88888888A', 34, 'Iker Lozano'),
	('99999999A', 23, 'Hernesto'),
	('11111111B', 53, 'Hector Criado'),
	('22222222B', 19, 'Sara'),
	('33333333B', 64, 'Jeffry'),
	('44444444B', 53, 'Estela Ramirez');

insert into Clientes ()
	values
	('11111111A'),
	('22222222A'),
	('33333333A');

insert into Entrada (tipo, precio, DNI)
	values 
	('Oferta', 15.26, '11111111A'),
	('Normal', 21.58, '11111111A'),
	('Familia numerosa', 17.20, '22222222A');

insert into Trabajadores ()
	values
	('44444444A', '11 12345678 90', '44444444A'),
	('55555555A', '22 12345678 90', '44444444A'),
	('66666666A', '33 12345678 90', '44444444A'),
	('77777777A', '44 12345678 90', '77777777A'),
	('88888888A', '55 12345678 90', '77777777A'),
	('99999999A', '66 12345678 90', '99999999A'),
	('11111111B', '77 12345678 90', '99999999A'),
	('22222222B', '88 12345678 90', '22222222B'),
	('33333333B', '99 12345678 90', '22222222B'),
	('44444444B', '00 12345678 90', '22222222B');

insert into Vigilantes ()
	values
	('44444444A'),
	('55555555A'),
	('66666666A');

insert into Limpiadores ()
	values
	('77777777A'),
	('88888888A');

insert into Cajeros ()
	values
	('99999999A'),
	('11111111B');

insert into Actores ()
	values
	('22222222B'),
	('33333333B'),
	('44444444B');


insert into Zonas (nombre)
	values
	('Paleosenda'),
	('Entrada'),
	('Patio exterior');

insert into Visita ()
	values 
	('11111111A', 2),
	('33333333A', 2),
	('11111111A', 3),
	('33333333A', 3),
	('22222222A', 2),
	('22222222A', 3);

insert into ZonasEntretenimiento ()
	values 
	(1),
	(3);

insert into ZonasRecepcion ()
	values 
	(2);

insert into Vigila ()
	values 
	(2, '44444444A'),
	(1, '55555555A'),
	(3, '66666666A');

insert into Limpia ()
	values 
	(1, '77777777A'),
	(2, '77777777A'),
	(3, '88888888A');

insert into Trabaja ()
	values 
	(2, '99999999A'),
	(2, '11111111B');

insert into Atracciones (nombre)
	values 
	('Laberinto'),
	('Museo'),
	('Trenecito'),
	('Teatro');

insert into AtraccionesZona ()
	values 
	(1, 1),
	(2, 3),
	(3, 3),
	(4, 3);

insert into Actua ()
	values 
	(4, '22222222B'),
	(4, '33333333B'),
	(4, '44444444B');

insert into Categoria ()
	values 
	('Informativo', 'Contiene información interesante'),
	('Para niños', 'Enfocado a un publico infantil'),
	('Colaborativo', 'Requiere de la colaboración del publico'),
	('Claustrofobico', 'Puede ser peligroso para personas claustrofobicas');

insert into Pertenece ()
	values 
	(1, 'Claustrofobico'),
	(1, 'Para niños'),
	(2, 'Informativo'),
	(3, 'Para niños'),
	(4, 'Para niños'),
	(4, 'Informativo'),
	(4, 'Colaborativo');



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
	dispone CHAR(1) DEFAULT 'S',
	cif_editorial VARCHAR(12),
	CONSTRAINT ck_anioPublicacion CHECK (anio_publicacion BETWEEN 1000 AND 2027),
	CONSTRAINT ck_numPaginas CHECK (num_paginas>0),
	CONSTRAINT ck_idioma CHECK (idioma IN ('ESPAÑOL', 'INGLES', 'FRANCES', 'ALEMAN', 'ITALIANO', 'PORTUGUES')),
	CONSTRAINT ck_formato CHECK (formato IN ('DIGITAL', 'FISICO', 'AMBOS')),
	CONSTRAINT ck_precioCompra CHECK (precio_compra>0),
	CONSTRAINT ck_dispone CHECK (dispone IN ('N', 'S')),
	CONSTRAINT fk_cifEditorial FOREIGN KEY (cif_editorial) REFERENCES EDITORIALES (cif) ON DELETE RESTRICT
);

CREATE TABLE LIBROS_AUTORES(
	isbn VARCHAR(17),
	id_autor INT,
	orden_autor INT DEFAULT 1,
	CONSTRAINT PRIMARY KEY (isbn, id_autor),
	CONSTRAINT ck_ordenAutor CHECK (orden_autor>0),
	CONSTRAINT fk_idAutor FOREIGN KEY (id_autor) REFERENCES AUTORES (id_autor) ON DELETE CASCADE,
	CONSTRAINT fk_isbn FOREIGN KEY (isbn) REFERENCES LIBROS (isbn) ON DELETE CASCADE
);

CREATE TABLE SOCIOS(
	num_socio INT AUTO_INCREMENT PRIMARY KEY,
	dni VARCHAR(10) NOT NULL UNIQUE,
	nombre VARCHAR(40) NOT NULL,
	apellidos VARCHAR(60) NOT NULL,
	email VARCHAR(100) NOT NULL UNIQUE,
	telefono VARCHAR(12),
	fecha_alta DATETIME DEFAULT NOW(),
	tipo_socio VARCHAR(15) DEFAULT 'BASICO',
	cuota_pagada CHAR(1) DEFAULT 'N', --
	penalizaciones INT DEFAULT 0, --
	CONSTRAINT ck_tipoSocio CHECK (tipo_socio IN ('BASICO', 'PREMIUM', 'VIP')),
	CONSTRAINT ck_cuotaPagada CHECK (cuota_pagada IN ('S', 'N')),
	CONSTRAINT ck_penalizaciones CHECK (penalizaciones BETWEEN 0 AND 10)
);

CREATE TABLE PRESTAMOS(
	id_prestamo INT AUTO_INCREMENT PRIMARY KEY,
	num_socio INT,
	isbn VARCHAR(17),
	fecha_prestamo DATETIME DEFAULT NOW() NOT NULL,
	fecha_devolucion_prevista DATE NOT NULL,
	fecha_devolucion_real DATE,
	estado VARCHAR(20) DEFAULT 'EN_PRESTAMO', --
	renovaciones INT DEFAULT 0,
	CONSTRAINT fk_numSocio FOREIGN KEY (num_socio) REFERENCES SOCIOS (num_socio),
	CONSTRAINT fk_isbn_prestamos FOREIGN KEY (isbn) REFERENCES LIBROS (isbn),
	CONSTRAINT ck_estado CHECK (estado IN ('EN_PRESTAMO', 'DEVUELTO', 'RETRASADO', 'PERDIDO')),
	CONSTRAINT ck_fechas CHECK (fecha_devolucion_prevista>fecha_prestamo)
);

ALTER TABLE LIBROS ADD sinopsis TEXT;

ALTER TABLE LIBROS ADD CONSTRAINT ck_sinopsis CHECK (sinopsis IN ('NOVELA', 'ENSAYO', 'POESIA', 'TEATRO', 'CIENCIA', 'HISTORIA', 'BIOGRAFIA', 'INFANTIL'));

ALTER TABLE LIBROS ADD valoracion_media DECIMAL(4,2), ADD CONSTRAINT ck_valoracionMedia CHECK (valoracion_media BETWEEN 0 AND 5);

ALTER TABLE SOCIOS DROP CONSTRAINT ck_penalizaciones, ADD CONSTRAINT ck_penalizaciones CHECK (penalizaciones BETWEEN 0 AND 20);

ALTER TABLE PRESTAMOS ADD observaciones VARCHAR(300);

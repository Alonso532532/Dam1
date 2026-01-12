-- ejercicio 2 Academia virtual Fecha /09/01/26 Alonso

-- Borramos la BBDD
DROP DATABASE IF EXISTS ACADEMIA_VIRTUAL;

-- Crear la BBDD
CREATE DATABASE ACADEMIA_VIRTUAL;

-- Nos situamos
USE ACADEMIA_VIRTUAL;

-- Creamos la tabla CATEGORIAS
CREATE TABLE CATEGORIA (
	id_categoria INT AUTO_INCREMENT PRIMARY KEY,
	nombre_categoria VARCHAR(40) NOT NULL UNIQUE,
	descripcion VARCHAR(150),
	activa CHAR(1) DEFAULT 'S',
	CONSTRAINT ck_activa CHECK (activa IN ('S', 'N'))
);

CREATE TABLE INSTRUCTORES (
	email VARCHAR(100) PRIMARY KEY,
	nombre_completo VARCHAR (80) NOT NULL,
	biografia TEXT,
	puntuacion_media DECIMAL(3,2),
	certificado CHAR(1),
	linkedin VARCHAR(150),
	CONSTRAINT ck_puntuacionMedia CHECK (puntuacion_media BETWEEN 0 AND 5),
	CONSTRAINT ck_certificado CHECK (certificado IN ('S', 'N'))
);

CREATE TABLE CURSOS (
	cod_curso VARCHAR(10) PRIMARY KEY,
	titulo VARCHAR(100) NOT NULL,
	descripcion TEXT,
	nivel VARCHAR(15),
	duracion_horas INT,
	precio DECIMAL(6,2),
	fecha_creacion DATETIME DEFAULT NOW(),
	plazas_max INT,
	id_categoria INT,
	email_instructor VARCHAR(100),
	CONSTRAINT nivel_valores CHECK (nivel IN ('BASICO', 'INTERMEDIO', 'AVANZADO', 'EXPERTO')),
	CONSTRAINT horas CHECK (duracion_horas BETWEEN 0 AND 500),
	CONSTRAINT ck_precio CHECK (precio>=0),
	CONSTRAINT plazas CHECK (plazas_max BETWEEN 0 AND 100),
	CONSTRAINT fk_id_categoria FOREIGN KEY (id_categoria) REFERENCES CATEGORIA (id_categoria) ON DELETE RESTRICT,
	CONSTRAINT fk_email FOREIGN KEY (email_instructor) REFERENCES INSTRUCTORES (email) ON DELETE CASCADE
);

CREATE TABLE ESTUDIANTES(
	id_estudiante INT AUTO_INCREMENT PRIMARY KEY,
	email VARCHAR(100) NOT NULL UNIQUE,
	nombre VARCHAR(40) NOT NULL,
	apellido VARCHAR(60) NOT NULL,
	pais VARCHAR(50),
	fecha_nacimiento DATE,
	premium CHAR(1) DEFAULT('S'),
	CONSTRAINT ck_premium CHECK (premium IN('S', 'N'))
);

CREATE TABLE MATRICULAS(
	id_matricula INT PRIMARY KEY,
	id_estudiante INT,
	cod_curso VARCHAR(10),
	fecha_matricula DATETIME DEFAULT NOW(),
	progreso INT,
	calificacion_final DECIMAL(4,2),
	completado CHAR(1) DEFAULT('N'),
	CONSTRAINT fk_idEstudiante FOREIGN KEY (id_estudiante) REFERENCES ESTUDIANTES (id_estudiante) ON DELETE CASCADE,
	CONSTRAINT fk_codCurso FOREIGN KEY (cod_curso) REFERENCES CURSOS (cod_curso) ON DELETE RESTRICT,
	CONSTRAINT ck_progreso CHECK (progreso BETWEEN 0 AND 100),
	CONSTRAINT ck_califiacacionFinal CHECK (calificacion_final BETWEEN 0 AND 10),
	CONSTRAINT ck_completado CHECK (completado IN('S', 'N')),
	CONSTRAINT un_idCod UNIQUE (id_estudiante, cod_curso)
);

ALTER TABLE CURSOS ADD idioma VARCHAR(20);
ALTER TABLE CURSOS ADD CONSTRAINT ck_idioma CHECK (idioma IN('ESPAÑOL', 'INGLES', 'FRANCES', 'ALEMAN'));

ALTER TABLE INSTRUCTORES MODIFY COLUMN biografia TEXT NOT NULL;

ALTER TABLE MATRICULAS ADD descuento_aplicado DECIMAL(5,2);
ALTER TABLE MATRICULAS ADD CONSTRAINT ck_descuentoAplicado CHECK (descuento_aplicado BETWEEN 0 AND 100);

ALTER TABLE INSTRUCTORES DROP CONSTRAINT ck_puntuacionMedia;
ALTER TABLE INSTRUCTORES ADD CONSTRAINT ck_puntuacionMedia CHECK (puntuacion_media BETWEEN 0 AND 10);

ALTER TABLE CURSOS ADD fecha_inicio DATE;
ALTER TABLE CURSOS ADD fecha_fin DATE;
ALTER TABLE CURSOS ADD CONSTRAINT ck_fecha CHECK (fecha_inicio < fecha_fin);

ALTER TABLE INSTRUCTORES DROP linkedin;

ALTER TABLE MATRICULAS ADD CONSTRAINT ck_progresoDoble CHECK (completado='S' AND progreso=100);
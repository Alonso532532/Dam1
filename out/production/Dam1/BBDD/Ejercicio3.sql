-- Ejercicio 3
-- Pedidos
-- Nombre: Alonso
-- Fecha: 28/11/2025

DROP DATABASE IF EXISTS logistica;

-- Creo la base de datos
CREATE DATABASE logistica;

USE logistica;

CREATE TABLE proveedores(
	id_prov NUMERIC PRIMARY KEY,
	nombre VARCHAR(30),
	teléfono VARCHAR(9),
	mail VARCHAR(20)
);

CREATE TABLE categoria(
	id_categoria VARCHAR(2) PRIMARY KEY,
	descripcion VARCHAR(50)
);

CREATE TABLE productos(
	numero_producto INTEGER PRIMARY KEY,
	nombre VARCHAR(30),
	precio_venta FLOAT,
	stock INTEGER,
	id_categoria VARCHAR(2),
	CONSTRAINT fk_idCategoria_productos FOREIGN KEY (id_categoria) REFERENCES categoria (id_categoria)
);

CREATE TABLE productos_proveedores(
	id_prov NUMERIC,
	numero_producto INTEGER,
	CONSTRAINT fk_idProv_pp FOREIGN KEY (id_prov) REFERENCES proveedores (id_prov),
	CONSTRAINT fk_numeroProducto_pp FOREIGN KEY (numero_producto) REFERENCES productos (numero_producto),
	CONSTRAINT pk_idNum_pp PRIMARY KEY (id_prov, numero_producto)
);

CREATE TABLE clientes(
	id_cliente VARCHAR(3) PRIMARY KEY,
	nombre VARCHAR(25),
	apellidos VARCHAR(25),
	dirección VARCHAR(30),
	teléfono VARCHAR(9) UNIQUE
);

CREATE TABLE empleados(
	id_empleado VARCHAR(3) PRIMARY KEY,
	nombre VARCHAR(30),
	apellidos VARCHAR(30),
	dirección VARCHAR(30),
	cod_area VARCHAR(2)
);

CREATE TABLE pedidos(
	numero_pedido INTEGER PRIMARY KEY,
	fecha_pedido DATE,
	id_cliente VARCHAR(3) NOT NULL,
	id_empleado VARCHAR(3) NOT NULL,
	CONSTRAINT fk_idEmpleado_pedidos FOREIGN KEY (id_empleado) REFERENCES empleados (id_empleado),
	CONSTRAINT fk_idCliente_pedidos FOREIGN KEY (id_cliente) REFERENCES clientes (id_cliente)
);

CREATE TABLE detalles_pedidos(
	numero_pedido INTEGER,
	numero_producto INTEGER PRIMARY KEY,
	cantidad INTEGER,
	precio DECIMAL(10,2),
	CONSTRAINT fk_numeroPedido_dp FOREIGN KEY (numero_pedido) REFERENCES pedidos (numero_pedido),
	CONSTRAINT fk_numeroProducto_dp FOREIGN KEY (numero_producto) REFERENCES productos (numero_producto),
	CONSTRAINT ck_cantidad_dp CHECK (cantidad>=1 AND cantidad<=100)
);


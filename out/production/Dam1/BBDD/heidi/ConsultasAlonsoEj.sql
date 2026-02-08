-- 1
SELECT CONCAT(nombre, apellidos) AS NombreCompleto, ciudad FROM clientes;
-- 2
SELECT numero_producto, nombre, precio_venta FROM productos WHERE stock BETWEEN 10 AND 50;
-- 3
SELECT nombre FROM productos WHERE nombre LIKE '%mountain%' OR '%trail%' ORDER BY nombre DESC;
-- 4
SELECT * FROM clientes WHERE nombre LIKE '%a' AND provincia NOT IN ('Madrid', 'Toledo');
-- 5
SELECT nombre, apellidos, CONCAT(codigo_area, telefono) AS 'TelefonoCompleto' FROM empleados WHERE cod_postal LIKE '28%';
-- 6
SELECT precio_venta AS 'PrecioOriginal', precio_venta*0.75 AS 'Precio_Con_Descuento' FROM productos;
-- 7
SELECT * FROM productos WHERE precio_venta > (SELECT AVG(precio_venta) FROM productos);
-- 9
SELECT * FROM proveedores WHERE id_prov NOT IN 
	(SELECT id_prov FROM productos_proveedores WHERE numero_producto IN 
		(SELECT numero_producto FROM productos WHERE numero_producto IN 
			(SELECT numero_producto FROM detalles_pedidos WHERE numero_producto IN 
				(SELECT numero_pedido FROM pedidos WHERE YEAR(fecha_pedido)=2007))));
-- 10
SELECT * FROM categorias WHERE id_categoria IN (SELECT id_categoria FROM productos WHERE precio_venta>30.00);
-- De la 11 a la 15
-- 11
SELECT * FROM productos WHERE precio_venta > (SELECT precio_venta FROM productos WHERE numero_producto=15);
-- 12
SELECT * FROM clientes WHERE provincia = (SELECT provincia FROM proveedores WHERE nombre = 'Shinoman, Incorporated');
-- 13
SELECT * FROM clientes WHERE provincia NOT IN (SELECT provincia FROM proveedores);
-- 14
SELECT * FROM proveedores WHERE id_prov IN (SELECT id_prov FROM productos_proveedores WHERE numero_producto NOT IN (SELECT numero_producto FROM detalles_pedidos));
-- 15
SELECT * FROM proveedores WHERE id_prov IN (SELECT id_prov FROM productos_proveedores WHERE numero_producto IN (SELECT numero_producto FROM detalles_pedidos));
-- 16
SELECT * FROM productos WHERE precio_venta > ANY (SELECT precio_venta FROM productos);
-- 17
SELECT * FROM pedidos WHERE precio_total < ANY 
(SELECT precio_total FROM pedidos WHERE id_cliente = 1001);
-- 18
SELECT * FROM productos p1 WHERE precio_venta <= ALL (SELECT precio_venta FROM productos p2 WHERE p2.id_categoria=p1.id_categoria);
-- 19
-- NECESITA EXPLICACION
-- Consultas con varias tablas
-- 20
SELECT nombre, apellidos, numero_pedido, fecha_pedido 
FROM clientes cl INNER JOIN pedidos pe 
ON cl.id_cliente=pe.id_cliente;
-- 21
SELECT pe.numero_pedido, pr.nombre, dp.cantidad, pr.precio_venta, pe.fecha_pedido
FROM pedidos pe NATURAL JOIN productos pr NATURAL JOIN detalles_pedidos dp WHERE pe.fecha_pedido LIKE "2008%";
-- 22
SELECT id_categoria, COUNT(numero_producto) AS total_productos, AVG(precio_venta) AS precio_promedio FROM productos GROUP BY id_categoria;
-- 23
SELECT pr1.nombre, pr2.precio_por_mayor, pr3.nombre 
	FROM proveedores pr1 
	NATURAL JOIN productos_proveedores pr2 
	NATURAL JOIN productos pr3 WHERE pr3.id_categoria IN
		(SELECT id_categoria FROM categorias WHERE descripcion = "Bicicletas");
		
-- 24
SELECT cl.nombre, emp.nombre, ped.fecha_pedido 
	FROM pedidos ped
	JOIN clientes cl ON cl.id_cliente = ped.id_cliente 
	JOIN empleados emp ON emp.id_empleado = ped.id_empleado
		WHERE cl.ciudad = "Robledo" AND emp.ciudad = "Robledo";
		
-- 25
SELECT * FROM productos WHERE numero_producto NOT IN (SELECT numero_producto FROM detalles_pedidos);

-- 27
SELECT pro.nombre, cat.descripcion, pro.precio_venta
FROM categorias cat
JOIN productos pro ON pro.id_categoria = cat.id_categoria
WHERE pro.precio_venta > ALL (SELECT precio_venta FROM productos pro2 WHERE pro2.id_categoria = pro.id_categoria);
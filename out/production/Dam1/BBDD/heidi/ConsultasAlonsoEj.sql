SELECT CONCAT(nombre, apellidos) AS NombreCompleto, ciudad FROM clientes;
SELECT numero_producto, nombre, precio_venta FROM productos WHERE stock BETWEEN 10 AND 50;
SELECT nombre FROM productos WHERE nombre LIKE '%mountain%' OR '%trail%' ORDER BY nombre DESC;
SELECT * FROM clientes WHERE nombre LIKE '%a' AND provincia NOT IN ('Madrid', 'Toledo');
SELECT nombre, apellidos, CONCAT(codigo_area, telefono) AS 'TelefonoCompleto' FROM empleados WHERE cod_postal LIKE '28%';
SELECT precio_venta AS 'PrecioOriginal', precio_venta*0.75 AS 'Precio_Con_Descuento' FROM productos;
SELECT * FROM productos WHERE precio_venta > (SELECT AVG(precio_venta) FROM productos);

SELECT * FROM proveedores WHERE id_prov NOT IN 
(SELECT id_prov FROM productos_proveedores WHERE numero_producto IN 
(SELECT numero_producto FROM productos WHERE numero_producto IN 
(SELECT numero_producto FROM detalles_pedidos WHERE numero_producto IN 
(SELECT numero_pedido FROM pedidos WHERE YEAR(fecha_pedido)=2007))));

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
-- 18 y 19
-- NECESITA EXPLICACION
-- COnsultas con varias tablas
-- 20
SELECT nombre, apellidos, numero_pedido, fecha_pedido 
FROM clientes cl INNER JOIN pedidos pe 
ON cl.id_cliente=pe.id_cliente;
-- 21
SELECT pe.numero_pedido, pr.nombre, dp.cantidad, pr.precio_venta
FROM pedidos pe NATURAL JOIN productos pr NATURAL JOIN detalles_pedidos dp;

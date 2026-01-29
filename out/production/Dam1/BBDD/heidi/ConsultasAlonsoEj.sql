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
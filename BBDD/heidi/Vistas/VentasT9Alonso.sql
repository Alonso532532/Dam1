-- 1
create view v_clientes_contacto as 
	select c.id_cliente, CONCAT(c.nombre, c.apellidos) as nombre_completo, c.ciudad, c.provincia  from clientes c;

select * from v_clientes_contacto;

-- 2
create view v_productos_pvp as
	select numero_producto, nombre, precio_venta, precio_venta*1.21 as precio_con_iva from productos;

select * from v_productos_pvp;

-- 3
create view v_clientes_madrid as
	select * from clientes where provincia = "MADRID" order by apellidos;

select * from v_clientes_madrid;

 -- 4
create view v_productos_rango_precio as
	select nombre, precio_venta from productos where precio_venta between 20 and 150 order by precio_venta desc;

select * from v_productos_rango_precio;

-- 5
create view v_proveedores_sin_web as
	select nombre, ciudad, telefono from proveedores where pag_web is null;

select * from v_proveedores_sin_web;


-- 6
create view v_bicicletas_y_ropa as
	select nombre, descripcion, precio_venta from productos where id_categoria in (2, 3) and nombre like "%a%"

select * from v_bicicletas_y_ropa;

-- 7
create view v_pedidos_grandes as
	select numero_pedido, fecha_pedido, precio_total from pedidos where precio_total > (select AVG(p2.precio_total) from pedidos p2);
	
select * from v_pedidos_grandes;

-- 8
create view v_clientes_activos as
	select c.id_cliente, CONCAT(c.nombre, c.apellidos) as nombre_completo, c.ciudad from clientes c where c.id_cliente in (select id_cliente from pedidos);
	
select * from v_clientes_activos;

drop view v_clientes_activos;

-- 9
create view v_pedidos_detallados as
	select p.numero_pedido, p.fecha_pedido, p.precio_total, CONCAT(c.nombre, c.apellidos) as nombre_completo_cliente, CONCAT(e.nombre, e.apellidos) as nombre_completo_empleado from pedidos p join clientes c on p.id_cliente = c.id_cliente join empleados e on p.id_empleado=e.id_empleado;

select * from v_pedidos_detallados;


-- 10
create view v_catalogo_productos as
	select p.nombre, p.descripcion as descripcion_producto, p.precio_venta, p.stock, c.descripcion as descripcion_cat from productos p join categorias c on p.id_categoria = c.id_categoria;

select * from v_catalogo_productos;

-- 11
create view v_clientes_sin_pedidos as
	select CONCAT(c.nombre, c.apellidos) as nombre_completo, c.ciudad, c.provincia from clientes c left join pedidos p on p.id_cliente = c.id_cliente where p.id_cliente is null;

select * from v_clientes_sin_pedidos;

drop view v_clientes_sin_pedidos;

-- 12
create view v_mejor_precio_proveedor as
	select p.nombre as nombre_producto, pp.precio_por_mayor, p1.nombre as nombre_proveedor from productos p join productos_proveedores pp on p.numero_producto=pp.numero_producto join proveedores p1 on pp.id_prov=p1.id_prov where pp.precio_por_mayor=(select MIN(pp1.precio_por_mayor) from productos_proveedores pp1 where pp1.numero_producto = p.numero_producto limit 1);

select * from v_mejor_precio_proveedor;

drop view v_mejor_precio_proveedor;

-- 1
select CONCAT(e.nombre, " ", e.apellidos) as Nombre, e.ciudad from empleados e;

-- SUB
-- 7
select p.numero_producto from productos p where p.precio_venta > (select AVG(p2.precio_venta) from productos p2)

-- 8
with gestionadosEmpleado as (
	select e.nombre, e.id_empleado, count(p.id_empleado) as realizados from empleados e join pedidos p  on e.id_empleado = p.id_empleado group by e.id_empleado
)
select g.nombre, g.realizados, (select AVG(g2.realizados) from gestionadosEmpleado g2) as "Promedio" from gestionadosEmpleado g where g.realizados > (select AVG(g2.realizados) from gestionadosEmpleado g2);

-- 9
select p.* from proveedores p where p.id_prov not in 
	(select pp.id_prov from productos_proveedores pp where pp.numero_producto in 
		(select dp.numero_producto from detalles_pedidos dp where dp.numero_pedido in 
			(select pe.numero_pedido from pedidos pe where pe.fecha_pedido like "2007-%")));

-- 10
select c.* from categorias c where 30 < all (select p.precio_venta from productos p where p.id_categoria = c.id_categoria);

-- 11
select p.nombre from productos p where p.precio_venta > (select p2.precio_venta from productos p2 where p2.numero_producto = 15)

-- 13
select c.nombre from clientes c where not exists (select * from proveedores p where p.provincia = c.provincia);

-- 14
select p.nombre from proveedores p where exists (select * from productos_proveedores pp where pp.id_prov = p.id_prov and not exists (select * from detalles_pedidos dp where dp.numero_producto = pp.numero_producto));

-- 15
select p.* from proveedores p where exists (select * from productos_proveedores pp where pp.id_prov = p.id_prov and exists (select * from detalles_pedidos dp where dp.numero_producto = pp.numero_producto));

-- 16
select p.nombre from productos p where p.precio_venta > all (select p2.precio_venta from productos p2 where p2.id_categoria = (select c.id_categoria from categorias c where c.descripcion = "Ropa"));

-- 19
select p.* from pedidos p where p.fecha_pedido < (select min(p2.fecha_pedido) from pedidos p2 where p2.id_cliente = "1005");

select p.fecha_pedido from pedidos p where p.id_cliente = "1005" order by p.fecha_pedido limit 1;

-- multi
-- 20
select c.nombre, c.apellidos, p.fecha_pedido, p.numero_pedido from clientes c left join pedidos p on c.id_cliente = p.id_cliente;

-- 21
select p.numero_pedido, p2.nombre, dp.cantidad, p2.precio_venta
	from pedidos p 
	join detalles_pedidos dp on p.numero_pedido = dp.numero_pedido 
	join productos p2 on dp.numero_producto = p2.numero_producto
	where p.fecha_pedido like "2008-%";

	

-- Pruebas
select distinct c.nombre, max(p.precio_total) over (partition by c.id_cliente) from clientes c join pedidos p on c.id_cliente = p.id_cliente;
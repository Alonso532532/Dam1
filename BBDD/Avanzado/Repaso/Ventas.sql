update productos p set precio_venta = p.precio_venta * 1.10;

update productos p set precio_venta = p.precio_venta * 1.04 
where p.id_categoria = 
	(select c.id_categoria from categorias c 
	where c.descripcion = "Ropa");

create table saldos_pendientes(
	select
		numero_pedido,
		fecha_pedido,
		fecha_envio,
		id_cliente,
		id_empleado,
		precio_total * 0.10
	from pedidos
);

drop table saldos_pendientes;
select * from saldos_pendientes;


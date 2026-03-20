-- 1
select c.nombre, c.apellidos from clientes c where 
	c.padrino in (select c2.id_cliente  from clientes c2 where c2.edad = (select MIN(c3.edad) from clientes c3))
	and c.tarifa in (select t.id_tarifa from tarifas t where t.nombre = "Barata");

-- 2
select p.nombre, p.descuento from promociones p where 
	p.fecha_inicio<NOW() 
	and p.fecha_fin>NOW() 
	and p.id_promocion = (select p2.id_promocion from promociones p2 where p2.descuento = 
	(select MAX(p3.descuento) from promociones p3 where p3.id_promocion in 
	(select p4.id_promocion from promociones p4 where p4.fecha_inicio<NOW() and p4.fecha_fin>NOW())));

-- 3
select c.nombre, c.apellidos, t.nombre, t.establecimiento, (select COUNT(*) from llamadas l where l.id_cliente = c.id_cliente) 
	from clientes c join tarifas t on c.tarifa = t.id_tarifa
	where t.establecimiento = (select MAX(t2.establecimiento) from tarifas t2);

-- 4
select t.nombre from tarifas t 
	where 0=(select count(*) from llamadas l where l.tipo != "N" 
	and l.id_cliente in (select c.id_cliente from clientes c 
		where c.tarifa = t.id_tarifa));


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
	where not exists (select * from llamadas l where l.tipo != "N" 
	and l.id_cliente in (select c.id_cliente from clientes c 
		where c.tarifa = t.id_tarifa));

-- 5
select l.*, p.nombre from llamadas l 
	join clientes c on l.id_cliente = c.id_cliente 
	join tarifas t on c.tarifa = t.id_tarifa 
	join promociones p on p.id_promocion = t.id_tarifa
	where l.fecha >= p.fecha_inicio and l.fecha <= p.fecha_fin;

-- 6
select c.nombre, c.apellidos from clientes c
	where not exists (select l.* from llamadas l where tipo = "N" and c.id_cliente = l.id_cliente)
	and c.tarifa in (select t.id_tarifa from tarifas t where t.nombre in ("Normal", "Buena"));

-- 7
select c.nombre, (select count(*) from llamadas l where l.id_cliente = c.id_cliente) as "Llamadas realizadas",
	(select count(*) from llamadas l where l.id_cliente = c.id_cliente)-(select avg((select count(*) from llamadas l where l.id_cliente = c3.id_cliente)) from clientes c3 where c3.tarifa = c.tarifa) as "Supera el promedio por"
	from clientes c 
	where 
	c.id_cliente in (select c2.id_cliente from clientes c2 where (select count(*) from llamadas l where l.id_cliente = c2.id_cliente)
	>
	(select avg((select count(*) from llamadas l where l.id_cliente = c3.id_cliente)) from clientes c3 where c3.tarifa = c.tarifa))

-- 8
select c.nombre, c.apellidos, 
	(select sum(l.duracion) from llamadas l where c.id_cliente = l.id_cliente and l.tipo = "I") as "Total" 
	from clientes c where 
	5<(select sum(l.duracion) from llamadas l where c.id_cliente = l.id_cliente and l.tipo = "I");

-- 9
select c.nombre, c.apellidos, c.edad, t.nombre, rank() over (partition by t.nombre order by c.edad)
	from clientes c 
	join tarifas t on c.tarifa = t.id_tarifa 
	where c.edad = (select MAX(c2.edad) from clientes c2 where c2.tarifa = c.tarifa) 
	or c.edad =	(select MIN(c2.edad) from clientes c2 where c2.tarifa = c.tarifa);

-- 10
with nLlamadas as (
	select (select count(*) from llamadas l where c.id_cliente = l.id_cliente) as cant_llamadas, c.id_cliente from clientes c group by c.id_cliente
), llamadas2025 as (
	select (select count(*) from llamadas l where c.id_cliente = l.id_cliente and l.fecha like "2025%") as cant_llamadas, c.id_cliente from clientes c group by c.id_cliente
)
select c.nombre, c.apellidos, n.cant_llamadas as "Llamadas totales", ll.cant_llamadas as "Lamadas en 2025"
	from clientes c
	join nLlamadas n on c.id_cliente = n.id_cliente 
	join llamadas2025 ll on ll.id_cliente = c.id_cliente 
	where ll.cant_llamadas = 0 or n.cant_llamadas = 0;

-- 11
select c.nombre, c.apellidos, l.fecha, l.duracion, TRUNCATE(AVG(l.duracion ) over (partition by l.tipo), 2) as "Duración media"
	from llamadas l
	join clientes c on l.id_cliente = c.id_cliente;

-- 12
with minsHablados as (
	select c.nombre, (select SUM(l.duracion) from llamadas l where l.id_cliente = c.id_cliente) as total from clientes c
)
select m.*, rank() over (order by m.total) from minsHablados m where m.total > 5;

-- Pruebas
select c.nombre, count(l.id_llamada) over (partition by l.id_cliente) from llamadas l join clientes c on c.id_cliente = l.id_cliente; 

select c.nombre, count(l.id_llamada) from llamadas l join clientes c on c.id_cliente = l.id_cliente group by c.id_cliente; 

with cant as (
	select c.id_cliente, c.nombre, (select count(*) from llamadas l where l.id_cliente = c.id_cliente) as cant from clientes c
)
select *, rank() over (order by c.cant desc) from cant c;

with cant as (
	select l.id_cliente, count(*) as cant from llamadas l group by l.id_cliente 
)
select c.nombre, ifnull(c2.cant, 0) from clientes c left join cant c2 on c.id_cliente = c2.id_cliente;
-- 1
select c.nombre, c.apellidos from clientes c where
	c.padrino in (select c2.id_cliente from clientes c2 where
		c2.edad = (select MAX(c3.edad) from clientes c3)) 
and 
	c.tarifa in (select t.id_tarifa from tarifas t where nombre = "Barata");

-- 2
with promocionesActivas as (
	select id_tarifa, nombre, descuento from promociones where 
		fecha_inicio < CURDATE() and fecha_fin > CURDATE()
)
select pa.nombre, pa.descuento from promocionesActivas pa where 
	pa.descuento in (select MAX(pa2.descuento) from promocionesActivas pa2);

-- 3
select c.nombre, c.apellidos, t.nombre, t.establecimiento, COUNT(l.id_llamada) from clientes c 
	join tarifas t on c.tarifa = t.id_tarifa
	join llamadas l on c.id_cliente = l.id_cliente
where
	t.establecimiento in (select max(t2.establecimiento) from tarifas t2)
group by c.id_cliente

-- 4
select t.nombre from tarifas t where 
	not exists (select c.* from clientes c where 
		exists (select l.* from llamadas l where 
			c.id_cliente = l.id_cliente and l.tipo != "N"));

-- 5
select l.*, p.nombre from llamadas l 
	join promociones p on p.fecha_inicio < l.fecha and p.fecha_fin > l.fecha;

-- 6
select c.nombre, c.apellidos from clientes c 
	join tarifas t on c.tarifa = t.id_tarifa 
where
	t.nombre in ('Normal', 'Buena')
and
	not exists (select l.* from llamadas l where 
		l.id_cliente = c.id_cliente and l.tipo = 'N');

-- 7
with clientesLlamadas as (
	select c.*, count(l.id_llamada) as numLlamadas from clientes c 
		left join llamadas l on c.id_cliente = l.id_cliente 
	group by c.id_cliente
)
select cl.*, 
	(select AVG(cl2.numllamadas) from clientesLlamadas cl2 where cl.tarifa = cl2.tarifa) as promedioPorTarifa,
	cl.numllamadas - (select AVG(cl2.numllamadas) from clientesLlamadas cl2 where cl.tarifa = cl2.tarifa) as excedente
from clientesLlamadas cl where cl.numllamadas > (select AVG(cl2.numllamadas) from clientesLlamadas cl2 where cl.tarifa = cl2.tarifa)

-- 8
with clientesMinutosI as (
	select c.nombre, c.apellidos, SUM(l.duracion) as tiempo from clientes c 
	join llamadas l on l.id_cliente = c.id_cliente
	where l.tipo = 'I' 
	group by c.id_cliente
)
select clm.* from clientesMinutosI clm where clm.tiempo > 5;

-- 9
select c.nombre, c.apellidos, c.edad, t.nombre from clientes c
join tarifas t on t.id_tarifa = c.tarifa
where c.edad in (select max(c2.edad) from clientes c2 where c2.tarifa = t.id_tarifa group by t.id_tarifa) 
or c.edad in (select min(c2.edad) from clientes c2 where c2.tarifa = t.id_tarifa group by t.id_tarifa)
group by c.nombre, c.apellidos, c.edad, c.tarifa;
	

-- 10
select c.id_cliente, c.nombre, c.apellidos from clientes c 
where not exists 
	(select l.* from llamadas l 
	where l.id_cliente = c.id_cliente 
	and l.fecha like '%2025%')
	
-- 11
select 
	c.nombre, c.apellidos, l.duracion, l.fecha,
	avg(l.duracion) over (partition by l.tipo)
from clientes c
join llamadas l on l.id_cliente = c.id_cliente 

-- 12
with clienteMinutos as (
	select 
		c.nombre, c.apellidos, 
		(select sum(l.duracion) from llamadas l 
		where l.id_cliente = c.id_cliente) as tiempoHablado 
	from clientes c
)
select * from clienteMinutos where tiempohablado > 5

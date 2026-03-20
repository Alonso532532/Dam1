-- 1
select s.nombre, s.genero from servicio s
	where id in (select es.id_servicio from empleado_servicio es 
		where es.id_empleado in (select e.id from empleado e 
			where e.nombre like "Rigoberta"));

-- 2
select e.* from empleado e 
	where e.id not in (select es.id_empleado  from empleado_servicio es);

-- 3
select e.* from empleado e 
	where e.salario > (select e2.salario from empleado e2 
		where e2.id = e.id_jefe);

-- 4
select e.nombre from empleado e 
	where e.id in (select de.id_empleado from detalle_evento de 
		where de.id_evento in (select id from evento e2  
				where e2.nombre = "Hamlet")) 
		and e.id in (select es.id_empleado from empleado_servicio es 
			where es.id_servicio in (select s.id from servicio s 
				where s.nombre = "maquillar"));

-- 5
select e.nombre from empleado e 
	where e.id in (select es.id_empleado from empleado_servicio es 
		where es.id_servicio in (select s.id from servicio s 
			where s.nombre = "cortar" and s.genero = "mujer"))
	and e.id in (select es.id_empleado from empleado_servicio es 
		where es.id_servicio in (select s.id from servicio s 
			where s.nombre = "cortar" and s.genero = "hombre"));

-- 6
select SUM(c.precio), (select e.nombre from empleado e where e.id = c.id_empleado) 
	from cita c group by id_empleado;

-- 7
select e.nombre, (select count(*) from cita c 
	where c.id_empleado = e.id and c.fecha_cita like "%-02-%") from empleado e 
		where (select count(*) from cita c 
			where c.id_empleado = e.id and c.fecha_cita like "%-02-%")>2; 

-- 8
select e.nombre, 
	(select count(*) from empleado_servicio es 
		where es.id_empleado = e.id)
	from empleado e where e.salon = "Romareda";

-- 9
select e.nombre from empleado e where 
	(select SUM(c.precio) from cita c where c.id_empleado = e.id) > 
	(select AVG(c.precio) from cita c);

-- 10
select e.salon from empleado e where 
	(select SUM(c.precio) from cita c where c.id_empleado in 
		(select e2.id from empleado e2 where e2.salon = e.salon))>100 
	group by e.salon;

-- 11
select c.* from cliente c where c.id NOT in 
	(select ci.id_cliente from cita ci where ci.id_servicio in 
		(select s.id from servicio s where s.nombre = "Corte de Cabello"));

-- 12
select c.nombre, 
	(select SUM(ci.precio) from cita ci where c.id = ci.id_cliente and ci.fecha_cita like "%-02-%") 
	from cliente c 
	where (select SUM(ci.precio) from cita ci where c.id = ci.id_cliente and ci.fecha_cita like "%-02-%") 
	is not null;

-- 13 
select s.nombre, e.nombre, c2.nombre, c2.localidad 
	from cita c1 
	join cliente c2 on c1.id_cliente = c2.id 
	join servicio s on s.id = c1.id_servicio 
	join empleado e on c1.id_empleado = e.id 
	where c2.localidad in ("Barcelona", "Madrid");

-- 14
select e.nombre, c.precio, 
	(select SUM(c2.precio) from cita c2 where c2.id_empleado = e.id) as "running total"
	from cita c 
	join empleado e on c.id_empleado = e.id 
	order by fecha_cita;

-- 15
select e.nombre, e.salario, 
	(select AVG(e2.salario) from empleado e2 where e2.salon = e.salon),
	e.salario-(select AVG(e2.salario) from empleado e2 where e2.salon = e.salon) as diferencia
	from empleado e;

-- 18

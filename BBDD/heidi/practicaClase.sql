with totalEmp as
	(select id_empleado, SUM(precio) as "total" from cita group by id_empleado)
	select e.nombre from empleado e where 
	(select t.total from totalEmp t where t.id_empleado = e.id) > 
	(select AVG(t.total) from totalEmp t);

with totalEmp as
	(select id_empleado, SUM(precio) as "total" from cita group by id_empleado)
	select t.total from totalEmp t union select AVG(t.total) from totalEmp t;
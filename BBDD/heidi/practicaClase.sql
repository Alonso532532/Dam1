with totalEmp as
	(select id_empleado, SUM(precio) as "promedio" from cita group by id_empleado)
	select e.nombre from empleado e where 
	(select t.promedio from totalEmp t where t.id_empleado = e.id) > 
	(select AVG(t.promedio) from totalEmp t);
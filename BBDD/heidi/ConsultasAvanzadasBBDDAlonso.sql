-- CONSULTAS CON FUNCIONES
-- Ej1
select UPPER(NomDep), PreAnu from departamento;

-- Ej2
select LOWER(NomEmp), SalEmp from empleado;

-- Ej3
select NomEmp, SUBSTRING(CodDep, 1, 2) from empleado;

-- Ej4
select CodEmp, CodDep, CONCAT(CodEmp, CodDep, IFNULL(ExTelEmp, "XXXX")) from empleado;

-- Ej5
select NomEmp, SUBSTRING(NomEmp, LOCATE(",", NomEmp)+2) as "Nombre", SUBSTRING(NomEmp, 1, LOCATE(",", NomEmp)-1) as "Apellidos"  from empleado;

-- Ej6
select NomEmp, ROUND(SalEmp*0.12, 2) from empleado;

-- Ej7
select NomEmp, TRUNCATE(SalEmp*0.12, 1) from empleado;

-- Ej8
select NomEmp, 
	case 
		when NumHi = 0 then "Sin familia"
		when NumHi = 1 then "Ordinaria"
		when NumHi = 2 then "Semi-numerosa"
		when NumHi > 2 then "Numerosa"
	end as "Tipo familia"
from empleado;

-- Ej9
select NomEmp, EXTRACT(day from FecNaEmp) as "Dia", EXTRACT(month from FecNaEmp) as "Mes", EXTRACT(year from FecNaEmp) as "Año" from empleado;

-- Ej10
select NomEmp, FecNaEmp, TIMESTAMPDIFF(year, FecNaEmp, CURDATE()) from empleado;

-- Ej11
select NomEmp, FecNaEmp, FecInEmp, TRUNCATE(TIMESTAMPDIFF(year, FecInEmp, CURDATE())/4,0) as "Dias de vacaciones extra" from empleado;

-- Ej12
select NomDep, CONCAT(CodDep, TRUNCATE(RAND()*100,0) , CodCen) from departamento;

-- CONSULTAS DE AGRUPACIÓN O USANDO FUNCIONES DE AGRUPACIÓN
-- Ej1
select COUNT(*) from empleado where NumHi = 2;

-- Ej2
select COUNT(*) from empleado where ExTelEmp is null;

-- Ej3
select AVG(TIMESTAMPDIFF(year, FecNaEmp, CURDATE())) from empleado;

-- Ej4
select AVG(TIMESTAMPDIFF(year, FecNaEmp, CURDATE())) from empleado 
	where CodEmp not in (select CodEmpDir from departamento) 
	and CodEmp not in (select CodEmpDir  from centro);

-- Ej5
select AVG(TIMESTAMPDIFF(year, FecNaEmp, CURDATE())) from empleado 
	where CodDep in (select CodDep from departamento 
		where CodCen in (select CodCen from centro where PobCen = 'Murcia'));

-- Ej6
select SUM(PreAnu) from departamento 
	where CodCen in (select CodCen from centro where PobCen = 'Cartagena');

-- Ej7
select COUNT(*) from empleado where CodEmp in (select CodEmp from habemp);

-- Ej8
select COUNT(*) from empleado where CodEmp not in (select CodEmp from habemp);

-- Ej9
select d.CodDep, d.NomDep, MIN(e.SalEmp), MAX(e.SalEmp), AVG(e.SalEmp) 
	from empleado e natural join departamento d group by e.CodDep;

-- Ej10
select CodEmp, NomEmp, (select COUNT(*) from habemp h where h.CodEmp=e.CodEmp) from empleado e;

-- Ej11
select d.CodDep, d.NomDep, (select COUNT(*) from habemp h where h.CodEmp=e.CodEmp) 
	from departamento d natural join empleado e 
	where (select COUNT(*) from habemp h where h.CodEmp=e.CodEmp)>0;

-- Ej12
select c.CodCen, c.NomCen, count(*) 
	from centro	c
	left join departamento d on c.CodCen=d.CodCen 
	natural left join empleado e
	natural right join habemp h
	group by c.CodCen;

-- Ej13
select c.CodCen, c.NomCen, d.CodDep, d.NomDep, count(*) 
	from centro	c
	left join departamento d on c.CodCen=d.CodCen 
	natural left join empleado e
	natural right join habemp h
	group by d.CodDep;

-- Ej14
select c.NomCen, avg(d.PreAnu) as 'Salario medio'
	from departamento d 
	join centro c on c.CodCen=d.CodCen
	where d.PreAnu > 25000000
	group by d.CodCen
	order by avg(d.PreAnu) desc;
	

-- Ej15
select c.PobCen, SUM(e.SalEmp)
	from centro c 
	join departamento d on c.CodCen=d.CodCen
	natural join empleado e
	group by c.PobCen;

-- Ej16
select d.NomDep, 
	(select count(*) from empleado e where e.CodDep=d.CodDep) 
	from departamento d 
		where (select count(*) from empleado e where e.CodDep=d.CodDep)>3;

-- Ej17
select c.NomCen, (select count(*) 
		from departamento d 
		natural join empleado e 
		where c.CodCen=d.CodCen)  
	from centro c 
	where (select count(*) 
		from departamento d 
		natural join empleado e 
		where c.CodCen=d.CodCen)>3;


-- Ej18
select d.NomDep, d.CodDep from departamento d 
	where (select AVG(NumHi) from empleado e where e.CodDep = d.CodDep)>2;

-- Ej19
select CodHab from habilidad h where (select count(*) from habemp h2 where h.CodHab = h2.CodHab)>3;

-- Ej20
select c.* from centro c 
	join departamento d on d.CodCen=c.CodCen 
	where (select avg(TIMESTAMPDIFF(year, e.FecInEmp, CURDATE())) 
		from empleado e where e.CodDep = d.CodDep)>10 group by c.CodCen ;


-- Ej21
-- AVG(TIMESTAMPDIFF(year, e.FecNaEmp, CURDATE()))
select c.* from centro c 
	join departamento d on d.CodCen = c.CodCen 
	where (select count(*) from empleado e 
		where TIMESTAMPDIFF(year, e.FecInEmp, CURDATE())>=20 and e.CodDep = d.CodDep 
		group by e.CodDep)>3 group by c.CodCen;

-- Ej22
select d.* from departamento d 
	where (select MAX(e.SalEmp) from empleado e 
		where e.CodDep = d.CodDep)!=(select MIN(e.SalEmp) 
		from empleado e where e.CodDep = d.CodDep);

-- Funciones Ventana

-- EJ1
select e.NomEmp, 
	TRUNCATE(TIMESTAMPDIFF(year, e.FecNaEmp, CURDATE()),0) as "Edad", 
	AVG(TRUNCATE(TIMESTAMPDIFF(year, e.FecNaEmp, CURDATE()),0)) over (partition by e.CodDep) as "Edad media departamento" from empleado e;

-- EJ2
select e.CodDep , e.NomEmp, e.SalEmp, 
	AVG(e.SalEmp) over(partition by e.CodDep) as "Salario Medio",
	case 
		when e.SalEmp > AVG(e.SalEmp) over(partition by e.CodDep) then "Por encima"
		when e.SalEmp < AVG(e.SalEmp) over(partition by e.CodDep) then "Por debajo"
		else "Normal"
	end
	from empleado e ;

-- EJ3
select e.NomEmp, e.CodDep, e.SalEmp, 
	MAX(e.SalEmp) over(partition by e.coddep) as "Salario maximo",
	MAX(e.SalEmp) over(partition by e.coddep)-e.SalEmp as "Dirferencia de salario"
	from empleado e;

-- EJ4
select e.NomEmp, TIMESTAMPDIFF(year, e.FecInEmp, CURDATE()),
	rank() over (partition by d.CodCen order by TIMESTAMPDIFF(year, e.FecInEmp, CURDATE()))
	from empleado e natural join departamento d;


-- EJ5

-- CTE

-- EJ1
with empleados as (
	select NomEmp, SalEmp from empleado
)
select nomemp, AVG(salemp) from empleados;

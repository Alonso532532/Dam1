select UPPER(d.NomDep), d.PreAnu from departamento d;

select CONCAT(SUBSTRING(e.NomEmp, 1, LOCATE(" ", e.NomEmp)), ", ", UPPER(SUBSTRING(e.CodDep, 1, 2))) as "Empleado con iniciales de su departamento" from empleado e;

select e.CodEmp, e.CodDep, CONCAT(e.CodEmp, e.CodDep, IFNULL(e.ExTelEmp, "XXXX")) from empleado e;

select e.NomEmp, e.SalEmp, TRUNCATE(e.SalEmp * 1.12 +0.123123, 2) from empleado e;

select e.nomemp, 
case 
	when e.numhi = 0 then "No tiene hijos"
	when e.numhi = 1 then "Tiene un hijo"
	else "Tiene más de un hijo"
end
from empleado e;

select e.NomEmp, e.FecNaEmp, TIMESTAMPDIFF(year, e.FecNaEmp, CURDATE()) as Edad, e.FecInEmp, TIMESTAMPDIFF(day, e.FecInEmp, CURDATE()) "Dias contratado" from empleado e;

select d.NomDep , CONCAT(d.CodDep, "-", truncate(RAND()*10,0), truncate(RAND()*10,0), d.CodCen) from departamento d;

-- Agrupación
-- 4
select AVG(TIMESTAMPDIFF(year, e.FecNaEmp, curdate())) 
	from empleado e 
	where not exists 
		(select * from departamento d where d.codempdir = e.CodEmp) 
	and not exists 
		(select * from centro c where c.codempdir = e.CodEmp);

-- 13
select c.CodCen, d.NomDep, (select count(*) from empleado e left join habemp h on e.CodEmp = h.CodEmp where e.CodDep = d.CodDep), dense_rank() over (order by (select count(*) from empleado e left join habemp h on e.CodEmp = h.CodEmp where e.CodDep = d.CodDep))
	from centro c 
	join departamento d on d.CodCen = c.CodCen;
	
	

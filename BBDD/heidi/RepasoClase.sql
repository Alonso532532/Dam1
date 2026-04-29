select e.CodDep, e.NumHi, AVG(e.SalEmp) from empleado e group by e.CodDep, e.NumHi;

select c.PobCen, AVG(e.SalEmp) from empleado e
	join departamento d on e.CodDep = d.CodDep
	join centro c on c.CodCen = d.CodCen
	group by c.PobCen;

select d.* from departamento d where (select COUNT(e.CodDep) from empleado e where e.CodDep = d.CodDep)>3;


select c.* from centro c 
	where (select AVG(DATEDIFF(NOW(), e.FecInEmp)) from empleado e join departamento d on e.CodDep = d.CodDep where d.CodCen = c.CodCen)>10
	group by c.CodCen;

select c.* from centro c
	join departamento d on c.CodCen = c.CodCen
	join empleado e on e.CodDep = d.CodDep
	group by c.CodCen
	having AVG(DATEDIFF(NOW(), e.FecInEmp))>10
	
select e.NomEmp from empleado e union select d.NomDep from departamento d;

select e.NomEmp, DATEDIFF(CURDATE(), e.FecNaEmp)/365, AVG(DATEDIFF(CURDATE(), e.FecNaEmp)/365) over (partition by d.codcen) from empleado e join departamento d on d.CodDep = e.CodDep;

select e.NomEmp, e.CodDep, e.SalEmp, AVG(SalEmp) over (partition by CodDep), 
	case
		when salemp>AVG(SalEmp) over (partition by coddep) then 'Por encima'
		when salemp<AVG(SalEmp) over (partition by coddep) then 'Por debajo'
		else 'Igual que el promedio'
	end as "Comparación salario"
from empleado e;

select e.NomEmp, d.NomDep, e.SalEmp, 
	MAX(SalEmp) over (partition by e.CodDep),  
	MAX(SalEmp) over (partition by e.CodDep)-e.SalEmp as "Diferencia de salario" 
from empleado e join departamento d on e.CodDep = d.CodDep;

update departamento set PreAnu=PreAnu*1.08 where PreAnu < 20000000;


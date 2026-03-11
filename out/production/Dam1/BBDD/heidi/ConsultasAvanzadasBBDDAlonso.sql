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
select SUBSTRING(NomEmp, 1, LOCATE(" ", NomEmp)) as "Nombre", SUBSTRING(NomEmp, LOCATE(" ", NomEmp)) as "Apellidos"  from empleado;

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
select AVG(TIMESTAMPDIFF(year, FecNaEmp, CURDATE())) from empleado where CodEmp not in (select CodEmpDir from departamento) and CodEmp not in (select CodEmpDir  from centro);

-- Ej5


-- Ej6


-- Ej7


-- Ej8


-- Ej9


-- Ej10


-- Ej11


-- Ej12


-- Ej13


-- Ej14


-- Ej15


-- Ej16


-- Ej17


-- Ej18


-- Ej19


-- Ej20


-- Ej21


-- Ej22


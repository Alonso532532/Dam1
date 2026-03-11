-- 1
SELECT nomdep FROM departamento;
-- 2
SELECT nomdep, preanu FROM departamento;
-- 3
SELECT * FROM departamento;
-- 4
SELECT nomemp, salemp FROM empleado;
-- 5
SELECT DISTINCT numhi FROM empleado;
-- 6
SELECT nomemp, salemp*numhi*4/100 AS 'Complemento familiar' FROM empleado;
-- 7
SELECT nomdep, preanu AS 'PreAnu €', preanu*1.1 AS 'USD' FROM departamento;
-- 8
SELECT nomdep AS 'Nombre de departamento', preanu AS 'Euros', preanu*1.1 AS 'Dolares' FROM departamento;
-- 9
SELECT nomemp, salemp FROM empleado WHERE salemp>3000000;
-- 10
SELECT nomemp, salemp, numhi FROM empleado WHERE salemp>4000000 AND numhi>0;
-- 11
SELECT nomdep, preanu FROM departamento WHERE preanu BETWEEN 10000000 AND 20000000;
-- 12
-- Manera 1
SELECT * FROM empleado WHERE coddep = 'PROZS' OR coddep = 'VENZS';
-- Manera2
SELECT * FROM empleado WHERE coddep IN ('PROZS', 'VENZS');
-- 13
SELECT * FROM departamento WHERE tidir = 'F' OR preanu > 20000000;
-- 14
SELECT * FROM empleado WHERE YEAR(fecnaemp) NOT BETWEEN 1970 AND 1975;
-- 15
SELECT * FROM empleado WHERE (coddep = 'PROZS' AND salemp > 2000000) OR (coddep = 'VENZS' AND numhi>1);
-- 16
SELECT * FROM departamento WHERE (codcen = 'FAZS' AND preanu > 10000000) OR (codcen = 'OFZS' AND tidir = 'P');
-- 17
SELECT nomdep, preanu FROM departamento WHERE preanu NOT BETWEEN 10000000 AND 20000000;
-- 18
SELECT nomdep FROM departamento WHERE nomdep LIKE '%Zona%';
-- 19
SELECT nomemp, salemp FROM empleado WHERE (nomemp LIKE 'M%' OR 'F%') AND salemp > 3000000;
-- 20
SELECT * FROM empleado WHERE 
	(YEAR(fecnaemp) BETWEEN 1970 AND 1979) AND 
	(coddep NOT LIKE 'PROZS') AND 
	(nomemp LIKE '%ar%' OR nomemp LIKE '%o') AND 
	(salemp > 3000000);

-- Subconsultas
-- 1
SELECT nomemp, salemp FROM empleado WHERE salemp > 
	(SELECT AVG(salemp) FROM empleado WHERE coddep = 'PROZS');

-- 2
SELECT nomemp, salemp FROM empleado WHERE salemp > 
	(SELECT AVG(salemp) FROM empleado WHERE coddep IN 
		(SELECT coddep FROM departamento WHERE NomDep = 'Investigación y Diseño'));

-- 3
SELECT nomemp, salemp FROM empleado e1 WHERE salemp > 
	(SELECT AVG(salemp) FROM empleado e2 WHERE e2.coddep = e1.Coddep );

-- 4
SELECT nomdep FROM departamento WHERE preanu > 
	(SELECT AVG(preanu) FROM departamento);

-- 5
SELECT nomdep FROM departamento WHERE preanu > 
	(SELECT AVG(PresuCentro) FROM 
		(SELECT SUM(preanu) AS PresuCentro FROM departamento GROUP BY codcen) AS Obligatorio);
-- 6
SELECT codhab, deshab FROM habilidad WHERE codhab NOT IN 
	(SELECT codhab FROM habemp);

-- 7
SELECT nomemp FROM empleado order by salemp desc limit 1;

-- 8
select nomemp from empleado where salemp = 
	(select max(salemp) from empleado);

-- 9
select * from empleado where salemp > any 
	(select salemp from empleado where coddep = 'JEFZS');

-- 10
select * from empleado where salemp > all
	(select salemp from empleado where coddep = 'VENZS');

-- 11
select * from centro where CodCen in (select CodCen from departamento where PreAnu > 20000000);

-- 12
select * from departamento where CodDep not in 
	(select CodDep from empleado);

-- 13
select * from departamento d where not exists 
	(select CodDep from empleado e where d.coddep=e.coddep);

-- 14
select * from centro c where 20000000 > all 
	(select PreAnu from departamento where CodCen = c.CodCen);

-- 15
select * from empleado e1 where coddep in
	(select coddep from empleado e2 where salemp > 2000000 and e1.codemp!=e2.Codemp);

-- 16
select * from empleado where fecinemp >= all 
	(select fecinemp from empleado);

select * from empleado e1 where not exists 
	(select * from empleado e2 where e2.FecInEmp>e1.FecInEmp);

-- 17
select * from centro where CodCen not in 
	(select CodCen from departamento where preanu < 1000000);

-- 18 
select * from departamento d where exists 
	(select * from empleado e where e.CodDep = d.CodDep and e.SalEmp > 4000000);

-- 19
select * from empleado e1 where e1.NumHi > 
	(select AVG(e2.NumHi) from empleado e2 where e1.CodDep = e2.CodDep);

-- 20
select * from empleado e1 where SalEmp = 
	(select MAX(SalEmp) from empleado e2 where e1.CodDep = e2.CodDep);

-- 21
select * from departamento d1 where d1.PreAnu > all 
	(select preanu from departamento d2 where d1.codcen != d2.CodCen);

-- MULTITABLAS

-- 1
select d.NomDep, d.PreAnu, c.CodCen 
	from departamento d 
	natural left join centro c;

-- 2
select d.NomDep, d.PreAnu, e.NomEmp
	from departamento d 
	join empleado e on d.CodEmpDir = e.CodEmp;

-- 3
select d.NomDep, d.PreAnu, c.CodCen, e.NomEmp 
	from departamento d 
	natural left join centro c
	join empleado e on e.CodEmp = c.CodEmpDir;

-- 4
select d.NomDep, d.PreAnu, c.CodCen, e.NomEmp 
	from departamento d 
	natural left join centro c
	join empleado e on e.CodEmp = d.CodEmpDir where d.PreAnu = 
	(select MAX(PreAnu) from departamento);

-- 5
select e.*, c.CodCen
	from empleado e
	natural join departamento d 
	join centro c on d.CodCen = c.CodCen where c.CodCen = 'FAZS';

-- 6
select e.NomEmp, h.NomHi
	from empleado e 
	natural join hijo h 
	where e.NumHi = 1 order by h.FecNaHi;

-- 7
select e.*, c.CodCen
	from empleado e
	natural join departamento d 
	join centro c on d.CodCen = c.CodCen where c.CodCen = 'FAZS' and e.NumHi > 0;

-- 8
select d.*, h.CodHab 
	from departamento d 
	natural join empleado e
	natural join habemp h where h.CodHab = 'FONTA';

-- 9
select d.*, d2.CodDep as 'Depende de'
	from departamento d
	natural join departamento d2 where d.CodDepDep is not null;

-- 10
select h.*, e.NomEmp 
	from habilidad h 
	natural left join habemp h2 
	natural left join empleado e 
	
-- 11
select * from habilidad where CodHab not in (select CodHab from habemp);

-- 12
select e.*, h.NomHi
	from empleado e 
	natural left join hijo h;

-- 13
select d.*, d2.CodDep as 'Depende de'
	from departamento d
	left join departamento d2 ON d.CodDepDep=d2.CodDep;

-- 14
select e.* 
	from empleado e 
	left join departamento d on e.CodEmp = d.CodEmpDir 
	where d.CodEmpDir is null;

-- 15
select e.* 
	from empleado e 
	left join centro c on e.CodEmp = c.CodEmpDir 
	where c.CodEmpDir is null;
	
-- 16
select c.* 
	from centro c 
	natural left join departamento d
	where d.CodDep is null;

-- 17
select e.* 
	from empleado e 
	left join centro c on e.CodEmp = c.CodEmpDir 
	left join departamento d on e.CodEmp = d.CodEmpDir 
	where c.CodEmpDir is null and d.CodEmpDir is null;

-- 18
select e.*, d.NomDep, h.NomHi , h.FecNaHi 
	from empleado e 
	natural join departamento d 
	natural left join hijo h;

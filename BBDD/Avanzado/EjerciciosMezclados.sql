-- 1
select d.CodEmpDir from departamento d union select c.CodEmpDir from centro c;

-- 2
select d.CodEmpDir from departamento d union all select c.CodEmpDir from centro c;

-- 3
select d.CodDep, d.NomDep from departamento d where d.PreAnu > 20000000 union 
select d.CodDep, d.NomDep from departamento d where d.TiDir = "F";

-- 4
select d.CodEmpDir from departamento d intersect select c.CodEmpDir from centro c;

-- 5
select d.CodEmpDir from departamento d except select c.CodEmpDir from centro c;

-- 6
select h.DesHab from habilidad h where 
	h.CodHab in (select h2.CodHab from habemp h2 where 
		h2.CodEmp in (select e.CodEmp from empleado e where e.CodDep = "PROZS")) union
select h.DesHab from habilidad h where 
	h.CodHab in (select h2.CodHab from habemp h2 where 
		h2.CodEmp in (select e.CodEmp from empleado e where e.CodDep = "VENZS"));

-- 7
select h.* from habilidad h where 
	h.CodHab in (select h2.CodHab from habemp h2 where 
		h2.CodEmp in (select e.CodEmp from empleado e where e.CodDep = "PROZS")) intersect
select h.* from habilidad h where 
	h.CodHab in (select h2.CodHab from habemp h2 where 
		h2.CodEmp in (select e.CodEmp from empleado e where e.CodDep = "VENZS"));

-- 1
insert into centro (CodCen, NomCen, DirCen, PobCen) values ("CENZ", "Centro Norte", 'Calle
Mayor 1', 'Zaragoza');

-- 2
insert into departamento (CodDep, NomDep, PreAnu, TiDir, CodCen) values ('DEVZS', 'Desarrollo Software', 18000000, 'F', 'CENZ');

-- 3
insert into empleado (NomEmp, FecNaEmp, FecInEmp, SalEmp, NumHi, CodDep) values ('García López, Ana', '1990-03-15', CURDATE(), 3200000, 1, 'DEVZS');

-- 4
insert into habilidad (CodHab, DesHab) values ('PROYE', 'Gestión de Proyectos');

insert into habemp values ("PROYE", 12, 3);

-- 5
create table emp_backup like empleado;
insert into emp_backup select * from empleado where CodDep = 'PROZS';

-- 6
insert into hijo values (12, 1, '2015-06-01', 'García Ruiz, Pablo');

-- 7
insert into empleado (NomEmp, CodDep) values ("Nuevo1", "DEVZS"), ("Nuevo2", "DEVZS");

-- 8
update empleado set SalEmp=SalEmp *1.05 where CodDep = "PROZS";

-- 9
update empleado set SalEmp=SalEmp-100000 where NumHi = 0;

-- 10
update departamento set CodEmpDir = (select e.CodEmp from empleado e where e.NomEmp = "García López, Ana") where CodDep = 'DEVZS';

-- 11
update empleado e set SalEmp=e.SalEmp*1.10 where e.SalEmp < (select promedio from (select AVG(e2.salemp) as promedio from empleado e2) as coste);

-- 12
update departamento d set PreAnu = d.PreAnu*1.08 where d.CodCen = "FAZS" and d.PreAnu < 20000000;

-- 13 
update empleado e set ExTelEmp = "9999" where 
	e.CodDep in (select dep from 
		(select d.CodDep as dep from departamento d where d.PreAnu = 
			(select MAX(d2.PreAnu) from departamento d2)) as CodDep)

-- 14
update empleado e set SalEmp = e.SalEmp * 1.03 where 
	e.CodDep in (select cod from 
			(select e2.CodDep as cod from empleado e2 where e2.NumHi>1) as deps);

-- 15
-- Manera ej
update empleado e join 
	(select h.CodEmp, COUNT(*) as cant from hijo h group by h.CodEmp) 
	as ch on e.CodEmp = ch.CodEmp 
	set NumHi=cant;
	
update empleado e set NumHi=0 where e.CodEmp  not in (select e.CodEmp from hijo);

-- Manera 2
update empleado e set NumHi = 
	(select COUNT(*) from hijo h where h.CodEmp = e.CodEmp);

-- 16
delete from habemp where CodHab = "PROYE";

-- 17
delete from habilidad where CodHab = "PROYE"

-- 18
delete from hijo where CodEmp not in (select e.CodEmp from empleado e);

-- 19
delete from hijo where CodEmp in (select e.CodEmp from empleado e where e.coddep = "DEVZS");

delete from habemp where CodEmp in (select e.CodEmp from empleado e where e.coddep = "DEVZS");

update departamento d set CodEmpDir = null where d.CodEmpDir in (select e.CodEmp from empleado e where e.coddep = "DEVZS");

delete from empleado where CodDep = "DEVZS";

-- 20
delete from habemp where CodEmp in 
	(select e.CodEmp from empleado e where e.salemp < 
		(select AVG(e2.SalEmp) from empleado e2));

-- 21
update empleado e set CodDep = null where CodDep in ("DEVZS", "CENZ");

delete from departamento where CodDep in ("DEVZS", "CENZ");

-- Vistas
-- 1
create view v_empleados_sobre_media as
	select e.nomEmp, e.salEmp, e.codDep from empleado e where e.salemp>(select AVG(e2.salemp) from empleado e2);

select * from v_empleados_sobre_media;

-- 2
create view v_dep_sin_empleados as
	select d.coddep, d.nomdep from departamento d where not exists (select e.codDep from empleado e where e.codDep = d.codDep);

select * from v_dep_sin_empleados;

-- 3
create view v_centros_presupuesto as
	select c.codcen, c.nomcen, SUM(d.preAnu) from centro c join departamento d on c.codCen = d.codCen group by c.codCen;

select * from v_centros_presupuesto;

-- 4
create view v_directorio as
	select e.nomEmp, d.nomDep, c.nomCen, e.salemp, e.numhi from empleado e 
	join departamento d on e.codDep=d.codDep
	join centro c on c.codCen=d.codCen;

select * from v_directorio;

-- 5
create view v_emp_habilidades as
	select e.NomEmp, h2.desHab, h1.nivHab from empleado e
	join habemp h1 on e.codEmp = h1.codEmp
	join habilidad h2 on h1.codHab = h2.codHab;

select * from v_emp_habilidades;

-- 6
create view v_resumen_dep as
	select d.nomDep, c.nomCen, e2.nomEmp as NomEmpDir, COUNT(e.nomEmp) as NumEmpleados, MIN(e.salEmp) as SalarioMinimo, MAX(e.salemp) as SalarioMaximo from departamento d
	join centro c on d.codCen = c.codCen
	join empleado e on d.codDep = e.codDep
	join empleado e2 on d.codEmpDir = e2.codEmp group by d.codDep, c.nomCen, e2.codEmp;

drop view v_resumen_dep;

select * from v_resumen_dep;

-- 7
create view v_emp_hijos as
	select e.nomEmp, h.numHij, h.fecNaHi from empleado e
	left join hijo h on e.codEmp = h.codEmp;

select * from v_emp_hijos;

-- 8
create view v_top_sal_centro as
	select c.nomcen, (select e.nomEmp from empleado e where e.codDep in (select d.coddep from departamento d where d.codCen = c.codCen) and e.salemp in (select max(e2.salemp) from empleado e2 where e2.codDep in (select d.coddep from departamento d where d.codCen = c.codCen))) as NomEmpMejorPagado from centro c;

drop view v_top_sal_centro;

select * from v_top_sal_centro;

-- 9
create view v_habilidades_populares as
	select h.desHab, count(h2.codHab) from habilidad h 
	join habemp h2 on h.codHab = h2.codHab 
	group by h.codHab having count(h2.codHab)>=2;

drop view v_habilidades_populares;

select * from v_habilidades_populares;
-- Transacciones
-- 1
create index idx_sal on empleado (salemp);

explain select * from empleado where salemp>30000000;

-- 3
create index idx_fecinc on empleado (FecInEmp);
-- Aquí si que se compara el atributo con índice entonces si que se usa
explain select * from empleado e where e.FecInEmp>'2000-01-01';
-- Pero aquí no
explain select * from empleado e where year(fecinemp)=2000;

-- 2
-- compuesto
create index idx_dep_sal on empleado(codDep, Salemp);

-- Transacciónes
-- 1
select @autocommit;
set autocommit=0;
insert into empleado values (4321, 'PROZS', null, CURDATE(), '1985-02-02', '12345678J', 'PEPE', 0, 123456);
select * from empleado e where e.NomEmp = "PEPE";
rollback;


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

-- 1
delete from alum a 
where a.dni in (select an.dni from antiguo an);

-- 2
insert into emple ()
values (200, "saavedra", (select e2.oficio from emple e2 where e2.apellido = "sala"), (select e2.dir from emple e2 where e2.apellido = "sala"), CURDATE(), (select e2.salario from emple e2 where e2.apellido = "sala")*1.20, (select e2.comision from emple e2 where e2.apellido = "sala"), (select e2.dept_no from emple e2 where e2.apellido = "sala"))

-- 3
update emple e 
set e.dept_no=(select d.dept_no from depart d where d.loc="BILBAO") where e.apellido="saavedra";

-- 4
delete from depart d
where d.dept_no not in (select e.dept_no from emple e);

-- 5
delete from centro c
where c.COD_CENTRO not in (select p.COD_CENTRO from personal p);

-- 6
delete from personal p
where p.cod_centro in 
	(select c.COD_CENTRO from centro c  
	where (select count(p.DNI) from profesor p where p.COD_CENTRO=c.COD_CENTRO)<2 
	and c.NUM_PLAZAS<300);

-- 7
delete from profesor p
where p.dni not in (select p2.dni from personal p2);

-- 8
insert into articulo ()
values (
	"PI201",
	"Pipas",
	(select f.COD from fabricante f where f.NOMBRE="PRESIDENT"),
	1,
	"Primera",
	100,
	200,
	5
);


insert into pedido ()
select 
	t.nif, 
	(select a.cod from articulo a where a.nombre="Pipas"), 
	CURDATE(), 
	5 
from tienda t;

-- 9
insert into tienda ()
values (
	"6666-C",
	"Cosas",
	"C/Señorio, 5",
	"Madrid",
	"Madrid",
	12.423
);

insert into pedido ()
select 
	(select t.nif from tienda t where t.nombre="Cosas"), 
	a.COD, 
	CURDATE(), 
	20 
from articulo a;

-- 10
insert into tienda ()
values (
	"6676-C",
	"Elementos",
	"C/123, 5",
	"Sevilla",
	"Sevilla",
	12.422
);

insert into tienda ()
values (
	"6677-C",
	"Arte",
	"C/124, 5",
	"Sevilla",
	"Sevilla",
	12.522
);

insert into pedido ()
select 
	(select t.nif from tienda t where t.nombre="Elementos"), 
	a.COD, 
	CURDATE(), 
	30 
from articulo a 
where a.COD_FABRICANTE=(select f.COD from fabricante f where f.NOMBRE="GALLO");

insert into pedido ()
select 
	(select t.nif from tienda t where t.nombre="Arte"), 
	a.COD, 
	CURDATE(), 
	30 
from articulo a 
where a.COD_FABRICANTE=(select f.COD from fabricante f where f.NOMBRE="GALLO");

-- 11
update articulo 
set categoria="Quinta"
where COD_FABRICANTE in (select f.COD from fabricante f where f.PAIS="ITALIA");

-- 12
delete from articulo a
where a.cod not in (select cod_articulo from pedido) 
and a.cod not in (select cod_articulo from venta);

-- 13
update pedido
set UNIDADES_PEDIDAS=UNIDADES_PEDIDAS-1
where nif = "5555-B";
delete from alum where dni in (select a.dni from antiguo a);

insert into emple 
(emp_no, apellido, fecha_alt, oficio, dir, salario, comision, dept_no) 
	select 
		200,
		'saavedra',
		CURDATE(),
		e.OFICIO,
		e.dir,
		e.SALARIO * 1.20 as SALARIO,
		e.COMISION,
		e.DEPT_NO
	from emple e where e.APELLIDO = 'sala';

update emple e set e.dept_no = (select d.DEPT_NO from depart d where d.loc = 'BILBAO')
where e.apellido = 'saavedra';

delete from centro c where not exists (select p.* from personal p where p.cod_centro = c.cod_centro);

delete from personal p where p.cod_centro in 
	(select c.cod_centro from centro c 
	join profesor pr on pr.cod_centro = c.cod_centro 
	where num_plazas<300 
	group by c.cod_centro
	having SUM(pr.dni)<2);

delete from profesor p where not exists (select p2.* from personal p2 where p.dni = p2.dni);

insert into articulo (
	cod,
	nombre,
	categoria,
	peso,
	cod_fabricante,
	precio_venta,
	precio_costo
) values (
	'PI201',
	'Pipas',
	'Primera',
	1,
	(select f.COD from fabricante f where nombre = 'PRESIDENT'),
	3,
	1
);

insert into pedido 
select
	t.nif,
	(select a.cod from articulo a where a.nombre = 'Pipas'),
	curdate(),
	5
from tienda t;

insert into tienda values (
	'6666-A',
	'Iker',
	'C/Lozano, 3',
	'Madrid',
	'MADRID',
	12341
);

insert into pedido 
select
	'6666-A',
	a.cod,
	curdate(),
	20
from articulo a;

insert into tienda values (
	'7777-A',
	'Segunda',
	'C/Alpaca, 5',
	'Sevilla',
	'SEVILLA',
	53213
);

insert into pedido
select
	'7777-A',
	a.cod,
	curdate(),
	30
from articulo a
where a.cod_fabricante = (select f.cod from fabricante f where f.nombre = 'gallo');

update articulo a set a.categoria = 'quinta' 
where a.COD_FABRICANTE in 
	(select f.COD from fabricante f 
	where f.PAIS = 'ITALIA')
	
delete from articulo a 
where a.cod not in 
	(select cod_articulo from venta) 
and a.cod not in 
	(select cod_articulo from pedido);



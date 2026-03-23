-- 1
update cliente c
set Direccion = "Mayor, 10 Teruel"
where DNI= "022222222R";

-- 2
update cliente c 
set nombre= UPPER(nombre);

-- 3
delete from pelicula p
where p.codpeli = 6;

insert into pelicula ()
values (6, 
	"Lo que el agua se llevó", 
	(select g.codgenero from genero g where g.descripcion = "Drama"), 
	(select p.codpeli from pelicula p where p.titulo = "Lo que el viento se llevó"), 
	(select a.codactor from actor a where a.nombre="Eva"));

-- 4
delete from copia c
where c.codpeli = 6;

insert into copia
values (6, 1);

-- 5
insert into factura ()
values (4, 
	CURDATE(), 
	0, 
	(select c.DNI from cliente c where c.Nombre="PEDRO MARTINEZ ROY"));

-- 6
insert into detallefactura ()
values (4, 1, "Piel", 4.50, 1),
(4, 2, "Refresco", 2.50, 2);

update factura f
set Importe= (select SUM((select d.PrecioUnitaro*d.NumeroUnidades from detallefactura d where d.CodFactura = 4)) from detallefactura d3 where d3.CodFactura=4);

select SUM(d.PrecioUnitaro*d.NumeroUnidades) from detallefactura d where d.CodFactura=4;

-- 7
insert into prestamo ()
values (6, 1, curdate(), (select c.DNI from cliente c where c.nombre="PEDRO MARTINEZ ROY"));

-- 8

-- 9
delete from pelicula p
where p.codpeli = 6;

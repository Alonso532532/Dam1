-- empresa
select nomemp, coddep, count(*) over (partition by coddep) as nempleados from empleado;
-- world
select name, countrycode, population, avg(population) over (partition by countrycode), sum(population) over (partition by countrycode) from city 
where countrycode in ('ESP', 'FRA');

select name, continent, Population, 
rank() over (Partition by continent order by population desc) as 'Rango con saltos', 
dense_rank() over (Partition by continent order by population desc) as 'Rango sin saltos'
from country where continent='oceania';

select name, population, 
first_value(name) over (partition by countrycode order by population desc) as maximo, 
first_value(name) over (partition by countrycode order by population) as minimo from city 
where countrycode in ('ESP', 'FRA');
-- Empresa
select nomdep from departamento 
	where preanu>(select avg(presupuestocentro) from (select sum(preanu) as presupuestocentro from departamento group by codcen) as PresuCentro);
-- Otra manera
with presucentro as 
	(select sum(preanu) as SumaPresupuesto from departamento group by codcen)
	select nomdep from departamento where preanu>
		(select avg(SumaPresupuesto) from presucentro);
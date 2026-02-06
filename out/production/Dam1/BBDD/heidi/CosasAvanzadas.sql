-- Paises que tengan ciudades
SELECT name FROM country co WHERE EXISTS 
	(SELECT * FROM city ci WHERE ci.CountryCode=co.Code);
	
-- Paises que no tengan ciudades
SELECT name FROM country co WHERE NOT EXISTS 
	(SELECT * FROM city ci WHERE ci.CountryCode=co.Code);
	
-- Subconsultas correlacionadas
-- Nombre de los paises junto a su ciudad más poblada
SELECT NAME, 
	(SELECT MAX(population) FROM city ci WHERE ci.CountryCode=co.code) 
FROM country co;
-- paises con poblacion mayor al promedio de su continente
SELECT NAME FROM country co1 WHERE population>(SELECT AVG(population) FROM country co2 WHERE co2.Continent=co1.Continent);

-- Nombre de ciudades de más dde 1000000 habitantes y el nombre de los paises en los que se encuentran
SELECT ci.NAME AS "Ciudad", co.NAME AS "País" FROM city ci INNER JOIN country co ON ci.countrycode=co.Code WHERE ci.Population>1000000;

-- Nombre de pais junto con sus ciudades
SELECT ci.NAME AS "Ciudad", co.NAME AS "País" FROM city ci INNER JOIN country co ON ci.countrycode=co.Code;

-- Todos los paises aunque no tengan ciudades
SELECT co.NAME AS "País", ci.NAME AS "Ciudad" FROM country co LEFT JOIN city ci ON ci.countrycode=co.Code WHERE ci.ID IS NULL;

-- 
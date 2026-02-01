SELECT ci.*, co.* FROM city ci CROSS JOIN country co;

SELECT ci.*, co.* FROM city ci INNER JOIN country co ON ci.CountryCode=co.Code;

SELECT name, cl.CountryCode, language FROM city ci INNER JOIN countrylanguage cl ON ci.CountryCode=cl.countrycode;
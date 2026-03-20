SELECT * FROM investigadores ORDER BY facultad;
SELECT nombre AS NomInvestigador, apellidos AS ApellInvestigador, dni AS DNI FROM investigadores ORDER BY apellidos;
SELECT * FROM facultades WHERE NomFacultad LIKE '%Ciencias%';
SELECT * FROM equipos WHERE idFacultad=3;
SELECT * FROM equipos WHERE IdEquipo NOT LIKE 'H%';
SELECT * FROM investigadores WHERE facultad=2 OR facultad=4;
SELECT * FROM investigadores WHERE facultad IN (2,4);
SELECT * FROM reservas WHERE FInicio LIKE '2024-11-%';
SELECT * FROM reservas WHERE FInicio BETWEEN '2024-11-01' AND '2024-11-30';

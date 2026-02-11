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
SELECT * FROM empleado WHERE (YEAR(fecnaemp) BETWEEN 1970 AND 1979) AND (coddep NOT LIKE 'PROZS') AND (nomemp LIKE '%ar%' OR nomemp LIKE '%o') AND (salemp > 3000000);
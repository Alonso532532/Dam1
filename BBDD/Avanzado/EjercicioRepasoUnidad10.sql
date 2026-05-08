-- 1
CALL ejercicio1(20);

-- 2
call ejercicio2(30, 20);

-- 3
call ejercicio3("Europe", "Spanish");

-- 4
select ejercicio4(20);

-- 5
set @palabra="Hola hecprooll";
call ejercicio5(@palabra);
select @palabra;

-- 6
call ejercicio6(1, "PRUEBA");

-- 7
select ejercicio7("PENELOPE", "GUINESS");

-- 8
call ejercicio8("New");

-- 9
call ejercicio9("New",@peliculas);
select @peliculas;

-- 10
select ejercicio10("2020-02-04", "2025-02-04");

-- 11
call ejercicio11(1);

-- 12
call ejercicio12(64, @duracion);
select @duracion;

-- 13
call ejercicio13("France");
select gnp from country where name = "france";


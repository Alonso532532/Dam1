select MAX(id) as max from autores;

select id from autores order by id desc limit 1;

insert into libros (titulo, precio, id_autor)
values ("sdadasd", 20.2, 1);
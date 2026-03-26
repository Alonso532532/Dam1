const sout = (texto) => console.log(texto)
// Permite extraer valores de objetos o arrays facilmente
const persona = {
    nombre: "Juanma",
    edad: 23,
}

/* 
const nombre = persona.nombre
const edad = persona.edad
*/

const {nombre, edad} = persona
sout(nombre + edad)
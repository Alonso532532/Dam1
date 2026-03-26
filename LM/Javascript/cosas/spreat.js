const sout = (texto) => console.log(texto)

// Sirve para operar con arrays y permite expandirlos

const numeros = [1, 2 , 3, 4]
const listaNumeros = [...numeros, "asd", 8, ...numeros, true]

//Permite concatenar arrays de forma sencilla

sout(listaNumeros)

// Se pueden concatenar objetos

const persona = {
    nombre: "Juanma",
    edad: 23
}

const personaCompleta = {
    ...persona,
    ciudad: "Teruel",
    codigoPostal: 44002
}


sout(personaCompleta)

// Se pueden hacer arrays de objetos como en json

const personas = [{
    nombre: "Pablo",
    edad: 23
},{
    nombre: "Pascual",
    edad: 23,
    ciudad: "Teruel",
    codigoPostal: 44002 
}]
sout(personas.at(0).nombre+"\n"+personas.at(1).ciudad)
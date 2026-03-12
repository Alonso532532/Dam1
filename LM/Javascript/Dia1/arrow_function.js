const saludar = (nombre) => "Hola"+nombre
console.log(saludar('Alberto'))

const suma = (a,b) => a+b;
console.log(suma(2,5) == 7 ? "siete" : "No es siete")

const obtenerFecha = () => new Date()
console.log(obtenerFecha())
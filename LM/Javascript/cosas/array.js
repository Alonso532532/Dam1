//Hemos utilizado:
//.lenght
//.pop
//.push
//.unshift
//.shift
const sout = (texto) => console.log(texto)

const frutas = ["manzana", "pera", "melocotón"]

sout(frutas + " mide " + frutas.length)

frutas[1] = "piña"

sout(frutas[frutas.length-1])

const carrito = ["Raton", "Monitor"]
carrito.unshift("Webcam1")
carrito.push("Webcam2")
sout(carrito)

const lista=carrito.shift()
sout(`La lista nueva es ${lista} y la antigua es ${carrito}`)


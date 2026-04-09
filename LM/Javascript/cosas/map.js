let numeros = [1,2,3,4]
const dobles = numeros.map(num=>{
    console.log(`Procesando ${num}`)
    return num*2
})
console.log(dobles)

numeros = numeros.map(a=>{
    if((a%2)===0){
        return a*100
    }
    return a
})
console.log(numeros)

const usuariosDesdeServidor = [
    {id: 1, nombre: "Hecproll", edad: 28},
    {id: 2, nombre: "iker", edad: 2},
    {id: 3, nombre: "eker", edad: 6}
]

usuariosDesdeServidor.forEach(a=>console.log(a))

let nuevo = usuariosDesdeServidor.map(a=>({
    nombre: a.nombre,
    valor: a.id,
    esAdulto: a.edad>=18
    }))

nuevo.forEach(a => console.log(a))


const sout = (texto) => console.log(texto)
const alumnos = [
  { nombre: "Javi", nota: 8 },
  { nombre: "Alberto", nota: 5 },
  { nombre: "Quiles", nota: 9 },
  { nombre: "Hector", nota: 4 }
]
let aprobados = alumnos.filter(a => a.nota>=5)

aprobados.forEach(a=>console.log(a))

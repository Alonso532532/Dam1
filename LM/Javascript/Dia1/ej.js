const sout = (texto) => console.log(texto)
const alumnos = [
  { nombre: "Javi", nota: 8 },
  { nombre: "Alberto", nota: 5 },
  { nombre: "Quiles", nota: 9 },
  { nombre: "Hector", nota: 4 }
]
resp = alumnos.filter(a => a.nota>6).map(a => a.nombre)

sout(resp)


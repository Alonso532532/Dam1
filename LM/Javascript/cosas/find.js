const sout = (text) => console.log(text)
// Es como el filter pero solo devuelve el primero que coincida
const usuarios = [
    {id: 1, nombre: "Ekre"},
    {id: 2, nombre: "Juanma"},
    {id: 3, nombre: "Juanma"}
]

sout(usuarios.find(a=>a.nombre==="Juanma"))
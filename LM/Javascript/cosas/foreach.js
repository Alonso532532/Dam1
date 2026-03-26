const alumnos=["Eker", "Alons", "Juanma", 5]

console.log("For normal")
for(let i = 0; i<alumnos.length; i++){
    console.log(alumnos[i])
}

console.log("Sin index")
alumnos.filter(a=>a.length>4).forEach(a=>console.log(a))

console.log("Con index")
alumnos.forEach((a,i)=>console.log(`${i+1} - ${a}`))
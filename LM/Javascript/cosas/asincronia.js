function descargarDatos(){
    const inicio = Date.now()

    //Bloqueo durante 3 segundos el programa
    while(Date.now()-inicio<3000){}
    console.log("Datos descargados con éxito!!!")
}
//No para el programa
console.log("Descargando datos")
setTimeout(()=>{
    console.log("Datos descargados con éxito!!!")
}, 3000)
//Para el programa
console.log("Descargando datos")
descargarDatos()
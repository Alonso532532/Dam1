const promesa = new Promise((resolve, reject) => 
    setTimeout(()=>{
        const exito = false
        if(exito){
            resolve("Exito, -- DATOS --")
        } else {
            reject("Error, -- GITANO --")
        }
    }, 2000)
)

promesa
    .then(resultado=>console.log(resultado))
    .catch(error=>console.log("Error: "+error))
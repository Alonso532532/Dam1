fetch('https://pokeapi.co/api/v2/pokemon/') //Esto trae todo, lee las apis
.then( // Espera una promesa, se le tiene que decir que se va a obtener un json
    resp => resp.json()
)
.then(
    data => data.results.forEach(element => console.log(element.name))
)

// Lo hago con una lista
let nombres = []
fetch('https://jsonplaceholder.typicode.com/users') 
.then( 
    resp => resp.json()
)
.then(
    data => nombres = data.map(a=>a.name))

nombres.forEach(a => console.log(a))

// async / await

const obtenerUsuarios = async () => {
    try{
        const res = await fetch('https://jsonplaceholder.typicode.com/users')
        const data = await res.json()
        data.forEach(usr=>console.log(usr.name))
    }catch(error){
        console.log("Error")
    }
}

obtenerUsuarios()
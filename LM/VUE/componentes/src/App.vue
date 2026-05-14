<script setup>
  import { computed, ref } from 'vue';
  import BlogPost from './components/BlogPost.vue';
  import BotonContador from './components/BotonContador.vue';
  import ContactosPractica from './components/ContactosPractica.vue';
  import PaginatePost from './components/PaginatePost.vue';
import LoadingSpinner from './components/LoadingSpinner.vue';

  const posts = ref([])

  const contactos = ([
    {nombre: "Juan Pérez", email: "juan@example.com", estado: "Desarollador"},
    {nombre: "Pedro Pérez", email: "pedro@example.com", estado: "Estudiante"},
    {nombre: "Mario Pérez", email: "mario@example.com", estado: "Profesor"}
  ])
  const miFavorito = ref("")

  const cambiarFavorito = (titulo) => miFavorito.value = titulo

  const contactarCon = ref("Nadie")

  const cambiarContactar = (contacto) => contactarCon.value = contacto

  const loading = ref(true)

  // Uso de fetch para cargar datos de una api publica
  fetch('https://jsonplaceholder.typicode.com/posts')
  // Cuando responda se formatea la respuesta a json
    .then( response => response.json())
  // manipulo la información
    .then( data => posts.value = data)
    .finally(() =>{
      setTimeout(()=>{loading.value=false}, 3000)
    })

  // Paginación
  const postXPagina = 10;
  const ini = ref(0)
  const fin = ref(postXPagina)
  const tamanio = computed(()=>posts.value.length)


  const next = () => {
    if (fin.value < posts.value.length){
      ini.value = fin.value
      fin.value = fin.value+postXPagina
    }
  }

  const previous = () => {
    if (ini.value > 0){
      ini.value = ini.value-postXPagina
      fin.value = fin.value-postXPagina
    }
  }
</script>

<template>
  <div class="container">
    <center>
      <h1 class="mt-4">DAM1 - VUE</h1>
      <BotonContador/>
      <BotonContador/>
    </center>    
    <hr>

    <h2>Contactar con: {{ contactarCon }}</h2>
    <div class="row">
      <ContactosPractica 
        v-for="contacto in contactos"
        :nombre="contacto.nombre"
        :email="contacto.email"
        :estado="contacto.estado"
        @cambiarTextoContactar="cambiarContactar"
        class="col m-1"
      />
    </div>

    <hr>
    <LoadingSpinner v-if="loading"/>
      <div v-else>
        <h2>Mi post favorito: {{ miFavorito }}</h2>

        <PaginatePost
          @siguiente="next"
          @anterior="previous"
          :inicio="ini"
          :fin="fin"
          :tamanio="tamanio"
        class="mx-3" />
        <BlogPost 
          v-for="post in posts.slice(ini,fin)" :key="post.id"
          :title="post.title"
          :texto="post.texto"
          :color="post.color"
          :id="post.id"
          @cambiarTituloFavorito="cambiarFavorito"
          class="m-3"
        /> 
      </div>
    </div>
</template>

<style scoped>

</style>

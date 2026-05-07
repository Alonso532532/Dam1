<script setup>
import { ref } from 'vue';
import BlogPost from './components/BlogPost.vue';
import BotonContador from './components/BotonContador.vue';
import ContactosPractica from './components/ContactosPractica.vue';

const posts = ref([
  {title: "Post 01", texto: "Hola Hecproll", color: "primary", id: 1},
  {title: "Post 02", texto: "Hola Pascual", color: "warning", id: 2},
  {title: "Post 03", texto: "Hola Iker", color: "success", id: 3},
  {title: "Post 04", color: "danger", id: 4}
])

const contactos = ([
  {nombre: "Juan Pérez", email: "juan@example.com", estado: "Desarollador"},
  {nombre: "Pedro Pérez", email: "pedro@example.com", estado: "Estudiante"},
  {nombre: "Mario Pérez", email: "mario@example.com", estado: "Profesor"}
])
const miFavorito = ref("")

const cambiarFavorito = (titulo) => miFavorito.value = titulo

const contactarCon = ref("")

const cambiarContactar = (contacto) => contactarCon.value = contacto

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
    <h2>Mi post favorito: {{ miFavorito }}</h2>
    <BlogPost 
      v-for="post in posts" :key="post.id"
      :title="post.title"
      :texto="post.texto"
      :color="post.color"
      @cambiarTituloFavorito="cambiarFavorito"
      class="m-3"
    />

      

    </div>
</template>

<style scoped>

</style>

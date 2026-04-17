<script setup>
  const nombre = "IKER LOZANO ROMERO"
  const styleColor = "color: red;"
  const active = true
  const colores = ["Blue", "Red", "Green"]
</script>

<template>
  <h1>Hola {{ nombre }}</h1>
  <h2 :style="styleColor">Hola {{ nombre.toLowerCase() }}</h2>
  <hr>
  <p>{{ active ? "Estoy iker" : "No estoy iker" }}</p>
  <p>{{ colores }} iker</p>
  <!-- Uso un array -->
  <h3 :style="`color: ${colores[2]}`">Color con interpolación IKER</h3>
  <!-- Directiva v-if muestra o no un elemento según un booleano, el v-else tiene que estár pegado al v-if -->
   <hr>
  <h3>Directiva v-if</h3>
  <h2 v-if="active">iker, v-if en acción</h2>
  <h2 v-else-if="active">iker está en false</h2>
  <h2 v-else>No se sabe en que estado está iker</h2>
  <hr>
  <!--Este lo que hace es ocultar el objeto pero no qitarlo-->
  <h3>Directiva v-show</h3>
  <h2 v-show="true">True</h2>
  <h2 v-show="false">False</h2>
</template>

<style>
  h1 {
    color: blue;
  }
</style>
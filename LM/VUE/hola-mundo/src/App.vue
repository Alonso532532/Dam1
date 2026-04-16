<script setup>
  const nombre = "Vue 3"
  const arrayFrutas = ["🍎", "🍌", "🍉", "🍓", "🍒"];
  const descargaFrutas =[
    {
      name: "Manzana",
      price: "1.00€",
      description: "Manzana Golden",
      stock: 10
    },{
      name: "Pera",
      price: "2.00€",
      description: "Pera Conferencia",
      stock: 20
    },{
      name: "Naranja",
      price: "3.00€",
      description: "Naranja de valencia",
      stock: 30
    }
  ]
  const fruta = {
      name: "Fresa",
      price: "4.00€",
      description: "Fresita de iker"
  }
</script>

<template>
  <h1>Hola {{ nombre }}</h1>
  <hr>
  <!-- For de toda la vida -->
  <h3>Directiva v-for</h3>
  <p>{{ arrayFrutas }}</p>
    <!-- El key es una clave para identificar a cada elemento por separado -->
  <ul>
    <li v-for="(fruta, index) in arrayFrutas"
    :key="index">{{index}} - {{ fruta }}</li>
  </ul>
  <h3>Recorro un array de objetos</h3>
  <p v-for="fruta in descargaFrutas" :key="fruta.name">{{ `${fruta.name}, que vale ${fruta.price} tiene la descripción ${fruta.description}` }}</p>
  <h3>Recorro un objeto</h3>
  <p v-for="(valor, propiedad, index) in fruta">{{ index }} - {{ valor }} - {{ propiedad }}</p>
</template>

<style>

</style>
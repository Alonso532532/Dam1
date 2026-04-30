<script setup>
const productos = [
  { id: 1,  nombre: 'Portátil',      precio: 999,  stock: 12,  categoria: 'Electrónica' },
  { id: 2,  nombre: 'Teclado',     precio: 49,   stock: 34,  categoria: 'Periféricos' },
  { id: 3,  nombre: 'Monitor',     precio: 320,  stock: 8,   categoria: 'Electrónica' },
  { id: 4,  nombre: 'Ratón',       precio: 25,   stock: 60,  categoria: 'Periféricos' },
  { id: 5,  nombre: 'Auriculares', precio: 89,   stock: 20,  categoria: 'Audio'       },
  { id: 6,  nombre: 'Webcam',      precio: 75,   stock: 15,  categoria: 'Periféricos' },
  { id: 7,  nombre: 'SSD 1TB',    precio: 110,  stock: 27,  categoria: 'Almacenamiento' },
  { id: 8,  nombre: 'Hub USB',    precio: 35,   stock: 45,  categoria: 'Periféricos' },
  { id: 9,  nombre: 'Altavoces',  precio: 130,  stock: 9,   categoria: 'Audio'       },
  { id: 10, nombre: 'Alfombrilla',precio: 18,   stock: 80,  categoria: 'Periféricos' },
]


const estudiantes = [
  { id: 1,  nombre: 'Dani Remón',    nota: 9.2,  aprobado: true,  curso: 'DAW' },
  { id: 2,  nombre: 'Luis Martín',   nota: 4.8,  aprobado: false, curso: 'DAM' },
  { id: 3,  nombre: 'Sara López',    nota: 7.5,  aprobado: true,  curso: 'ASIR' },
  { id: 4,  nombre: 'Carlos Pérez', nota: 6.0,  aprobado: true,  curso: 'DAW' },
  { id: 5,  nombre: 'Diego Quiles',   nota: 3.1,  aprobado: false, curso: 'DAM' },
  { id: 6,  nombre: 'Pedro Sanz',   nota: 8.8,  aprobado: true,  curso: 'ASIR' },
  { id: 7,  nombre: 'Elena Vega',   nota: 5.5,  aprobado: true,  curso: 'DAW' },
  { id: 8,  nombre: 'Hector Enguita',   nota: 2.9,  aprobado: false, curso: 'DAM' },
  { id: 9,  nombre: 'Hector Lozano', nota: 9.7,  aprobado: true,  curso: 'ASIR' },
  { id: 10, nombre: 'Tomás Gil',    nota: 7.0,  aprobado: true,  curso: 'DAW' },
]
</script>

<template>
    <center>
        <h1>Ejercicios de repaso</h1>
        <h2>- Clase 1 -</h2>
    </center>
    <div class="ej">
        <h3>Productos</h3>
        <ul>
        <li v-for="producto in productos" :key="producto.id">{{ producto.id }} - {{ producto.nombre }} - {{ producto.precio }}€</li>
        </ul>

        <hr>

        <h3>Estudiantes</h3>
        <p v-for="estudiante in estudiantes" :key="estudiante.id">{{ estudiante.id }} - {{ estudiante.nombre }} - {{ estudiante.nota }}</p>
    </div>
    <center>
        <h2>- Clase 2 -</h2>
    </center>
    <!-- El "v-if" prioriza antes que el "v-for" entonces hay que hacerlo después-->
    <div class="ej">
        <h3>v-for con v-if: Productos con un valor superior a 50</h3>
        <!-- Hay que usar un "template" para evitar este problema-->
        <ul>
            <template v-for="producto in productos" :key="producto.id">
                <li v-if="producto.precio>50">{{ producto.id }} - {{ producto.nombre }} - {{ producto.precio }}</li>
            </template>
        </ul>
        <h3>Estudiantes aprobados</h3>
        <ul>
            <template v-for="estudiante in estudiantes" :key="estudiante.id">
                <li v-if="estudiante.nota>=5">{{ estudiante.id }} - {{ estudiante.nombre }} - {{ estudiante.nota }}</li>
            </template>
        </ul>
    </div>
</template>

<style>
    .ej {
        border-radius: 10px;
        padding: 5px;
        padding-left: 20px;
        padding-right: 20px;
        margin: 10px;
        background-color: rgb(219, 219, 219);
    }
</style>
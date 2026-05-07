<script setup>
import { computed, ref } from 'vue'

    const boton = ( mensaje ) => {
        console.log(mensaje)
    }

    const contador = ref(0)


    const aumentar = () => {
        contador.value++
    }

    const restar = () => {
        contador.value--
    }



    // Propiedades computadas (También vale una función normal)
    const claseContador = computed(() => {
        if (contador.value===0){
            return 'cero'
        } 
        return contador.value > 0 ? 'verde' : 'rojo'
    })
    
    const arrayFavoritos = ref([])

    const reiniciar = () => {
        contador.value=0
    }

    const anadir = () => {
        var existe = false
        arrayFavoritos.array.forEach(element => {
            
        });
        arrayFavoritos.value.push(contador.value)
    }

</script>

<template>
    <div class="container">
        <div class="text-center">
            <!-- el "@" hae lo mismo que "v-on:"-->
            <button class="btn btn-primary" style="font-size: 25px; margin: 10px;" v-on:click="boton('boton1')">Boton izquierdo</button>
            <button class="btn btn-primary" style="font-size: 25px; margin: 10px;" @click.middle="boton('boton2')">Botón central</button>
        </div>
        <div class="text-center">
            <div class="btn-group" style="margin: 10px;">
            <button class="btn btn-success" style="font-size: 25px;" v-on:click="aumentar()">Aumentar</button>
            <button class="btn btn-danger" style="font-size: 25px;" v-on:click="restar()">Restar</button>
            <button class="btn btn-outline-primary" style="font-size: 25px;" v-on:click="reiniciar()">Reiniciar</button>
            <button class="btn btn-outline-warning" style="font-size: 25px;" v-on:click="anadir()">Favorito</button>
            </div>
            <h2 :class="claseContador">Contador {{ contador }}</h2>
            <ul>
                <li v-for="fav in arrayFavoritos">{{ fav }}</li>
            </ul>
        </div>
    </div>
</template>

<style>

    .rojo {
        color: red;
    }
    .verde {
        color: green;
    }
    .cero{
        color: brown;
    }
</style>
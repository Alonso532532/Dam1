<script setup>
import { ref } from 'vue';

    const contador = ref(0)

    const incrementar = () => contador.value++
</script>

<template>
    <button class="btn btn-primary" id="boton" @click="incrementar">Contador {{ contador }}</button>
</template>

<style>
    #boton{
        margin: 10px;
    }
</style>
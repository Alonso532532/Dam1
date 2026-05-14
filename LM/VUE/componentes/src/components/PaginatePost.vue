<script setup>
    defineProps(["inicio", "fin", "tamanio"])
</script>

<template>
    <div class="btn-group" role="group" aria-label="Basic example">
        <button @click="$emit('anterior')" type="button" class="btn btn-outline-primary" :disabled="inicio==0">{{inicio}} Anterior</button>
        <button @click="$emit('siguiente')" type="button" class="btn btn-outline-primary" :disabled="tamanio<=fin">{{fin}} Siguente</button>
    </div>
</template>
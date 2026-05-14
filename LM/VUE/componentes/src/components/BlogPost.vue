<script setup>
    // Forma 1
    // defineProps(['title', 'texto', 'color'])

    // Forma 2
    const props = defineProps({
        title: String,
        id: Number,
        texto: {
            type: String,
            default: "Sin descripción"
        },
        color: String
    })

    // const emit = defineEmits(['cambiarTituloFavorito']) Y se le llamaría solo con emit en vez de $emit
</script>

<template>
    <div class="card">
        <div class="card-body text-center border border-4" :class="`border-${color}`">
            <h4 class="card-title">
                {{ title }}
            </h4>
            <p>
                {{ id }} - {{ texto }}
            </p>
            <button @click="$emit('cambiarTituloFavorito', title)" class="btn btn-outline-primary">Mi post favorito</button>
        </div>
    </div>
</template>
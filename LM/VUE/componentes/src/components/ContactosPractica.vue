<script setup>
    defineProps(['nombre', 'email', 'estado'])
</script>

<template>
    <div class="card bg-warning-subtle">
        <div class="card-body" :class="`border-${color}`">
            <h4 class="card-title">
                {{ nombre }}
            </h4>
            <p>
                <b>Email: </b>{{ email }}
            </p>
            <p class="badge bg-primary rounded-pill">
                {{ estado }}
            </p>
            <br>
            <button @click="$emit('cambiarTextoContactar', nombre)" class="btn btn-outline-success">Contactar</button>
        </div>
    </div>
</template>
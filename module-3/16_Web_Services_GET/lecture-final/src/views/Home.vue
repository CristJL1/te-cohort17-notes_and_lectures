<template>
  <boards-list />  <!-- using the BoardsList.vue component -->
</template>

<script>
import BoardsList from '@/components/BoardsList';  // Access the BoardsList.vue component

export default {
  components: {  // Tells Vue which components we are using
    BoardsList
  }
};
</script>

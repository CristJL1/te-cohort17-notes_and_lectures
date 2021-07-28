<template>
  <boards-list /> <!-- using the BoardsList.vue component-->
</template>

<script>
import BoardsList from '@/components/BoardsList'; // access the BoardsList.vue component

export default {
  components: { // tells Vue which components we are using
    BoardsList
  }
};
</script>

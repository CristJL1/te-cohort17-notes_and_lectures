<template>
  <cards-list /> <!-- use the CardList.vue component -->
</template>

<script>
import CardsList from '@/components/CardsList'; // access CardList.vue

export default {
  components: { // tell Vue which components we are using 
    CardsList 
  }
};
</script>

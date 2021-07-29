<template>
  <cards-list /> <!-- use the CardsList.vue component  -->
</template>

<script>
import CardsList from '@/components/CardsList'; // access CardList.vue code

export default {
  components: {  // tell Vue which components we are using
    CardsList
  }
};
</script>

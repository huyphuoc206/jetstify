<template>
  <v-row class="grow-column"  style="height: 110px">
   <left></left>
   <middle></middle>
   <right></right>
  </v-row>
</template>

<script>
import Left from './left.vue';
import Middle from './middle.vue';
import Right from './right.vue';
export default {
  components: {
    Left,
    Middle,
    Right
  },
  data() {
    return {
      title: "",
     
    };
  },
  
};
</script>
<style lang="scss">

</style>

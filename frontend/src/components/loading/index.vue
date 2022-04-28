<template>
  <v-overlay opacity="0.5" z-index="9999999" v-if="isShow">
    <v-progress-circular
      indeterminate
      color="primary"
      size="80"
    ></v-progress-circular>
  </v-overlay>
</template>

<script>
import { mapGetters } from "vuex";
export default {
  name: "Loading",
  computed: {
    ...mapGetters("global", ["isLoading"]),

    isShow() {
      return this.isLoading;
    },
  },
};
</script>
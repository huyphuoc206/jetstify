<template>
  <v-app-bar dark app>
    <v-toolbar-title>{{ pageTitle }}</v-toolbar-title>
    <v-btn
      color="pink"
      fab
      absolute
      dark
      top
      right
      @click="randomPageTitle"
      class="mt-7"
    >
      <v-icon>mdi-plus</v-icon>
    </v-btn>
  </v-app-bar>
</template>
<script>
import { mapGetters, mapActions } from "vuex";
export default {
  name: "AppBar",
  computed: {
    ...mapGetters("global", ["pageTitle"]),
  },
  methods: {
    ...mapActions("global", ["randomQuote"]),

    async randomPageTitle() {
      await this.randomQuote();
    },
  },
  async created() {
    await this.randomPageTitle();
  },
};
</script>

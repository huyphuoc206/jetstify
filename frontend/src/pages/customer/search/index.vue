<template>
  <v-container fluid id="search">
    <head-search></head-search>
    <artist-search></artist-search>
    <category-search></category-search>
  </v-container>
</template>

<script>
import { mapActions } from "vuex";
import CategorySearch from "./category-search.vue";
import ArtistSearch from "./artist-search.vue";
import HeadSearch from "./head-search.vue";
export default {
  name: "Search",
 
  methods: {
 
    ...mapActions("category", ["getCategoriesToClient"]),
    async listCategories() {
      await this.getCategoriesToClient();
    },
  },

  async created() {
    await this.listCategories();
  },

  components: {
    HeadSearch,
    ArtistSearch,
    CategorySearch,
  },
};
</script>

<template>
  <v-container fluid id="search">
    <head-search></head-search>
    <artist-search></artist-search>
    <album-search></album-search>
  </v-container>
</template>

<script>
import AlbumSearch from "./album-search.vue";
import ArtistSearch from "./artist-search.vue";
import HeadSearch from "./head-search.vue";
export default {
  name: "Search",

  components: {
    HeadSearch,
    ArtistSearch,
    AlbumSearch,
  },
};
</script>

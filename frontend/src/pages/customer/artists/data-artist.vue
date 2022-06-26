<template>
  <v-row>
    <v-col
      cols="12"
      sm="6"
      md="4"
      lg="2"
      v-for="(artist, index) in artists"
      :key="index"
    >
      <artist-card :artist="artist"></artist-card>
    </v-col>
  </v-row>
</template>

<script>
import ArtistCard from '@/components/customer/ArtistCard.vue';
import {  mapGetters } from "vuex";
export default {
  name: "DataArtist",
 computed: {
    ...mapGetters("artists", ["artists"]),
  },
  components: {
    ArtistCard,
  },
};
</script>

<style></style>

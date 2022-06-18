<template>
  <v-container>
    <h1 class="headline font-weight-bold">Popular</h1>
    <v-row class="mt-2" v-for="(song, index) in songs" :key="index">
      <v-col>
        <artist-song :song="song" />
      </v-col>
    </v-row>
    <v-row class="mb-2">
      <v-btn>See more</v-btn>
    </v-row>
  </v-container>
</template>

<script>
import {  mapGetters } from "vuex";
import artistSong from "./artist-song.vue";
export default {
  components: { artistSong },
  name: "SongListItem2",
  data() {
    return {};
  },
  computed: { ...mapGetters("artist", ["songs"]) },
};
</script>

<style lang="scss" scoped></style>

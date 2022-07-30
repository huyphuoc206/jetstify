<template>
  <v-container>
    <h1 class="headline font-weight-bold">Popular</h1>
    <v-row class="mt-2" v-for="(song, index) in listSong" :key="index">
      <v-col>
        <song-list-item :song="song" />
      </v-col>
    </v-row>
    <v-row class="mb-2">
      <v-btn>See more</v-btn>
    </v-row>
  </v-container>
</template>

<script>
// import { mapGetters } from "vuex";
// import artistSong from "./artist-song.vue";
import SongListItem from "./SongListItem.vue";
export default {
  components: { 
    // artistSong,
    SongListItem },
  name: "SongListItem2",
  props: ["listSong"],
  data() {
    return {};
  },

  // computed: { ...mapGetters("artist", ["songs"]) },
};
</script>

<style lang="scss" scoped></style>

<template>
  <v-container>
    <h1 class="headline font-weight-bold mt-4">Popular</h1>
    <song-list-item
      v-for="(song, index) in listSong"
      :key="index"
      :song="song"
    />
  </v-container>
</template>

<script>
import SongListItem from "./SongListItem.vue";
export default {
  components: {
    SongListItem,
  },
  name: "ArtistSongList",
  props: ["listSong"],
};
</script>

<style lang="scss" scoped></style>

<template>
  <v-row>
    <v-col cols="auto">
      <liked-songs-card></liked-songs-card>
    </v-col>
    <v-col v-for="(song, index) in allSong" :key="index" cols="6" sm="4" lg="2">
      <playlist-card :song="song"></playlist-card>
    </v-col>
  </v-row>
</template>

<script>
import PlaylistCard from "@/components/PlaylistCard.vue";
import { mapActions, mapGetters } from "vuex";
import LikedSongsCard from "./liked-songs-card.vue";
export default {
  components: { PlaylistCard, LikedSongsCard },
  methods: {
    ...mapActions("songs", ["fetchSong"]),
  },
  computed: {
    ...mapGetters("songs", ["allSong"]),
  },
  async created() {
    await this.fetchSong();
  },
};
</script>

<style></style>

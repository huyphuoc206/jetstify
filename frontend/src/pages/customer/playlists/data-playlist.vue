<template>
  <v-row>
    <!-- <v-col cols="auto">
      <liked-songs-card></liked-songs-card>
    </v-col> -->
    <v-col
      v-for="(playlist, index) in playlists"
      :key="index"
      cols="6"
      sm="4"
      lg="2"
    >
      <playlist-card :playlist="playlist"></playlist-card>
    </v-col>
  </v-row>
</template>

<script>
import PlaylistCard from "@/components/customer/PlaylistCard.vue";
// import LikedSongsCard from "./liked-songs-card.vue";
import { mapActions, mapGetters } from "vuex";

export default {
  components: { PlaylistCard, },

  computed: {
    ...mapGetters("playlists", ["playlists"]),
  },

  methods: {
    ...mapActions("playlists", ["getPlaylists"]),
  },

  async created() {
    await this.getPlaylists();
  },
};
</script>

<style></style>

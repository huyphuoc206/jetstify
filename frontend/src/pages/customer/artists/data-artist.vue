<template>
  <v-row>
    <v-col
      cols="12"
      sm="6"
      md="4"
      lg="2"
      v-for="(artist, index) in follows"
      :key="index"
    >
      <artist-card :artist="artist"></artist-card>
    </v-col>
  </v-row>
</template>

<script>
import { mapActions, mapGetters } from "vuex";
export default {
  name: "DataArtist",
  methods: {
    ...mapActions("songs", ["fetchSong"]),
  },
  computed: {
    ...mapGetters("songs", ["allSong"],
    "users", ["follows"]),
  },
  async created() {
    await this.fetchSong();
  },
  components: {
    ArtistCard: () => import("@/components/customer/ArtistCard.vue"),
  },
};
</script>

<style></style>

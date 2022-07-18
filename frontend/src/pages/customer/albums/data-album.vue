<template>
  <v-row>
    <v-col
      cols="12"
      sm="6"
      md="4"
      lg="2"
      v-for="(song, index) in allSong"
      :key="index"
    >
      <!-- <album-card :total="10" :song="song"></album-card> -->
    </v-col>
  </v-row>
</template>

<script>
import { mapActions, mapGetters } from "vuex";
export default {
  name: "DataAlbum",
  methods: {
    ...mapActions("songs", ["fetchSong"]),
  },
  computed: {
    ...mapGetters("songs", ["allSong"]),
  },
  async created() {
    await this.fetchSong();
  },

  components: {
    // AlbumCard: () => import("@/components/customer/AlbumCard.vue"),
  },
};
</script>

<style></style>

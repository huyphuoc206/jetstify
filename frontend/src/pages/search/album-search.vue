<template>
  <v-row>
    <v-col>
      <v-row class="align-start">
        <v-col>
          <h1 class="headline font-weight-bold">Genres</h1>
        </v-col>

        <v-col cols="auto">
          <v-btn small text>See all</v-btn>
        </v-col>
      </v-row>
      <v-row>
        <v-col
          cols="12"
          sm="6"
          md="4"
          lg="2"
          v-for="(song, index) in allSong"
          :key="index"
        >
          <album-card-2 :song="song"></album-card-2>
        </v-col>
      </v-row>
    </v-col>
  </v-row>
</template>

<script>
import { mapActions, mapGetters } from "vuex";
import AlbumCard2 from "@/components/AlbumCard2.vue";
export default {
  components: { AlbumCard2 },
  methods: { ...mapActions("songs", ["fetchSong"]) },
  computed: { ...mapGetters("songs", ["allSong"]) },
  async created() {
    await this.fetchSong();
  },
};
</script>

<style></style>

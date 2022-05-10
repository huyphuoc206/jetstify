<template>
  <v-row>
    <v-col>
      <v-row class="align-start">
        <v-col>
          <h1 class="headline font-weight-bold">{{ title[0].name }}</h1>
        </v-col>
      </v-row>

      <v-row>
        <v-col
          cols="12"
          sm="6"
          md="4"
          v-for="(song, index) in allSong"
          :key="index"
        >
          <album-card :song="song"></album-card>
        </v-col>
      </v-row>
    </v-col>
  </v-row>
</template>

<script>
import { mapActions, mapGetters } from "vuex";
import AlbumCard from './AlbumCard.vue';
export default {
  components: { AlbumCard },
  computed: { ...mapGetters("songs", ["allSong"]) },
  methods: {
    ...mapActions("songs", ["fetchSong"]),
    async getSong() {
      await this.fetchSong();
    },
  },
  async created() {
    await this.getSong();
  },
  data: () => ({
    title: [{ name: "Good Morning", type: "" }],
  }),
};
</script>

<style></style>

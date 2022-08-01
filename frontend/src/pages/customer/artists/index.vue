<template>
  <v-container fluid>
    <v-row>
      <v-col>
        <v-row class="align-start">
          <v-col>
            <h1 class="headline font-weight-bold">Artists Following</h1>
          </v-col>
        </v-row>
        <data-artist></data-artist>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import { mapActions } from "vuex";
import dataArtist from "./data-artist.vue";
export default {
  components: { dataArtist },
  name: "Artists",
  methods: {
    ...mapActions("artists", ["getListArtistFollow"]),
    async listFollowArtist() {
      await this.getListArtistFollow();
    },
  },
  async created() {
    await this.listFollowArtist();
  },
};
</script>

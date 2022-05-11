<template>
  <v-row>
    <v-col>
      <v-row class="align-start">
        <v-col>
          <h1 class="headline font-weight-bold">Artist</h1>
          <p class="body-2">Inspired by your recent activity.</p>
        </v-col>

        <v-col cols="auto">
          <v-btn small text>See all</v-btn>
        </v-col>
      </v-row>
      <v-row>
        <v-col cols="12" sm="6" md="4" lg="2" v-for="i of 6" :key="i">
          <artist-card :song="i"></artist-card>
        </v-col>
      </v-row>
    </v-col>
  </v-row>
</template>

<script>
import ArtistCard from '@/components/customer/ArtistCard.vue';
import { mapActions, mapGetters } from "vuex";
export default {
  components: { ArtistCard },
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
};
</script>

<style></style>

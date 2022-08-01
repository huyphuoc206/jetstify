<template>
  <v-row v-if="results.length > 0">
    <v-col>
      <v-row class="align-start">
        <v-col>
          <h1 class="headline font-weight-bold">Artists</h1>
        </v-col>
      </v-row>
      <v-row>
        <v-col
          cols="12"
          sm="6"
          md="4"
          lg="2"
          v-for="(artist, index) in results"
          :key="index"
        >
          <artist-card :artist="artist"></artist-card>
        </v-col>
      </v-row>
    </v-col>
  </v-row>
</template>

<script>
import ArtistCard from "@/components/customer/ArtistCard.vue";
import { mapGetters } from "vuex";
export default {
  components: { ArtistCard },
  methods: {},
  computed: {
    ...mapGetters("search", ["dataSearch"]),
    results() {
      if (!this.dataSearch["artistResponseList"]) return [];
      return this.dataSearch["artistResponseList"].slice(0, 6);
    },
  },
};
</script>

<style></style>

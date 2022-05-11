<template>
  <div>
    <v-row v-for="type of types" :key="type.name">
      <v-col>
        <v-row class="align-start">
          <v-col>
            <h1 class="headline font-weight-bold">{{ type.name }}</h1>
            <p class="body-2">Inspired by your recent activity.</p>
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
  </div>
</template>

<script>
import AlbumCard2 from "@/components/customer/AlbumCard2.vue";
import { mapActions, mapGetters } from "vuex";
export default {
  components: { AlbumCard2 },
  data: () => ({
    types: [
      { name: "Your shows", type: "" },
      { name: "Made For", type: "" },
      { name: "Recently played", type: "" },
      { name: "Your top mixes", type: "" },
      { name: "Select of Jetstify", type: "" },
    ],
  }),
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

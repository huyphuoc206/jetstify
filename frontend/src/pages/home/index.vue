<template>
  <div class="ml-10 mr-10 mt-5">
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
    <v-row>
      <v-col>
        <v-row class="align-start">
          <v-col>
            <h1 class="headline font-weight-bold">Podcast</h1>
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
            <podcast-card :song="song"></podcast-card>
          </v-col>
        </v-row>
      </v-col>
    </v-row>
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
import { mapActions, mapGetters } from "vuex";

export default {
  name: "Featured",
  data: () => ({
    title: [{ name: "Good Morning", type: "" }],
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
  components: {
    PodcastCard: () => import("@/components/PodcastCart.vue"),
    AlbumCard: () => import("@/pages/home/AlbumCard.vue"),
    AlbumCard2: () => import("@/components/AlbumCard2.vue"),
    ArtistCard: () => import("@/components/ArtistCard.vue"),
  },
};
</script>

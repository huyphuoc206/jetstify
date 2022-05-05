<template>
  <v-container fluid id="search">
    <!-- <v-row>
      <v-col class="py-0" cols="12" sm="8" md="6">
        <v-text-field
          clearable
          filled
          hide-details
          label="Search for Artists, songs, or podcasts"
          prepend-inner-icon="mdi-magnify"
          rounded
        ></v-text-field>
      </v-col>
    </v-row> -->

    <v-row>
      <v-col>
        <v-row class="align-start">
          <v-col sm="4">
            <v-row>
              <v-col>
                <h1 class="headline font-weight-bold">Top result</h1></v-col
              >
            </v-row>
            <v-col> <result-card></result-card></v-col>
          </v-col>

          <v-col>
            <v-row>
              <v-col>
                <h1 class="headline font-weight-bold">Songs</h1>
              </v-col>
              <v-col cols="auto">
                <v-btn small text>See all</v-btn>
              </v-col>
            </v-row>
            <v-col>
              <v-list class="pa-0">
                <song-list-item v-for="i in 4" :key="i"></song-list-item>
              </v-list>
            </v-col>
          </v-col>
        </v-row>
      </v-col>
    </v-row>

    <v-row>
      <v-col>
        <v-row class="align-start">
          <v-col>
            <h1 class="headline font-weight-bold">Artists</h1>
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
            <artist-card :song="song"></artist-card>
          </v-col>
        </v-row>
      </v-col>
    </v-row>

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
            <genre-card :song="song"></genre-card>
          </v-col>
        </v-row>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import { mapActions, mapGetters } from "vuex";
export default {
  name: "Search",
  methods: { ...mapActions("songs", ["fetchSong"]) },
  computed: { ...mapGetters("songs", ["allSong"]) },
  async created() {
    await this.fetchSong();
  },
  components: {
    ArtistCard: () => import("@/components/ArtistCard.vue"),
    GenreCard: () => import("@/components/GenreCard.vue"),
    SongListItem: () => import("@/components/SongListItem.vue"),
    ResultCard: () => import("@/components/ResultCard.vue"),
  },
};
</script>

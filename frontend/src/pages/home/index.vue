<template>
  <div class="ml-10 mr-10 mt-5">
    <v-row>
      <v-col>
        <v-row class="align-start">
          <v-col>
            <h1 class="headline font-weight-bold">{{ title[0].name }}</h1>
          </v-col>
        </v-row>

        <album-card></album-card>
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

        <artist-card></artist-card>
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

        <podcast-card></podcast-card>
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

        <album-card-2></album-card-2>
      </v-col>
    </v-row>
  </div>
</template>

<script>
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
  components: {
    PodcastCard:()=>import("@/components/PodcastCart.vue"),
    AlbumCard: () => import("@/components/AlbumCard.vue"),
    AlbumCard2: () => import("@/components/AlbumCard2.vue"),
    ArtistCard: () => import("@/components/ArtistCard.vue"),
  },
};
</script>

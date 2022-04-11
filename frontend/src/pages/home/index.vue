<template>
  <div class="ml-10 mt-5">
    <v-row>
      <v-col>
        <v-row class="align-start">
          <v-col>
            <h1 class="headline font-weight-bold">{{ title[0].name }}</h1>
          </v-col>
        </v-row>

        <album-card-list></album-card-list>
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

        <album-card></album-card>
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
    AlbumCard: () => import("@/components/AlbumCard.vue"),
  },
};
</script>

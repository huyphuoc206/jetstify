<template>
  <div>
    <v-row>
      <v-col>
        <v-row class="align-start">
          <v-col>
            <h1 class="headline font-weight-bold">New releases for you</h1>
            <p class="body-2">Brand new music from artists you love.</p>
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
            v-for="(song, index) in []"
            :key="index"
          >
            <album-card-2 :song="song"></album-card-2>
          </v-col>
        </v-row>
      </v-col>
    </v-row>

    <v-row>
      <v-col>
        <v-row class="align-start">
          <v-col>
            <h1 class="headline font-weight-bold">
              Similar to Vancouver Sleep Clinic
            </h1>
          </v-col>

          <v-col cols="auto">
            <v-btn small text>See all</v-btn>
          </v-col>
          <v-row>
            <v-col
              cols="12"
              sm="6"
              md="4"
              lg="2"
              v-for="(song, index) in []"
              :key="index"
            >
              <album-card-2 :song="song"></album-card-2>
            </v-col>
          </v-row>
        </v-row>
      </v-col>
    </v-row>
  </div>
</template>

<script>
export default {
  name: "Discover",

  async created() {

  },
  components: {
    AlbumCard2: () => import("@/components/AlbumCard2.vue"),
  },
};
</script>

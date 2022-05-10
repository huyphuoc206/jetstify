<template>
  <div>
    <v-row>
      <v-col>
        <v-row class="align-start">
          <v-col>
            <h1 class="headline font-weight-bold">Genres & Moods</h1>
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
            <genre-card :total="10" :song="song"></genre-card>
          </v-col>
        </v-row>
      </v-col>
    </v-row>
  </div>
</template>

<script>

export default {
  name: "Genres",

  async created() {

  },

  components: {
    GenreCard: () => import("@/components/GenreCard.vue"),
  },
};
</script>

<template>
  <div>
    <v-row>
      <v-col>
        <v-row class="align-start">
          <v-col>
            <h1 class="headline font-weight-bold">Genres & Moods</h1>
          </v-col>
        </v-row>

        <genre-card :total="10"></genre-card>
      </v-col>
    </v-row>
  </div>
</template>

<script>
export default {
  name: "Genres",

  components: {
    GenreCard: () => import("@/components/GenreCard.vue")
  }
};
</script>

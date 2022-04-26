<template>
  <v-container>
    <h1 class="headline font-weight-bold">Popular</h1>
    <v-row class="mt-2" v-for="i in 5" :key="i">
      <v-col>
        <artist-song />
      </v-col>
    </v-row>
    <v-row class="mb-2">
      <v-btn>See more</v-btn>
    </v-row>
  </v-container>
</template>

<script>
import artistSong from "./artist-song.vue";
export default {
  components: { artistSong },
  name: "SongListItem2",
};
</script>

<style lang="scss" scoped></style>

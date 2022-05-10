<template>
  <v-container fluid>
    <v-row>
      <v-col>
        <v-row class="align-start">
          <v-col>
            <h1 class="headline font-weight-bold">Artists</h1>
          </v-col>
        </v-row>
        <data-artist></data-artist>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import dataArtist from "./data-artist.vue";
export default {
  components: { dataArtist },
  name: "Artists",
};
</script>

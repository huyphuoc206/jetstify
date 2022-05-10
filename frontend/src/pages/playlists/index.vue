<template>
  <v-container fluid>
    <v-row>
      <v-col>
        <v-row>
          <v-col>
            <h1 class="headline font-weight-bold">Playlists</h1>
          </v-col>
        </v-row>
        <data-playlist></data-playlist>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import dataPlaylist from "./data-playlist.vue";

export default {
  components: { dataPlaylist },
  name: "Artists",
};
</script>

<style></style>

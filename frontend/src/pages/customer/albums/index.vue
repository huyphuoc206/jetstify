<template>
    <v-container fluid>
    <v-row>
      <v-col>
        <v-row class="align-start">
          <v-col>
            <h1 class="headline font-weight-bold">Albums</h1>
          </v-col>
        </v-row>
       <data-album></data-album>
      </v-col>
    </v-row>
    </v-container>
</template>

<script>
import DataAlbum from './data-album.vue';
export default {
  components: { DataAlbum },
  name: "Albums",
 
};
</script>

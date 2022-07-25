<template>
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
          <!-- <v-col
            cols="12"
            sm="6"
            md="4"
            lg="2"
            v-for="(song, index) in allSong"
            :key="index"
          >
            <artist-card :song="song"></artist-card>
          </v-col> -->
        </v-row>
      </v-col>
    </v-row>
</template>

<script>
// import ArtistCard from '@/components/customer/ArtistCard.vue'
export default {
  // components: { ArtistCard },
  
}
</script>

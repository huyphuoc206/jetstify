<template>
  <div>
    <v-row>
      <v-col>
        <v-row class="align-start">
          <v-col>
            <h1 class="headline font-weight-bold">Popular</h1>
          </v-col>
        </v-row>

         <song-list-item-2 v-for="i in 5" :key="i"></song-list-item-2>
      </v-col>
    </v-row>

    <v-row>
      <v-col>
        <v-row class="align-start">
          <v-col>
            <h1 class="headline font-weight-bold">Albums</h1>
          </v-col>
        </v-row>

        <album-card-2></album-card-2>
      </v-col>
    </v-row>
  </div>
</template>

<script>
export default {
  name: "AlbumOverview",

  components: {
    AlbumCard2: () => import("@/components/AlbumCard2.vue"),
    SongListItem2: () => import("@/components/SongListItem2.vue")
  }
};
</script>

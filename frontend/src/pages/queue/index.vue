<template>
  <v-container id="playlist" fluid>
    <v-row>
      <v-col>
        <h1>Play Queue</h1>

        <v-subheader>ACTUAL</v-subheader>

        <song-list :total="1"></song-list>

        <v-list style="background: none">
          <v-subheader>NEXT</v-subheader>

          <song-list-item v-for="i in 5" :key="i"></song-list-item>
        </v-list>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: "Queue",

  components: {
    SongListItem: () => import("@/components/SongListItem.vue")
  }
};
</script>

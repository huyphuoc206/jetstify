<template>
  <v-container id="playlist" fluid>
    <v-row>
      <v-col>
        <h1>Queue</h1>

        <div>
          <v-subheader>Now playing</v-subheader>
          <song-list-item v-for="i in 1" :key="i"></song-list-item>
        </div>

        <div>
          <v-subheader>Next</v-subheader>
          <song-list-item v-for="i in 5" :key="i"></song-list-item>
        </div>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import SongListItem from "@/components/customer/SongListItem.vue";
export default {
  name: "Queue",
  components: {
    SongListItem,
  },
};
</script>

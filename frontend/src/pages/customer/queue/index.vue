<template>
  <v-container id="playlist" fluid>
    <v-row>
      <v-col>
        <h1>Queue</h1>

        <div v-if="currentSongArr.length > 0">
          <v-subheader>Now playing</v-subheader>
          <song-list-item
            v-for="song in currentSongArr"
            :key="song.songId"
            :song="song"
            type="Q"
          ></song-list-item>
        </div>

        <div v-if="songsWithoutCurrent.length > 0">
          <v-subheader>Next</v-subheader>
          <song-list-item
            v-for="song in songsWithoutCurrent"
            :key="song.songId"
            :song="song"
            type="Q"
          ></song-list-item>
        </div>

        <div v-if="isEmptyQueue">
          <v-subheader><h3>No songs in your queue</h3> </v-subheader>
        </div>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import SongListItem from "@/components/customer/SongListItem.vue";
import { mapGetters } from "vuex";
import _ from "lodash";
export default {
  name: "Queue",
  components: {
    SongListItem,
  },

  computed: {
    ...mapGetters("player", ["songs", "currentSong"]),
    songsWithoutCurrent() {
      return this.songs.filter(
        (song) => song.songId !== this.currentSong.songId
      );
    },

    currentSongArr() {
      return _.isEmpty(this.currentSong) ? [] : [this.currentSong];
    },

    isEmptyQueue() {
      return (
        this.songsWithoutCurrent.length === 0 &&
        this.currentSongArr.length === 0
      );
    },
  },
};
</script>

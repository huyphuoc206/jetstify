<template>
  <v-hover v-slot:default="{ hover }">
    <v-card class="common-card" flat height="250" width="180">
      <v-card-text>
        <v-img
          :style="{
            borderRadius: '5px',
          }"
          width="250"
          height="150"
          class="elevation-3"
          :src="song.thumbnail"
        >
          <div
            :style="{
              position: 'absolute',
              right: '1px',
              bottom: '1px',
              cursor: 'auto',
            }"
            v-show="hover"
          >
            <v-icon
              v-if="isPlaying && currentSongId === song.songId"
              style="cursor: pointer"
              color="green"
              size="50"
              @click="handlePauseSong"
              >mdi-pause-circle</v-icon
            >
            <v-icon
              v-else
              style="cursor: pointer"
              color="green"
              size="50"
              @click="handlePlaySong"
              >mdi-play-circle</v-icon
            >
          </div>
        </v-img>
      </v-card-text>

      <v-card-text class="pt-0 ma-auto">
        <p class="body-2 font-weight-medium ma-0 text-truncate white--text">
          {{ song.name }}
        </p>
        <p class="caption font-weight-light mb-4 text-truncate">
          <!-- {{ song.artist }} -->
        </p>
      </v-card-text>
    </v-card>
  </v-hover>
</template>

<script>
import { mapGetters, mapActions } from "vuex";
export default {
  props: ["song"],
  data: () => ({}),
  name: "AlbumCard2",
  computed: {
    ...mapGetters("global", ["isPlaying", "currentSongId"]),
  },
  methods: {
    ...mapActions("global", ["setPlaying"]),
    handlePlaySong() {
      this.$root.$emit("playAudio", this.song);
      this.setPlaying({
        isPlaying: true,
        songId: this.song ? this.song.songId : null,
      });
    },
    handlePauseSong() {
      this.$root.$emit("pauseAudio");
      this.setPlaying({
        isPlaying: false,
        songId: null,
      });
    },
  },
};
</script>
<style lang="scss"></style>

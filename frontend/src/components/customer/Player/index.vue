<template>
  <v-row class="grow-column" style="height: 110px">
    <v-col class="py-0" cols="4" sm="4">
      <v-row v-if="canPlay" class="align-center" style="height: 100%">
        <v-col cols="auto">
          <v-avatar class="elevation-10 mt-5" size="70">
            <img
              :class="{['rotate-img']: isPlaying}"
              :src="currentSong.thumbnail"
              alt=""
            />
          </v-avatar>
        </v-col>
        <v-col class="pl-1 text-truncate mt-5">
          <span class="body-2 font-weight-medium ma-0 link_text white--text">
            {{ currentSong.name || "" }}
          </span>
          <br />
          <span class="caption font-weight-light">
            <router-link
              class="ma-0 link_text lime--text"
              :to="{
                name: 'Artist',
                params: {
                  id: 1,
                },
              }"
            >
              {{currentSong.nameArtist}}
            </router-link>
          </span>
        </v-col>
        <!-- <v-col class="mt-4">
          <v-btn icon>
            <v-icon>mdi-heart-outline</v-icon>
          </v-btn>
        </v-col> -->
      </v-row>
    </v-col>
    <v-col cols="6" sm="4">
      <audio-player
        ref="audioPlayer"
        :theme-color="'#00000'"
        :audio-list="audioList"
        :before-play="handleBeforePlay"
        :before-prev="handleBeforePrev"
        :before-next="handleBeforeNext"
        @pause="handlePause"
        @play-error="handlePlayError"
      />
    </v-col>
    <v-col class="d-flex justify-end align-center">
      <v-tooltip left>
        <template v-slot:activator="{ on, attrs }">
          <v-btn v-bind="attrs" v-on="on" :to="{ name: 'Queue' }" icon>
            <v-icon>mdi-playlist-play</v-icon>
          </v-btn>
        </template>

        <span>Go to Queue</span>
      </v-tooltip>
    </v-col>
  </v-row>
</template>

<script>
import AudioPlayer from "@liripeng/vue-audio-player";
import { mapGetters, mapActions } from "vuex";
import _ from "lodash";
export default {
  components: {
    AudioPlayer,
  },
  computed: {
    ...mapGetters("player", ["songs", "currentSong", "isPlaying"]),
    canPlay() {
      return this.songs && this.songs.length > 0;
    },
    audioList() {
      return this.songs.map((song) => song.link);
    },
  },
  data() {
    return {};
  },

  methods: {
    ...mapActions("player", ["setPlaying", "nextPrevSong"]),

    handleBeforePlay(next) {
      if (_.isEmpty(this.currentSong)) {
        this.$notice.warning("Please select a song to play");
        return;
      }
      this.setPlaying(true);
      next();
    },

    handleBeforePrev(next) {
      this.nextPrevSong(false);
      this.setPlaying(true);
      next();
    },

    handleBeforeNext(next) {
      this.nextPrevSong(true);
      this.setPlaying(true);
      next();
    },

    handlePause() {
      this.setPlaying(false);
    },

    handlePlayError() {
      this.$notice.warning("Something went wrong");
    },
  },

  mounted() {
    this.$root.$on("playAudio", () => {
      setTimeout(() => this.$refs.audioPlayer.play());
    });

    this.$root.$on("pauseAudio", () => {
      setTimeout(() => this.$refs.audioPlayer.pause());
    });
  },
};
</script>

<style lang="scss" scoped>
.link_text {
  text-decoration: none;
}
</style>

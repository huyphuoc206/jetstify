<template>
  <v-row class="grow-column" style="height: 110px">
    <v-col class="py-0" cols="4" sm="4">
      <v-row v-if="canPlay" class="align-center" style="height: 100%">
        <v-col cols="auto">
          <v-img
            class="elevation-10 mt-5"
            :src="thumbnail"
            width="60"
            height="60"
          ></v-img>
        </v-col>
        <v-col class="pl-1 text-truncate mt-5">
          <span class="body-2 font-weight-medium ma-0 link_text white--text">
            {{ name || "" }}
          </span>
          <br />
          <!-- <span class="caption font-weight-light">
            <router-link
              class="ma-0 link_text lime--text"
              :to="{
                name: 'Artist',
                params: {
                  id: 1,
                },
              }"
            >
              Scarlett Johansson
            </router-link>
          </span> -->
        </v-col>
        <v-col class="mt-4">
          <v-btn icon>
            <v-icon>mdi-heart-outline</v-icon>
          </v-btn>
        </v-col>
      </v-row>
    </v-col>
    <v-col cols="6" sm="4">
      <audio-player
        :key="songId"
        ref="audioPlayer"
        :theme-color="'#00000'"
        :audio-list="audioList"
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
export default {
  components: {
    AudioPlayer,
  },
  computed: {
    canPlay() {
      return this.audioList && this.audioList.length > 0;
    },
  },
  data() {
    return {
      audioList: [],
      name: "",
      thumbnail: "",
      songId: null,
    };
  },

  mounted() {
    this.$root.$on("playAudio", (song) => {
      this.audioList = [song.link];
      this.name = song.name;
      this.thumbnail = song.thumbnail;
      this.songId = song.songId;
      setTimeout(() => this.$refs.audioPlayer.play());
    });

    this.$root.$on("pauseAudio", () => {
      setTimeout(() => this.$refs.audioPlayer.pause());
    });
  },
  methods: {},
};
</script>

<style lang="scss" scoped>
.link_text {
  text-decoration: none;
}
</style>

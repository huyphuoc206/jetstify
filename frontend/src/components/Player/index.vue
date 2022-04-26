<template>
  <v-row class="grow-column">
    <v-col class="py-0" cols="4" sm="4">
      <v-row class="align-center" style="height: 150px">
        <v-col cols="auto">
          <v-img
            class="elevation-10"
            src="https://i.pinimg.com/736x/58/ff/a6/58ffa6ad3cf14f853068dce774329839.jpg"
            width="56"
            height="56"
          ></v-img>
        </v-col>
        <v-col class="pl-1 text-truncate">
          <span>
            <router-link
              class="body-2 font-weight-medium ma-0 link_text white--text"
              :to="{
                name: 'Album',
                params: {
                  id: 1,
                },
              }"
            >
              The Moon Song - Film Version
            </router-link>
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
              Scarlett Johansson </router-link
            >
            <!-- Option if song have 2 singer should 2 link singer -->
          </span>
        </v-col>
        <v-col cols="">
          <v-btn icon>
            <v-icon>mdi-heart-outline</v-icon>
          </v-btn>
        </v-col>
      </v-row>
    </v-col>
    <!-- player -->
    <v-col class="mt-3 align-center" cols="4" sm="4">
      <audio-player
        :style="{
          width: '100%',
        }"
        ref="audioPlayer"
        :theme-color="'#00000'"
        :audio-list="audioList.map((elm) => elm.url)"
        :before-play="handleBeforePlay"
      />
    </v-col>
    <!-- end player -->
    <v-col class="d-flex justify-end align-center" cols="4" sm="4">
      <v-btn :to="{ name: 'Queue' }" icon>
        <v-icon>mdi-playlist-play</v-icon>
      </v-btn>
    </v-col>
  </v-row>
</template>

<script>
import AudioPlayer from "@liripeng/vue-audio-player";
export default {
  name: "AppPlayer",
  components: {
    AudioPlayer,
  },
  data() {
    return {
      title: "",
      audioList: [
        {
          name: "audio 1",
          url: "https://open.spotify.com/track/5QO79kh1waicV47BqGRL3g?si=e31931fbecec4ac1",
        },
        {
          name: "audio 2",
          url: "https://open.spotify.com/track/5QO79kh1waicV47BqGRL3g?si=e31931fbecec4ac1",
        },
      ],
    };
  },
  mounted() {
    this.title = this.audioList[0].name;
    this.$refs.audioPlayer.play();
  },
  methods: {
    // Use this function if you want to do something before you start playing
    handleBeforePlay(next) {
      this.title = this.audioList[this.$refs.audioPlayer.currentPlayIndex].name;

      next(); // Start play
    },
  },
};
</script>
<style lang="scss">
.link_text {
  text-decoration: none;
}
</style>

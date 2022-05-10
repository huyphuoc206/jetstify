<template>
  <v-col
    cols="6"
    sm="4"
    :style="{
    }"
  >
    <audio-player
  
      
      ref="audioPlayer"
      :theme-color="'#00000'"
      :audio-list="audioList.map((elm) => elm.url)"
      :before-play="handleBeforePlay"
    />
  </v-col>
</template>

<script>
import AudioPlayer from "@liripeng/vue-audio-player";
export default {
  name: "Middle",
  components: {
    AudioPlayer,
  },
  data() {
    return {
      audioList: [
        {
          name: "audio 1",
          url: "http://www.ytmp3.cn/down/76865.mp3",
        },
        {
          name: "audio 2",
          url: "http://www.ytmp3.cn/down/76857.mp3",
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

<style></style>

<template>
  <div>
    <v-card-title class="text-h5 font-weight-black">All episode</v-card-title>
    <v-container>
      <v-row class="mt-2" v-for="episode in episodeList" :key="episode.id">
        <podcast-episode :episode="episode" />
      </v-row>
    </v-container>
  </div>
</template>

<script>
import podcastEpisode from "./podcast-episode.vue";
export default {
  props: ["episodeList"],
  components: { podcastEpisode },
  name: "PodcastEpisodeList",
};
</script>

<style lang="scss" scoped>
.contentAbout {
  color: #b3b3b3;
}
</style>

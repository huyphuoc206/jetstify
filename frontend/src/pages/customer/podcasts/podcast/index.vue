<template>
  <div>
    <podcast-info />
    <div class="body">
      <podcast-service />
      <v-container>
        <v-row>
          <v-col class="left">
            <podcast-episode-list />
          </v-col>

          <v-col class="right">
            <podcast-about  />
          </v-col>
        </v-row>
      </v-container>
    </div>
  </div>
</template>

<script>
import { mapActions } from 'vuex';
import PodcastAbout from "./components/podcast-about.vue";
import PodcastEpisodeList from "./components/podcast-episode-list.vue";
import PodcastInfo from "./components/podcast-info.vue";
import PodcastService from "./components/podcast-service.vue";
export default {
  name: "Podcast",
  components: {
    PodcastInfo,
    PodcastService,
    PodcastAbout,
    PodcastEpisodeList,
  },

  methods: {
    ...mapActions("podcast", ["getPodcastDetail"]),

  },
  async created() {
    const podcastId = this.$route.params.id;
    await this.getPodcastDetail(podcastId);
  },
};
</script>

<style lang="scss" scoped>
.body {
  background: rgb(205, 202, 207);
  background: linear-gradient(
    180deg,
    rgba(205, 202, 207, 0.9836309523809523) 0%,
    rgba(18, 18, 18, 1) 40%
  );

  .left {
    flex: 1 1 0;
  }

  .right {
    flex: none;
    width: 300px;
  }
}
</style>

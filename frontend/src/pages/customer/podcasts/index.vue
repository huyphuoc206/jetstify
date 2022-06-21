<template>
  <v-container fluid>
    <v-row>
      <v-col>
        <v-row>
          <v-col>
            <h1 class="headline font-weight-bold">Podcasts</h1>
          </v-col>
        </v-row>
        <data-podcast></data-podcast>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import { mapActions } from 'vuex';
import DataPodcast from './data-podcast.vue';

export default {
  components: { DataPodcast },
  name: "Artists",
   methods: {
    ...mapActions("users", ["getListPodcastFollow"]),
    async listFollowPodcast(){
      await this.getListPodcastFollow();
    }
  },
  async created() {
    await this.listFollowPodcast();
  },
};
</script>

<style></style>

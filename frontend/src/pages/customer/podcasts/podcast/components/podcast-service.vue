<template>
  <v-container>
    
    <v-btn
      v-if="!!podcastInfo.followId"
      class="ml-3 btn"
      text
      depressed
      @click="unFollow()"
    >
      unFollow
    </v-btn>
    <v-btn
      v-else
      class="ml-3 btn"
      text
      depressed
      @click="follow()"
    >
      Follow
    </v-btn>

    <v-menu min-width="200px" transition="slide-y-transition" offset-y>
      <template v-slot:activator="{ on, attrs }">
        <v-btn class="ml-3 btn" text dark v-bind="attrs" v-on="on"> ... </v-btn>
      </template>

      <v-list>
        <v-list-item v-for="(item, i) in items" :key="i">
          <v-list-item-title>{{ item.name }}</v-list-item-title>
        </v-list-item>
      </v-list>
    </v-menu>
  </v-container>
</template>

<script>
import { mapActions, mapGetters } from "vuex";
export default {
  name: "PodcastService",
  data: () => ({
    items: [
      { name: "Follow", type: "" },
      { name: "Share", type: "" },
    ],
  }),
  computed: {
    ...mapGetters("podcast", ["podcastInfo"]),
  },
  methods: {
    ...mapActions("podcast", ["followPodcast", "unFollowPodcast"]),
    async follow() {
      await this.followPodcast();
  
    },
    
    async unFollow(followId) {
      await this.unFollowPodcast(followId);
    },
  },
  async created() {
    // const podcastId = this.$route.params.id;
  },
};
</script>

<style lang="scss">
.btn {
  border-style: solid;
  border-color: white;
}
</style>

<template>
  <div class="ml-10 mr-10 mt-10 mb-10">
    <!-- <user-start></user-start>
  <artist-home></artist-home>
  <podcast-home></podcast-home> -->
<data-home></data-home>
  </div>
</template>

<script>
import { mapActions } from "vuex";
// import ArtistHome from './artist-home.vue';
// import UserStart from './user-start.vue';
// import PodcastHome from './podcast-home.vue';
import DataHome from './data-home.vue';

export default {
  name: "Featured",
  data: () => ({
    title: [{ name: "Good Morning", type: "" }],
    types: [
      { name: "Your shows", type: "" },
      { name: "Made For", type: "" },
      { name: "Recently played", type: "" },
      { name: "Your top mixes", type: "" },
      { name: "Select of Jetstify", type: "" },
    ],
  }),
  
  methods: {
    ...mapActions("home", ["getDataHome"]),
    async getHome() {
      await this.getDataHome();
    },
  },
  async created() {
    await this.getHome();
  },
  components: {
    // UserStart,
    // ArtistHome,
    // PodcastHome,
    DataHome,
  },
};
</script>

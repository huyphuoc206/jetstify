<template>
  <v-container id="album" fluid>
    <v-row>
      <left></left>
      <right></right>
    </v-row>
  </v-container>
</template>

<script>
import { mapActions } from 'vuex';
import Left from "./left.vue";
import Right from './right.vue';
export default {
  name: "Album",

  components: { Left, Right },
  data: () => ({
    songs: [
      "Intro",
      "Frozn Lake",
      "Kill Me Twice",
      "Say We Are",
      "Bubbles of Soap",
      "Little Girl",
    ],
  }),
  methods:{
     ...mapActions("category", ["getSongByCategory"]),
    async listSongByCategory(categoryId) {
      await this.getSongByCategory(categoryId);
    },
  },
    async created() {
      const categoryId = this.$route.params.id;
    await this.listSongByCategory(categoryId);
  },
};
</script>

<template>
  <v-container fluid>
    <v-row>
      <v-col>
        <v-row>
          <v-col>
            <h1 class="headline font-weight-bold">{{categoryName}}</h1>
          </v-col>
        </v-row>
        <data-playlist></data-playlist>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import { mapActions } from "vuex";
import dataPlaylist from "./data-category.vue";

export default {
  components: { dataPlaylist },
  props:["categoryName"],
  name: "Artists",
  methods: {
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

<style></style>

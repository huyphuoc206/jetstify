<template>
  <div class="d-flex" @click="goDetail()">
    <v-list-item-icon>
      <v-icon class="item__list" color="grey">{{ item.icon }}</v-icon>
    </v-list-item-icon>

    <v-list-item-content class="item__list-content">
      <v-list-item-title class="item__list">{{
        item.namePlaylist
      }}</v-list-item-title>
    </v-list-item-content>
  </div>
</template>

<script>
import { mapActions } from "vuex";
export default {
  props: ["item"],

  methods: {
    ...mapActions("playlist", ["getPlaylistById"]),
    goDetail() {
      this.getPlaylistById(this.item.idPlaylist);
      const path = `/playlist/${this.item.idPlaylist}`;
      if (this.$route.path !== path) this.$router.push(path);
    },
  },
  created() {
    this.goDetail();
  },
};
</script>

<style></style>

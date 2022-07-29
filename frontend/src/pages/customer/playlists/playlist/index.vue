<template>
  <div>
    <playlist-info />
    <playlist-service />
    <playlist-edit-form />
  </div>
</template>
<script>
import { mapActions } from "vuex";
import PlaylistEditForm from "./playlist-edit-form.vue";
import PlaylistInfo from "./playlist-info.vue";
import PlaylistService from "./playlist-service.vue";
export default {
  name: "Playlist",
  components: {
    PlaylistService,
    PlaylistInfo,
    PlaylistEditForm,
  },

  methods: {
    ...mapActions("playlist", ["getPlaylistById"]),
    async playlistById(playlistId) {
      await this.getPlaylistById(playlistId);
    },
  },

  async created() {
    const playlistId = this.$route.params.id;
    await this.playlistById(playlistId);
  },
};
</script>
<style lang="scss" scoped></style>

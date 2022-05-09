<template>
  <div>
    <playlist-info/>
    <playlist-service />
  </div>
</template>
<script>
import PlaylistInfo from './playlist-info.vue';
import PlaylistService from "./playlist-service.vue";
export default {
  name: "Playlist",
  components: {
    PlaylistService,
    PlaylistInfo,
  },
};
</script>
<style lang="scss" scoped>

</style>

<template>
  <div>
    <artis-setting-info />
    <artist-setting-service />
    <artist-seting-form />
    <artist-setting-create-song />
  </div>
</template>
<script>
import ArtistSetingForm from "./components/artist-setting-edit-form.vue";
import ArtisSettingInfo from "./components/artist-setting-info.vue";
import ArtistSettingService from "./components/artist-setting-service.vue";
import ArtistSettingCreateSong from "./components/artist-setting-create-song.vue";
export default {
  name: "Playlist",
  components: {
    ArtisSettingInfo,
    ArtistSettingService,
    ArtistSetingForm,
    ArtistSettingCreateSong,
  },
};
</script>
<style lang="scss" scoped></style>

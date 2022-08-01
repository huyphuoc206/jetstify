<template>
  <div>
    <artis-setting-info />
    <artist-setting-service />
    <artist-seting-form />
    <artist-setting-create-song />
    <artist-song-list :listSong="listSong" />
  </div>
</template>
<script>
import ArtistSetingForm from "./components/artist-setting-edit-form.vue";
import ArtisSettingInfo from "./components/artist-setting-info.vue";
import ArtistSettingService from "./components/artist-setting-service.vue";
import ArtistSettingCreateSong from "./components/artist-setting-create-song.vue";
import ArtistSongList from "@/components/customer/artist-song-list.vue";
import { mapActions, mapGetters } from "vuex";
export default {
  name: "Playlist",
  components: {
    ArtisSettingInfo,
    ArtistSettingService,
    ArtistSetingForm,
    ArtistSettingCreateSong,
    ArtistSongList,
  },

  // data: () => ({
  //   songs: [],
  // }),

  computed: {
    ...mapGetters("artistSetting", ["artistInfo"]),

    listSong: {
      get() {
        return this.artistInfo.songResponseList;
      },
    },
  },

  methods: {
    ...mapActions("artistSetting", ["getInfoArtist"]),
  },

  async created() {
    await this.getInfoArtist();
  },
};
</script>
<style lang="scss" scoped></style>

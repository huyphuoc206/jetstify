<template>
  <div>
    <artist-info />
    <artist-service />
    <artist-song-list :listSong="songs" />
    <!-- <album-card-2 /> -->
    <artist-about />
  </div>
</template>

<script>
// import AlbumCard2 from "@/components/customer/AlbumCard2.vue";
import ArtistAbout from "./components/artist-about.vue";
import ArtistInfo from "./components/artist-info.vue";
import ArtistService from "./components/artist-service.vue";
import ArtistSongList from "../../../../components/customer/artist-song-list.vue";
import { mapActions, mapGetters } from "vuex";
export default {
  name: "artist",
  components: {
    ArtistAbout,
    ArtistService,
    ArtistInfo,
    ArtistSongList,
    // AlbumCard2,
  },

  computed: {
    ...mapGetters("artist", ["songs"]),
  },

  methods: {
    ...mapActions("artist", ["getArtist", "getPhotos", "getSongs"]),
    async getSong(artistId) {
      await this.getSongs(artistId);
    },
    async loadArtist(artistId) {
      await this.getArtist(artistId);
    },
    async loadPhoto(artistId) {
      await this.getPhotos(artistId);
    },
  },
  async created() {
    const artistId = this.$route.params.id;
    await this.getSong(artistId);
    await this.loadArtist(artistId);
    await this.loadPhoto(artistId);
  },
};
</script>

<style lang="scss" scoped></style>

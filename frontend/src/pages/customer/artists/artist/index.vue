<template>
  <div>
    <artist-info />
    <artist-service />
    <artist-song-list />
    <album-card-2 />
    <artist-about/>
  </div> 
</template>

<script>
import AlbumCard2 from "@/components/customer/AlbumCard2.vue";
import ArtistAbout from "./components/artist-about.vue";
import ArtistInfo from "./components/artist-info.vue";
import ArtistService from "./components/artist-service.vue";
import ArtistSongList from "./components/artist-song-list.vue";
import { mapActions } from "vuex";
export default {
  name: "artist",
  components: {
    ArtistAbout,
    ArtistService,
    ArtistInfo,
    ArtistSongList,
    AlbumCard2,
  },
  
  methods: {
    ...mapActions("artists", ["getArtist", "getPhotos"]),

    async loadArtist(artistId) {
      await this.getArtist(artistId);
    },

    async loadPhoto(artistId) {
      await this.getPhotos(artistId);
    },
  },
  async created() {
    const artistId = this.$route.params.id;
    await this.loadArtist(artistId);
    await this.loadPhoto(artistId);
  },
};
</script>

<style lang="scss" scoped></style>

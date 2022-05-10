<template>
  <div>
    <artist-info />
    <artist-service />
    <artist-song-list />
    <album-card-2 />
    <artist-about />
  </div>
</template>

<script>
import AlbumCard2 from "@/components/AlbumCard2.vue";
import ArtistAbout from "./components/artist-about.vue";
import ArtistInfo from "./components/artist-info.vue";
import ArtistService from "./components/artist-service.vue";
import ArtistSongList from "./components/artist-song-list.vue";
export default {
  name: "artist",
  components: {
    ArtistAbout,
    ArtistService,
    ArtistInfo,
    ArtistSongList,
    AlbumCard2,
  },
  // setup() {

  // },
};
</script>

<style lang="scss" scoped></style>

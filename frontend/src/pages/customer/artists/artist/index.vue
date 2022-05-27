<template>
  <div>
    <artist-info :artist="artist" />
    <artist-service />
    <artist-song-list />
    <album-card-2 />
    <artist-about  :socials="socials" :artist="artist" :images="images"/>
  </div>
</template>

<script>
import AlbumCard2 from "@/components/customer/AlbumCard2.vue";
import ArtistAbout from "./components/artist-about.vue";
import ArtistInfo from "./components/artist-info.vue";
import ArtistService from "./components/artist-service.vue";
import ArtistSongList from "./components/artist-song-list.vue";
import { mapActions, mapGetters } from "vuex";
export default {
  name: "artist",
  components: {
    ArtistAbout,
    ArtistService,
    ArtistInfo,
    ArtistSongList,
    AlbumCard2,
  },
  computed: {
    ...mapGetters("artists", ["artist", "socials", "images"]),
  },
  methods: {
    ...mapActions("artists", ["getArtist", "getSocials", "getImages"]),
    
     getArtists({ artistId }) {
       this.getArtist(artistId);
    },
     getSocial({ artistId }) {
       this.getSocials(artistId);
    },
     getImage({ artistId }) {
       this.getImages(artistId);
    },
  },  
   created() {
    const artistId = this.$route.params.id;
     this.getArtists({ artistId });
     this.getSocial({ artistId });
     this.getImage({artistId});
    
  },
};
</script>

<style lang="scss" scoped></style>

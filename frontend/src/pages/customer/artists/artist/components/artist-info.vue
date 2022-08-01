<template>
  <v-container id="artist" fluid>
    <v-row justify="space-around">
      <v-card width="100%">
        <v-img height="320px" :src="artist.photos[0] ? artist.photos[0].link : null">
          <v-card-title class="white--text d-block titleArtists">
            <h1 class="display-3 font-weight-bold">{{ artist.nickName }}</h1>
            <p class="display-0">Followers: {{artist.totalFollowers}}</p>
          </v-card-title>
        </v-img>
      </v-card>
    </v-row>
    <router-view class="px-7"></router-view>
  </v-container>
</template>

<script>
import { mapGetters } from "vuex";
export default {
  name: "ArtistInfo",
  computed: {
    ...mapGetters("artist", ["artist"]),
  },

  components: {},
};
</script>

<style lang="scss" scoped>
.titleArtists {
  margin-top: 130px;

  & > h3 {
    margin-top: 10px;
  }
}
</style>

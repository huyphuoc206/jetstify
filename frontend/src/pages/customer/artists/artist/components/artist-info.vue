<template>
  <v-container id="artist" fluid>
    <v-row justify="space-around">
      <v-card width="100%">
        <v-img
          height="320px"
          :src= artist.thumbnail
        >
          <v-card-title class="white--text d-block titleArtits">
            <h1 class="display-3 font-weight-bold">{{ artist.name }}</h1>
            <h3 class="caption">{{ artist.follow }}</h3>
          </v-card-title>
        </v-img>
      </v-card>
    </v-row>
    <router-view class="px-7"></router-view>
  </v-container>
</template>

<script>
export default {
  props: ["artist"],
  name: "ArtistInfo",
  components: {},
};
</script>

<style lang="scss" scoped>
.titleArtits {
  margin-top: 130px;

  & > h3 {
    margin-top: 10px;
  }
}
</style>

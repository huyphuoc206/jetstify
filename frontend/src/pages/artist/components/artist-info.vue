<template>
  <v-container id="artist" fluid>
    <v-row justify="space-around">
      <v-card width="100%">
        <v-img
          height="320px"
          src="https://i.scdn.co/image/4580875e55e928fb680549968b26cc1a53841d34"
        >
          <v-card-title class="white--text d-block titleArtits">
            <h1 class="display-3 font-weight-bold">Foreign Fields</h1>
            <h3 class="caption">110,491 MONTHLY LISTENERS</h3>
          </v-card-title>
        </v-img>
      </v-card>
    </v-row>
    <router-view class="px-7"></router-view>
  </v-container>
</template>

<script>
export default {
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

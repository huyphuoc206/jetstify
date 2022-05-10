<template>
  <v-container id="artist" fluid>
    <v-row justify="space-around">
      <v-card width="100%">
        <v-img height="320px">
          <v-card class="card d-flex">
            <v-avatar class="profile" color="grey" size="200" >
              <v-img
                src="https://cdn.vuetifyjs.com/images/profiles/marcus.jpg"
              ></v-img>
            </v-avatar>
            <v-card-title class="white--text d-block titleArtits">
              <h1 class="display-3 font-weight-bold">Foreign Fields</h1>
              <h3 class="caption">110,491 MONTHLY LISTENERS</h3>
            </v-card-title>
          </v-card>
        </v-img>
      </v-card>
    </v-row>
    <router-view class="px-7"></router-view>
  </v-container>
</template>

<script>
export default {
  name: "PlaylistInfo",
};
</script>

<style lang="scss" scoped>
.card {
  padding: 30px;
  .titleArtits {
    margin-top: 100px;
    & > h3 {
      margin-top: 10px;
    }
  }
}
</style>

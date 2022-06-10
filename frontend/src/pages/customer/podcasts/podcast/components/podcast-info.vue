<template>
  <v-container id="podcast" fluid>
    <v-row justify="space-around">
      <v-card width="100%">
        <v-img>
          <v-card class="card d-flex">
            <v-avatar class="profile rounded-lg" color="grey" size="200" tile>
              <v-img
                src="https://i.scdn.co/image/ab67656300005f1fc6fb84589b4c059ff911753b"
              ></v-img>
            </v-avatar>
            <v-card-title class="white--text d-block titleArtits">
              <h2 class="caption font-weight-bold">PODCAST</h2>
              <h1 class="display-3 font-weight-bold">{{podcastInfo.name}}</h1>
              <h3 class="display-1 font-weight-bold">{{podcastInfo.name}}</h3>
            </v-card-title>
          </v-card>
        </v-img>
      </v-card>
    </v-row>
    <router-view class="px-7"></router-view>
  </v-container>
</template>

<script>
import { mapGetters } from 'vuex';

export default {
  name: "PodcastInfo",
 
   computed: {
    ...mapGetters("podcast", ["podcastInfo"]),
  },
};
</script>

<style lang="scss" scoped>
.card {
  padding: 30px;
  background: rgb(234, 210, 240);
  background: linear-gradient(
    180deg,
    rgba(234, 210, 240, 0.9836309523809523) 70%,
    rgba(215, 215, 217, 0.8323704481792717) 100%
  );
  .titleArtits {
    padding: 0;
    padding-left: 16px;
    & > h1 {
      margin-top: 50px;
    }

    & > h3 {
      margin-top: 35px;
    }
  }
}
</style>

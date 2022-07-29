<template>
  <v-container id="artist" fluid>
    <v-row justify="space-around">
      <v-card width="100%">
        <v-img height="320px">
          <v-card class="card d-flex">
            <v-avatar class="profile" color="grey" size="200" tile>
              <v-img
                v-if="playlist.thumbnail"
                :src="playlist.thumbnail"
              ></v-img>

              <v-icon v-else dark size="50"> fa-thin fa-music</v-icon>
            </v-avatar>
            <v-card-title class="white--text d-block titleArtits">
              <h1
                class="display-3 font-weight-bold"
                @click="handleSettingPlaylist"
              >
                {{ playlist.namePlaylist }}
              </h1>
              <h3 class="caption">{{ playlist.description }}</h3>
              <h3 class="caption">{{ playlist.nameUserCreate }}</h3>
            </v-card-title>
          </v-card>
        </v-img>
      </v-card>
    </v-row>
    <router-view class="px-7"></router-view>
  </v-container>
</template>

<script>
import { mapActions, mapGetters } from "vuex";
export default {
  name: "PlaylistInfo",
  computed: {
    ...mapGetters("playlist", ["playlist"]),
  },

  methods: {
    ...mapActions("playlist", ["setToggleDialog"]),

    handleSettingPlaylist() {
      this.setToggleDialog();
    },
  },
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

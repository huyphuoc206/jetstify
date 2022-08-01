<template>
  <router-link
    class="text-decoration-none"
    :to="{
      name: 'Playlist',
      params: {
        id: playlist.idPlaylist,
      },
    }"
  >
    <v-hover v-slot:default="{ hover }" style="cursor: pointer">
      <v-card class="common-card" flat height="250" width="180">
        <v-card-text>
          <v-img
            :style="{
              borderRadius: '5px',
            }"
            width="250"
            height="150"
            class="elevation-3"
            :src="playlist.thumbnail"
            v-if="playlist && playlist.thumbnail"
          >
          </v-img>
          <v-avatar v-else color="grey" size="120" class="mt-7">
            <v-icon dark size="50"> fa-thin fa-music</v-icon>
          </v-avatar>
          <div
            :style="{
              position: 'absolute',
              cursor: 'auto',
              right: '40px',
              bottom: '110px',
            }"
            v-show="hover"
          >
            <v-icon
              style="cursor: pointer"
              color="green"
              size="70"
              @click="playAllHandle"
              >mdi-play-circle</v-icon
            >
          </div>
        </v-card-text>

        <v-card-text class="pt-0 text-center">
          <p class="body-2 font-weight-medium ma-0 text-truncate white--text">
            <!-- <router-link
            class="white--text text-decoration-none"
            :to="{
              name: 'Album',
              params: {
                id: 1,
              },
            }"
          > -->
            {{ playlist.namePlaylist }}
            <!-- </router-link> -->
          </p>
        </v-card-text>
      </v-card>
    </v-hover>
  </router-link>
</template>

<script>
import { mapActions } from "vuex";
export default {
  props: ["playlist"],
  data: () => ({}),
  name: "PlaylistCard",

  methods: {
    ...mapActions("player", ["playAll"]),

    playAllHandle(e) {
      e.preventDefault();
      this.playAll(this.playlist.songResponseList);
      this.$root.$emit("playAudio");
    },
  },
};
</script>

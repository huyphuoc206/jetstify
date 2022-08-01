<template>
  <v-container>
    <v-icon style="cursor: pointer" color="green" size="70" @click="playAllHandle">mdi-play-circle</v-icon>
    <span v-if="isAuthenticated">
    <v-btn
      v-if="!!artist.followId"
      class="ml-3 btn"
      text
      depressed
      @click="unFollow(artist.followId)"
    >
      unFollow
    </v-btn>
    <v-btn v-else class="ml-3 btn" text depressed @click="follow()">
      Follow
    </v-btn>
    </span>
    <!-- <v-menu transition="slide-y-transition" offset-y>
      <template v-slot:activator="{ on, attrs }">
        <v-btn class="ml-3" dark v-bind="attrs" v-on="on"> ... </v-btn>
      </template>

      <v-list>
        <v-list-item v-for="(item, i) in items" :key="i">
          <v-list-item-title>{{ item.name }}</v-list-item-title>
        </v-list-item>
      </v-list>
    </v-menu> -->
  </v-container>
</template>

<script>
import { mapGetters, mapActions } from "vuex";
export default {
  name: "ArtistService",
  computed: {
    ...mapGetters("artist", ["artist", "songs"]),
    ...mapGetters("auth", ["isAuthenticated"]),
  },
  methods: {
    ...mapActions("artist", ["followArtist", "unFollowArtist"]),
    ...mapActions("player", ["playAll"]),

    playAllHandle(e) {
      e.preventDefault();
      this.playAll(this.songs);
      this.$root.$emit("playAudio");
    },

    async follow() {
      await this.followArtist();
    },
    async unFollow(followId) {
      await this.unFollowArtist(followId);
    },
  },
  data: () => ({
    items: [
      { name: "Follow", type: "" },
      { name: "Go to artist radio", type: "" },
      { name: "Copy link to artist", type: "" },
    ],
  }),
};
</script>

<style lang="scss"></style>

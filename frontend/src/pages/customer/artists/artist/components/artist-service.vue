<template>
  <v-container>
    <v-icon color="green" size="70">mdi-play-circle</v-icon>
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
    <v-menu transition="slide-y-transition" offset-y>
      <template v-slot:activator="{ on, attrs }">
        <v-btn class="ml-3" dark v-bind="attrs" v-on="on"> ... </v-btn>
      </template>

      <v-list>
        <v-list-item v-for="(item, i) in items" :key="i">
          <v-list-item-title>{{ item.name }}</v-list-item-title>
        </v-list-item>
      </v-list>
    </v-menu>
  </v-container>
</template>

<script>
import { mapGetters, mapActions } from "vuex";
export default {
  name: "ArtistService",
  computed: {
    ...mapGetters("artist", ["artist"]),
  },
  methods: {
    ...mapActions("artist", ["followArtist", "unFollowArtist"]),
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

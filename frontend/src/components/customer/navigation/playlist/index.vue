<template>
  <div>
    <v-list-item
      v-for="item in itemMain"
      :key="item.title"
      :to="link"
      link
      dense
      exact
    >
      <div @click="onSelect()" class="d-flex">
        <v-list-item-icon>
          <v-icon class="item__list" color="grey">{{ item.icon }}</v-icon>
        </v-list-item-icon>

        <v-list-item-content class="item__list-content">
          <v-list-item-title class="item__list">{{
            item.title
          }}</v-list-item-title>
        </v-list-item-content>
      </div>
    </v-list-item>
    <div style="height: calc(20vh); overflow: auto">
      <v-list-item
        v-for="item in playlists"
        :key="item.idPlaylist"
        link
        dense
        exact
      >
        <item-playlist :item="item"></item-playlist>
      </v-list-item>
    </div>
  </div>
</template>

<script>
import { mapActions, mapGetters } from "vuex";
import ItemPlaylist from "./item-playlist.vue";
export default {
  components: { ItemPlaylist },
  data() {
    return {
      itemMain: [
        {
          title: "Create Playlist",
          icon: "mdi-plus",
          name: "CreatePlaylist",
        },
      ],
      itemPlayList: [{}],
    };
  },
  computed: {
    ...mapGetters("playlist", ["playlists", "playlist"]),
    link: {
      get() {
        return `/playlist/${this.playlists.length + 1}`;
      },
    },
  },

  methods: {
    ...mapActions("playlist", ["createPlaylist", "getPlaylist", "getPlaylistById"]),
    onSelect() {
      this.createPlaylist();
    },
    loadPlaylist() {
      this.getPlaylist();
    },
  },
  async created() {
    await this.loadPlaylist();
  },
};
</script>

<style></style>

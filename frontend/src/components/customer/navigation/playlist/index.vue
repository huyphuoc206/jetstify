<template>
  <div v-if="isAuthenticated">
    <v-list-item v-for="item in itemMain" :key="item.title" link dense exact>
      <div @click="onSelect()" class="d-flex">
        <v-list-item-icon>
          <v-icon class="item__list" color="grey">{{ item.icon }}</v-icon>
        </v-list-item-icon>

        <v-list-item-content class="item__list-content grey--text">
          <v-list-item-title class="item__list" >{{
            item.title
          }}</v-list-item-title>
        </v-list-item-content>
      </div>
    </v-list-item>
    <div style="height: calc(30vh); overflow: auto">
      <v-list>
        <v-list-item
          v-for="item in playlists"
          :key="item.idPlaylist"
          :to="`/playlist/${item.idPlaylist}`"
          link
          dense
          exact
        >
          <item-playlist class="grey--text" :item="item"></item-playlist>
        </v-list-item>
      </v-list>
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
    ...mapGetters("playlist", ["playlists"]),
    ...mapGetters("auth", ["isAuthenticated"]),
  },

  methods: {
    ...mapActions("playlist", ["createPlaylist", "getPlaylist"]),
    async onSelect() {
      await this.createPlaylist();
    },
    async loadPlaylist() {
      await this.getPlaylist();
    },
  },
  async created() {
    this.isAuthenticated && (await this.loadPlaylist());
  },
};
</script>

<style>

</style>

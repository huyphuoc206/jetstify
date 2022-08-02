<template>
  <v-navigation-drawer
    v-model="drawer"
    permanent
    dark
    app
    color="black"
    width="230px"
  >
    <v-list>
      <v-list-item class="mb-5" @click="$router.push('/')">
        <v-avatar size="70">
          <img src="@/assets/IMG_0602.jpg" alt="avatar" />
        </v-avatar>
        <v-card-text class="text-h5 font-weight-bold">Jestify</v-card-text>
      </v-list-item>
      <v-list-item
        v-for="item in menus"
        :key="item.title"
        :to="item.link"
        link
        dense
        exact
      >
        <v-list-item-icon>
          <v-icon class="item__list" color="grey">{{ item.icon }}</v-icon>
        </v-list-item-icon>

        <v-list-item-content class="item__list-content">
          <v-list-item-title class="item__list">{{
            item.title
          }}</v-list-item-title>
        </v-list-item-content>
      </v-list-item>
    </v-list>

    <v-list>
      <playlist></playlist>
    </v-list>
  </v-navigation-drawer>
</template>
<script>
import Playlist from "./playlist/index";
import { mapGetters } from "vuex";

export default {
  components: { Playlist },
  computed: {
    ...mapGetters("auth", ["isAuthenticated"]),

    menus() {
      if (this.isAuthenticated) {
        return this.items;
      } else {
        return this.items.filter((e) => !e.requiredAuth);
      }
    },
  },
  data() {
    return {
      drawer: true,
      mini: true,

      items: [
        { title: "Home", icon: "mdi-home-city", link: "/", name: "Home" },
        {
          title: "Search",
          icon: "mdi-magnify",
          link: "/search",
          name: "Search",
        },
        {
          title: "Artists Following",
          icon: "mdi-human-child",
          link: "/artists",
          name: "Artists",
          requiredAuth: true,
        },
        {
          title: "Your Playlists",
          icon: "mdi-music",
          link: "/playlists",
          name: "Playlists",
          requiredAuth: true,
        },
        // {
        //   title: "Queue",
        //   icon: "mdi-format-list-checkbox",
        //   link: "/queue",
        //   name: "Queue",
        // },

        // {
        //   title: "Liked Songs",
        //   icon: "mdi-account-group-outline",
        //   link: "/track",
        //   name: "Track",
        // },
        // {
        //   title: "Artist",
        //   icon: "mdi-magnify",
        //   link: "/artist/1",
        //   name: "Artist",
        // },
        // {
        //   title: "Album",
        //   icon: "mdi-magnify",
        //   link: "/album/1",
        //   name: "Album",
        // },
        // {
        //   title: "Albums",
        //   icon: "mdi-magnify",
        //   link: "/albums",
        //   name: "Albums",
        // },

        
        // {
        //   title: "Podcasts",
        //   icon: "mdi-magnify",
        //   link: "/podcasts",
        //   name: "Podcasts",
        // },
        // {
        //   title: "Podcast",
        //   icon: "mdi-magnify",
        //   link: "/podcast/1",
        //   name: "Podcast",
        // },
      ],
    };
  },
};
</script>
<style lang="scss">
.item__list-content {
  color: grey;
}
.v-list-item--active {
  .item__list {
    color: white !important;
  }
}
</style>

<template>
  <v-navigation-drawer
    v-model="drawer"
    :mini-variant.sync="mini"
    permanent
    expand-on-hover
    dark
    app
  >
    <v-list>
      <v-list-item
        v-for="item in items"
        :key="item.title"
        :to="{ name: item.name }"
        link
        dense
        exact
      >
        <v-list-item-icon>
          <v-icon>{{ item.icon }}</v-icon>
        </v-list-item-icon>

        <v-list-item-content>
          <v-list-item-title>{{ item.title }}</v-list-item-title>
        </v-list-item-content>
      </v-list-item>
    </v-list>
  </v-navigation-drawer>
</template>
<script>
export default {
  name: "AppNavigation",
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
          title: "Create Playlist",
          icon: "mdi-plus",
          link: "/playlist",
          name: "Playlist",
        },
         {
          title: "Playlists",
          icon: "mdi-plus",
          link: "/playlists",
          name: "Playlists",
        },
        {
          title: "Queue",
          icon: "mdi-format-list-checkbox",
          link: "/queue",
          name: "Queue",
        },
        {
          title: "Login",
          icon: "mdi-home-city",
          link: "/login",
          name: "Login",
        },
        {
          title: "Users",
          icon: "mdi-account-group-outline",
          link: "/user/1",
          name: "User",
        },
        {
          title: "Liked Songs",
          icon: "mdi-account-group-outline",
          link: "/track",
          name: "Track",
        },
        {
          title: "Users Management",
          icon: "mdi-account-group-outline",
          link: "/user-management",
          name: "UserManagement",
        },
        {
          title: "Artist",
          icon: "mdi-magnify",
          link: "artist/1",
          name: "Artist",
        },
        {
          title: "Album",
          icon: "mdi-magnify",
          link: "album/1",
          name: "Album",
        },
        {
          title: "Albums",
          icon: "mdi-magnify",
          link: "/albums",
          name: "Albums",
        },

        {
          title: "Artists",
          icon: "mdi-magnify",
          link: "/artists",
          name: "Artists",
        },
        {
          title: "Podcasts",
          icon: "mdi-magnify",
          link: "/podcasts",
          name: "Podcasts",
        },
            {
          title: "Podcast",
          icon: "mdi-magnify",
          link: "/podcast/1",
          name: "Podcast",
        },
      ],
    };
  },
};
</script>

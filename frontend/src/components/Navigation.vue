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
          title: "Your Library",
          icon: "mdi-library",
          link: "/collection",
          name: "Collection",
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
          title: "Users Management",
          icon: "mdi-account-group-outline",
          link: "/user-management",
          name: "UserManagement",
        },
        {
          title: "Artist",
          icon: "mdi-magnify",
          link: "/artist/1",
          name: "Artist",
        },
           {
          title: "Album",
          icon: "mdi-magnify",
          link: "/album/1",
          name: "Album",
        },
        {
          title: "Genres",
          icon: "mdi-magnify",
          link: "/genres",
          name: "Genres",
        },
        {
          title: "ArtistOverview",
          icon: "mdi-magnify",
          link: "/overview",
          name: "ArtistOverview",
        },
        {
          title: "ArtistAbout",
          icon: "mdi-magnify",
          link: "/about",
          name: "ArtistAbout",
        },
          {
          title: "Discover",
          icon: "mdi-magnify",
          link: "/discover",
          name: "Discover",
        },
      ],
    };
  },
};
</script>

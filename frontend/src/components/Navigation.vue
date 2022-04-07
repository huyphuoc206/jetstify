<template>
  <v-navigation-drawer
    v-model="drawer"
    :mini-variant.sync="mini"
    permanent
    expand-on-hover
    dark
    app
  >
    <v-list-item class="px-2">
      <v-list-item-avatar>
        <v-img src="https://randomuser.me/api/portraits/men/85.jpg"></v-img>
      </v-list-item-avatar>

      <v-list-item-title>Phuoc Pham</v-list-item-title>
    </v-list-item>

    <v-divider></v-divider>

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
          title: "Browse",
          icon: "mdi-home-city",
          link: "/browse",
          name: "Browse",
        },
        {
          title: "Users Management",
          icon: "mdi-account-group-outline",
          link: "/user-management",
          name: "UserManagement",
        },
        {
          title: "Search",
          icon: "mdi-magnify",
          link: "/search",
          name: "Search",
        },
      ],
    };
  },
};
</script>

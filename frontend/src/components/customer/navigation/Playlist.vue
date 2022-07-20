<template>
  <div>
    <v-list-item
      v-for="item in playlists"
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
  </div>
</template>

<script>
export default {
  data() {
    return {
      playlists: [
        {
          title: "Playlists",
          icon: "mdi-plus",
          link: "/playlists",
          name: "Playlists",
        },
        {
          title: "Create Playlist",
          icon: "mdi-plus",
          link: "/playlist",
          name: "CreatePlaylist",
        },
      ],
    };
  },
  methods: {
    onSelect(item) {
      this.playlists.push(item);
      console.log(this.playlists);
    },
  },
};
</script>

<style></style>

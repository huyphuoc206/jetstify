<template>
  <v-container fluid>
    <v-icon color="green" size="70">mdi-play-circle</v-icon>
    <v-menu transition="slide-y-transition" offset-y>
      <template v-slot:activator="{ on, attrs }">
        <v-btn class="ml-3" dark v-bind="attrs" v-on="on"> ... </v-btn>
      </template>
      <v-list>
        <v-list-item v-for="(item, i) in items" :key="i">
          <v-list-item-title>{{ item.name }}</v-list-item-title>
        </v-list-item>
        <v-list-item-title @click="handleRemoveToggle">
          Delete
        </v-list-item-title>
      </v-list>
    </v-menu>
    <v-simple-table>
      <template v-slot:default>
        <thead>
          <tr>
            <th class="text-left"># TITLE</th>
            <th class="text-left">ALBUM</th>
            <th class="text-left">DATE ADDED</th>
            <th class="text-left">
              <v-icon>mdi-clock-outline</v-icon>
            </th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="item in desserts" :key="item.name">
            <td :style="{ border: 'none' }">{{ item.title }}</td>
            <td :style="{ border: 'none' }">{{ item.album }}</td>
            <td :style="{ border: 'none' }">{{ item.date }}</td>
            <td :style="{ border: 'none' }">{{ item.time }}</td>
          </tr>
        </tbody>
      </template>
    </v-simple-table>
    <dialog-remove
      :dialog="toggleDialogRemove"
      :content="namePlaylist"
      :handleCancel="handleRemoveToggle"
      :handleRemove="handleRemove"
    />
  </v-container>
</template>

<script>
import dialogRemove from "@/components/dialog-remove/dialogRemove.vue";
import { mapActions, mapGetters } from "vuex";
import { $rest } from "@/core/rest-client";
export default {
  components: { dialogRemove },
  name: "PlaylistService",
  data: () => ({
    items: [
      { name: "Follow", type: "" },
      { name: "Go to artist radio", type: "" },
      { name: "Copy link to artist", type: "" },
    ],
    desserts: [
      { title: "Follow", album: "a", date: "1 day ago", time: "3:03" },
      { title: "Follow", album: "s", date: "1 day ago", time: "3:03" },
      { title: "Follow", album: "a", date: "1 day ago", time: "3:03" },
      { title: "Follow", album: "a", date: "1 day ago", time: "3:03" },
      { title: "Follow", album: "a", date: "1 day ago", time: "3:03" },
    ],
  }),

  computed: {
    ...mapGetters("playlist", ["playlist", "toggleDialogRemove"]),

    namePlaylist: {
      get() {
        return this.playlist.namePlaylist;
      },
    },
  },

  methods: {
    ...mapActions("playlist", ["setToggleDialogRemove"]),

    handleRemoveToggle() {
      this.setToggleDialogRemove();
    },

    async handleRemove() {
      const idPlaylist = this.playlist.idPlaylist;

      const { success, message } = await $rest.delete(
        `/playlist/${idPlaylist}`
      );

      if (success) {
        window.location.assign(`${window.location.origin}/playlists`);
      } else {
        this.$notice.error(message);
      }
    },
  },
};
</script>

<style lang="scss"></style>

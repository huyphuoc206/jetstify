<template>
  <v-container fluid>
    <v-icon style="cursor: pointer" color="green" size="70" @click="playAllHandle">mdi-play-circle</v-icon>
    <v-menu transition="slide-y-transition" offset-y>
      <template v-slot:activator="{ on, attrs }">
        <v-btn class="ml-3" dark v-bind="attrs" v-on="on"> ... </v-btn>
      </template>
      <v-list>
        <!-- <v-list-item v-for="(item, i) in items" :key="i">
          <v-list-item-title>{{ item.name }}</v-list-item-title>
        </v-list-item> -->
        <v-list-item>
          <v-list-item-title @click="handleRemoveToggle">
            Delete
          </v-list-item-title>
        </v-list-item>
      </v-list>
    </v-menu>
    <v-simple-table>
      <template v-slot:default>
        <thead>
          <tr>
            <!-- <th class="text-left"># TITLE</th>
            <th class="text-left">ALBUM</th>
            <th class="text-left">DATE ADDED</th>
            <th class="text-left">
              <v-icon>mdi-clock-outline</v-icon>
            </th> -->
          </tr>
        </thead>
        <tbody>
          <tr v-for="(item, index) in results" :key="index">
            <song-list-item :song="item"></song-list-item>
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
import SongListItem from "@/components/customer/SongListItem.vue";
export default {
  components: { dialogRemove, SongListItem },
  name: "PlaylistService",
  data: () => ({
    // items: [
    //   { name: "Follow", type: "" },
    //   { name: "Go to artist radio", type: "" },
    //   { name: "Copy link to artist", type: "" },
    // ],
  }),

  computed: {
    ...mapGetters("playlist", ["playlist", "toggleDialogRemove", "playlist"]),
    results() {
      if (!this.playlist["songResponseList"]) return [];
      return this.playlist["songResponseList"];
    },
    namePlaylist: {
      get() {
        return this.playlist.namePlaylist;
      },
    },
  },

  methods: {
    ...mapActions("playlist", ["setToggleDialogRemove"]),
    ...mapActions("player", ["playAll"]),

    handleRemoveToggle() {
      this.setToggleDialogRemove();
    },

    playAllHandle(e) {
      e.preventDefault();
      this.playAll(this.results);
      this.$root.$emit("playAudio");
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

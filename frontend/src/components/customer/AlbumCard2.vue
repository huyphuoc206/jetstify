<template>
  <div @contextmenu.prevent="$refs.menu.open($event, 'Payload')">
    <ContextMenu ref="menu">
      <template>
        <ContextMenuItem @click.native="addToQueue()">
          Add to queue
        </ContextMenuItem>
        <ContextMenuItem @click.native="addToPlaylist()">
          <div class="text-center">
            <v-menu open-on-hover top offset-x>
              <template v-slot:activator="{ on, attrs }">
                <v-card-text color="primary" dark v-bind="attrs" v-on="on">
                  Add to playlist
                </v-card-text>
              </template>

              <v-list>
                <v-list-item v-for="(item, index) in playlists" :key="index">
                  <v-list-item-title @click="addSongToPlaylist({playlistId:item.idPlaylist,songId:song.songId})">{{ item.namePlaylist }}</v-list-item-title>
                </v-list-item>
              </v-list>
            </v-menu>
          </div>
        </ContextMenuItem>
      </template>
    </ContextMenu>
    <v-hover v-slot:default="{ hover }">
      <v-card class="common-card" flat height="250" width="180">
        <v-card-text>
          <v-img
            :style="{
              borderRadius: '5px',
            }"
            width="250"
            height="150"
            class="elevation-3"
            :src="song.thumbnail"
          >
            <div
              :style="{
                position: 'absolute',
                right: '1px',
                bottom: '1px',
                cursor: 'auto',
              }"
              v-show="hover"
            >
              <v-icon
                v-if="isPlaying && currentSongId === song.songId"
                style="cursor: pointer"
                color="green"
                size="50"
                @click="handlePauseSong"
                >mdi-pause-circle</v-icon
              >
              <v-icon
                v-else
                style="cursor: pointer"
                color="green"
                size="50"
                @click="handlePlaySong"
                >mdi-play-circle</v-icon
              >
            </div>
          </v-img>
        </v-card-text>

        <v-card-text class="pt-0 ma-auto">
          <p class="body-2 font-weight-medium ma-0 text-truncate white--text">
            {{ song.name }}
          </p>
          <p class="caption font-weight-light mb-4 text-truncate">
            <!-- {{ song.artist }} -->
          </p>
        </v-card-text>
      </v-card>
    </v-hover>
  </div>
</template>

<script>
import { mapGetters, mapActions } from "vuex";
import ContextMenu from "../context-menu/ContextMenu.vue";
import ContextMenuItem from "../context-menu/ContextMenuItem.vue";
export default {
  components: {
    ContextMenu,
    ContextMenuItem,
  },
  props: ["song"],
  data: () => ({}),
  name: "AlbumCard2",
  computed: {
    ...mapGetters("player", ["isPlaying", "currentSongId"]),
    ...mapGetters("playlist", ["playlists"]),
  },
  methods: {
    ...mapActions("player", ["setPlaying", "playSong", "addSong"]),
    ...mapActions("playlist", ["getPlaylist", "addSongToPlaylist"]),
    async listPlaylist() {
      await this.getPlaylist();
    },
    handlePlaySong() {
      this.playSong(this.song);
      this.setPlaying(true);
      this.$root.$emit("playAudio");
    },
    handlePauseSong() {
      this.$root.$emit("pauseAudio");
      this.setPlaying(false);
    },

    addToQueue() {
      this.addSong({ song: this.song, isQueue: true });
      this.$refs.menu.close();
    },

    addToPlaylist() {
      console.log("hi");
      this.$refs.menu.close();
    },
  },
  async created() {
    await this.listPlaylist();
  },
};
</script>

<template>
  <v-hover v-slot:default="{ hover }">
    <v-list color="#121212">
      <v-list-item link>
        <v-list-item-content class="py-0">
          <v-row class="align-center">
            <v-col
              cols="auto"
              v-if="isPlaying && currentSongId === song.songId"
            >
              <div class="icon">
                <span />
                <span />
                <span />
              </div>
            </v-col>
            <v-col class="py-0 ml-2" cols="auto">
              <v-img :src="song.thumbnail" width="45px" height="60px">
                <v-overlay absolute opacity="0" :value="hover">
                  <v-icon
                    v-if="isPlaying && currentSongId === song.songId"
                    style="cursor: pointer"
                    color="white"
                    size="25"
                    @click="handlePauseSong"
                    >mdi-pause-circle</v-icon
                  >
                  <v-icon
                    v-else
                    style="cursor: pointer"
                    color="white"
                    size="25"
                    @click="handlePlaySong"
                    >mdi-play-circle</v-icon
                  >
                </v-overlay>
              </v-img>
            </v-col>
            <v-col>
              <v-list-item-title>
                {{ song.name }}
                <!-- <v-list-item-subtitle>
                  <router-link
                    :style="{
                      color: 'rgba(255, 255, 255, 0.7)',
                    }"
                    class="text-decoration-none"
                    :to="{
                      name: 'Artist',
                      params: {
                        id: 1,
                      },
                    }"
                  >
                    Rosario Alfonso
                  </router-link>
                </v-list-item-subtitle> -->
              </v-list-item-title>
            </v-col>
          </v-row>
        </v-list-item-content>

        <v-list-item-action :style="{ color: 'rgba(255, 255, 255, 0.7)' }">
          3:49
        </v-list-item-action>
      </v-list-item>
    </v-list>
  </v-hover>
</template>

<script>
import { mapGetters, mapActions } from "vuex";
export default {
  name: "SongListItem",
  props: ["song"],
  computed: {
    ...mapGetters("player", ["isPlaying", "currentSongId"]),
  },
  methods: {
    ...mapActions("player", ["setPlaying", "playSongInQueue"]),
    handlePlaySong() {
      this.$root.$emit("playAudio");
      if (this.currentSongId === this.song.songId) return;
      this.playSongInQueue(this.song);
      this.setPlaying(true);
    },
    handlePauseSong() {
      this.$root.$emit("pauseAudio");
      this.setPlaying(false);
    },
  },
};
</script>
<style lang="scss" scoped>
.icon {
  position: relative;
  display: flex;
  justify-content: space-between;
  width: 13px;
  height: 13px;
  span {
    width: 3px;
    height: 100%;
    background-color: greenyellow;
    border-radius: 3px;
    transform-origin: bottom;
    animation: bounce 2.2s ease infinite alternate;
    content: "";
    &:nth-of-type(2) {
      animation-delay: -2.2s; /* Start at the end of animation */
    }
    &:nth-of-type(3) {
      animation-delay: -3.7s; /* Start mid-way of return of animation */
    }
  }
}
@keyframes bounce {
  10% {
    transform: scaleY(0.3); /* start by scaling to 30% */
  }
  30% {
    transform: scaleY(1); /* scale up to 100% */
  }
  60% {
    transform: scaleY(0.5); /* scale down to 50% */
  }
  80% {
    transform: scaleY(0.75); /* scale up to 75% */
  }
  100% {
    transform: scaleY(0.6); /* scale down to 60% */
  }
}
</style>
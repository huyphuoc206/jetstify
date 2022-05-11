<template>
  <v-hover v-slot:default="{ hover }" style="cursor: pointer">
    <v-card class="common-card" flat height="250" width="180">
      <v-card-text>
        <v-img
          :style="{
            borderRadius: '5px',
          }"
          width="250"
          height="150"
          class="elevation-3"
          :src="song.img"
        >
          <div
            :style="{
              position: 'absolute',
              right: '10px',
              bottom: '10px',
              cursor: 'auto',
            }"
            v-show="hover"
          >
            <v-icon color="green" size="70">mdi-play-circle</v-icon>
          </div>
        </v-img>
      </v-card-text>

      <v-card-text class="pt-0 ma-auto">
        <p class="body-2 font-weight-medium ma-0 text-truncate white--text">
          <router-link
            class="white--text text-decoration-none"
            :to="{
              name: 'Album',
              params: {
                id: 1,
              },
            }"
          >
            {{ song.name }}
          </router-link>
        </p>
        <p class="caption font-weight-light mb-4 text-truncate">
          {{ song.artist }}
        </p>
      </v-card-text>
    </v-card>
  </v-hover>
</template>

<script>
export default {
  props: ["song"],
  data: () => ({}),
  name: "AlbumCard2",
};
</script>
<style lang="scss"></style>

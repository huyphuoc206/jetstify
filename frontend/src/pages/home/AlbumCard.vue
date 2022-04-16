<template>
  <v-hover v-slot:default="{ hover }" style="cursor: pointer">
    <v-card class="common-card d-flex ma-auto" flat height="90px">
      <v-card class="">
        <v-img
          max-width="100"
          height="100%"
          class="elevation-3"
          :src="song.img"
        >
        </v-img>
      </v-card>

      <v-card-text class="ma-auto">
        <p class="" :style="{ fontSize: '20px' }">
          <router-link
            class="text-decoration-none white--text"
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
        <p class="ma-auto">
          {{ song.artist }}
        </p>

        <v-btn
          elevation="2"
          class="ma-auto play_btn"
          :style="{
            position: 'absolute',
            right: '10px',
            bottom: '17px',
            cursor: 'auto',
          }"
          fab
          v-show="hover"
        >
          <v-icon size="70" color="green">mdi-play-circle</v-icon>
        </v-btn>
      </v-card-text>
    </v-card>
  </v-hover>
</template>

<script>
export default {
  props: ["song"],
  data: () => ({}),
  name: "AlbumCard",
};
</script>
<style lang="scss" scoped></style>

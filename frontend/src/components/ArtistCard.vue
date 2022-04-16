<template>
  <v-hover v-slot:default="{ hover }">
    <v-card class="common-card" flat height="300" width="250">
      <v-card-text>
        <v-img
          height="200"
          class="elevation-10"
          style="border-radius: 50%"
          :src="song.img"
        >
        </v-img>
        <div
          :style="{
            position: 'absolute',
            right: '20px',
            bottom: '85px',
            cursor: 'auto',
          }"
          v-show="hover"
        >
          <v-icon color="green" size="60">mdi-play-circle</v-icon>
        </div>
      </v-card-text>

      <v-card-text class="pt-0">
        <p class="body-2 font-weight-medium ma-0 text-truncate white--text">
          <router-link
            class="white--text text-decoration-none"
            :to="{
              name: 'Artist',
              params: {
                id: 1,
              },
            }"
            >Army of Bones</router-link
          >
        </p>
        <p class="caption font-weight-light mb-4 text-truncate">Artist</p>
      </v-card-text>
    </v-card>
  </v-hover>
</template>
<script>
export default {
  props: ["song"],
  data: () => ({}),
  name: "ArtistCard",
};
</script>
<style lang="scss"></style>

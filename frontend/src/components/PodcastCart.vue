<template>
  <v-hover style="cursor: pointer">
    <v-card class="common-card" flat height="300" width="250">
      <v-card-text>
        <v-img
          :style="{
            borderRadius: '5px',
          }"
          width="300"
          height="200"
          class="elevation-3"
          :src="song.img"
        >
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
  name: "PodcastCard",
};
</script>
<style lang="scss"></style>

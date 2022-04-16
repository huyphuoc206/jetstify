<template>
  <v-card class="common-card" flat height="300" width="250">
    <v-card-text>
      <v-img width="300" height="200" class="elevation-10" :src="song.img">
      </v-img>
    </v-card-text>

    <v-card-text class="pt-0">
      <p class="body-2 font-weight-medium ma-0 text-truncate white--text">
        {{ song.name }}
      </p>
      <p class="caption font-weight-light mb-4 text-truncate">Genre</p>
    </v-card-text>
  </v-card>
</template>

<script>
export default {
  props: ["song"],
  name: "GenreCard",
};
</script>

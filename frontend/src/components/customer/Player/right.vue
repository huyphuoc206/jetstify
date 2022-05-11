<template>
  <v-col class="d-flex justify-end align-center">
    <v-btn :to="{ name: 'Queue' }" icon>
      <v-icon>mdi-playlist-play</v-icon>
    </v-btn>
  </v-col>
</template>

<script>
export default {
  name: "Right",
};
</script>

<style></style>

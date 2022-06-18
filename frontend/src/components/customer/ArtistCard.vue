<template>
  <v-hover v-slot:default="{ hover }">
    <v-card
      class="common-card"
      flat
      height="250"
      width="180"
      @click="goDetail()"
    >
      <v-card-text>
        <v-img
          height="150"
          class="elevation-10"
          style="border-radius: 50%"
          :src="artist.thumbnail"
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
          <v-icon color="green" size="50">mdi-play-circle</v-icon>
        </div>
      </v-card-text>

      <v-card-text class="pt-0">
        <p class="body-2 font-weight-medium ma-0 text-truncate white--text">
          {{ artist.nickName }}
          
        </p>
        <p class="caption font-weight-light mb-4 text-truncate">Artist</p>
      </v-card-text>
    </v-card>
  </v-hover>
</template>
<script>
export default {
  props: ["artist"],
  methods: {
    goDetail() {
      this.$router.push(`/artist/${this.artist.artistId}`);
    },
  },
  data: () => ({}),
  name: "ArtistCard",
};
</script>
<style lang="scss"></style>

<template>
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
          :src="artist.photos[0] ? artist.photos[0].link : null"
        >
        </v-img>
    
      </v-card-text>

      <v-card-text class="pt-0">
        <p class="body-2 font-weight-medium ma-0 text-truncate white--text">
          {{ artist.nickName }}
          
        </p>
        <p class="caption font-weight-light mb-4 text-truncate">Artist</p>
      </v-card-text>
    </v-card>
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

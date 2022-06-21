<template>
  <v-hover style="cursor: pointer">
    <v-card
      class="common-card"
      flat
      height="250"
      width="180"
      @click="goDetail()"
    >
      <v-card-text>
        <v-img
          :style="{
            borderRadius: '5px',
          }"
          width="200"
          height="150"
          class="elevation-3"
          :src="podcast.thumbnail"
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
            {{ podcast.id }}
          </router-link>
        </p>
        <p class="caption font-weight-light mb-4 text-truncate">
          {{ podcast.podcastId }}
        </p>
      </v-card-text>
    </v-card>
  </v-hover>
</template>

<script>
export default {
  methods: {
    goDetail() {
      this.$router.push(`/podcast/${this.podcast.podcastId}`);
    },
  },
  props: ["podcast"],
  data: () => ({
  }),
  name: "PodcastCard",
};
</script>
<style lang="scss"></style>

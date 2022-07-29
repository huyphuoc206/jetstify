<template>
  <router-link
    class="text-decoration-none"
    :to="{
      name: 'Category',
      params: {
        id: category.id,
        categoryName: category.name,
      },
    }"
  >
    <v-card
      class="common-card"
      flat
      height="200"
      width="180"
      :style="{
        background: randomColor(),
      }"
    >
      <v-card-text> </v-card-text>

      <v-card-text class="pt-0 ma-auto">
        <p
          class="body-2 font-weight-medium ma-0 white--text text-decoration-none text-md-h4"
        >
          {{ category.name }}
        </p>
        <p class="caption font-weight-light mb-4 text-truncate">
          <!-- {{ song.artist }} -->
        </p>
      </v-card-text>
    </v-card>
  </router-link>
</template>

<script>
export default {
  props: ["category"],
  data: () => ({}),
  name: "CategoryCard",
  methods: {
    randomColor() {
      const colorOne = "#" + Math.floor(Math.random() * 16777215).toString(16);
      const colorTwo = "#" + Math.floor(Math.random() * 16777215).toString(16);
      const angle = Math.floor(Math.random() * 360);
      return `linear-gradient(${angle}deg, ${colorOne}, ${colorTwo})`;
    },
  },
};
</script>
<style lang="scss"></style>

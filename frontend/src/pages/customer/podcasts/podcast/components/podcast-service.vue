<template>
  <v-container>
    <v-btn class="ml-3 btn" text depressed> Follow </v-btn>

    <v-menu min-width="200px" transition="slide-y-transition" offset-y>
      <template v-slot:activator="{ on, attrs }">
        <v-btn class="ml-3 btn" text dark v-bind="attrs" v-on="on"> ... </v-btn>
      </template>

      <v-list>
        <v-list-item v-for="(item, i) in items" :key="i">
          <v-list-item-title>{{ item.name }}</v-list-item-title>
        </v-list-item>
      </v-list>
    </v-menu>
  </v-container>
</template>

<script>
export default {
  name: "PodcastService",
  data: () => ({
    items: [
      { name: "Follow", type: "" },
      { name: "Share", type: "" },
    ],
  }),
};
</script>

<style lang="scss">
.btn {
  border-style: solid;
  border-color: white;
}
</style>

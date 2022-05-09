<template>
  <v-container fluid>
    <v-menu transition="slide-y-transition" offset-y>
      <template v-slot:activator="{ on, attrs }">
        <v-btn class="ml-3" dark v-bind="attrs" v-on="on"> ... </v-btn>
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
  name: "PlaylistService",
  data: () => ({
    items: [
      { name: "Follow", type: "" },
      { name: "Go to artist radio", type: "" },
      { name: "Copy link to artist", type: "" },
    ],
  }),
};
</script>

<style lang="scss"></style>

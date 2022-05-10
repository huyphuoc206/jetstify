<template>
  <v-hover v-slot:default="{ hover }">
    <v-list-item link>
      <v-list-item-content class="py-0">
        <v-row class="align-center">
          <v-col class="py-0" cols="auto">
            <v-icon>{{ hover ? "mdi-play" : "mdi-music-note-outline" }}</v-icon>
          </v-col>

          <v-col class="py-0" cols="auto">
            <v-avatar tile>
              <img
                src="https://i.ytimg.com/vi/FN7ALfpGxiI/maxresdefault.jpg"
                alt="Son Tung"
              />
            </v-avatar>
          </v-col>

          <v-col>
            <p class="subtitle-2">Kill Me in The Morning</p>
          </v-col>

          <v-col>
            <p class="subtitle-2">155,997,05</p>
          </v-col>

          <v-col class="py-0" cols="auto">
            <v-icon>favorite_border</v-icon>
          </v-col>

          <v-col cols="auto"> 3:49 </v-col>

          <v-menu transition="slide-y-transition" offset-y v-if="hover">
            <template v-slot:activator="{ on, attrs }">
              <v-btn dark v-bind="attrs" v-on="on"> ... </v-btn>
            </template>

            <v-list>
              <v-list-item v-for="(item, i) in items" :key="i">
                <v-list-item-title>{{ item.name }}</v-list-item-title>
              </v-list-item>
            </v-list>
          </v-menu>
        </v-row>
      </v-list-item-content>
    </v-list-item>
  </v-hover>
</template>

<script>
export default {
  name: "SongListItem2",
  data: () => ({
    items: [
      { name: "Follow", type: "" },
      { name: "Go to artist radio", type: "" },
      { name: "Copy link to artist", type: "" },
    ],
  }),
};
</script>

<style lang="scss" scoped></style>
